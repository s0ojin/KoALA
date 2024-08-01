package com.ssafy.domain.board.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.ssafy.domain.board.model.dto.request.BoardImageCreateRequest;
import com.ssafy.domain.board.model.dto.request.BoardImageRequest;
import com.ssafy.domain.board.model.entity.Board;
import com.ssafy.domain.board.model.entity.BoardImage;
import com.ssafy.domain.board.repository.BoardImageRepository;
import com.ssafy.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardImageServiceImpl implements BoardImageService {

    private static final String bucketName = "koalabucket1";
    private final AmazonS3 amazonS3;

    private final BoardImageRepository boardImageRepository;
    private final BoardRepository boardRepository;

    @Override
    public List<String> saveBoardImages(BoardImageRequest boardImageRequest) throws IOException {
        List<String> resultList = new ArrayList<>();

        Board board = boardRepository.findById(boardImageRequest.getBoardId())
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));

        for (MultipartFile multipartFile : boardImageRequest.getBoardImages()) {
            String value = saveBoardImage(multipartFile, board);
            resultList.add(value);
        }

        return resultList;
    }

    @Override
    public String saveBoardImage(MultipartFile multipartFile, Board board) {
        String originalName = multipartFile.getOriginalFilename();
        BoardImageCreateRequest board_image = new BoardImageCreateRequest(originalName);
        String filename = board_image.getImgStoredName();

        try {
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentType(multipartFile.getContentType());
            objectMetadata.setContentLength(multipartFile.getInputStream().available());

            amazonS3.putObject(bucketName, filename, multipartFile.getInputStream(), objectMetadata);

            String boardImgUrl = amazonS3.getUrl(bucketName, filename).toString();
            board_image.setBoardImgUrl(boardImgUrl);
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload file to S3", e);
        }

        boardImageRepository.save(board_image.toEntity(board));

        return board_image.getBoardImgUrl();
    }
}
