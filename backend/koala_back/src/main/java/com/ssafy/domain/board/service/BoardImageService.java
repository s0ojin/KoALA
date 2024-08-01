package com.ssafy.domain.board.service;

import com.ssafy.domain.board.model.dto.request.BoardImageRequest;
import com.ssafy.domain.board.model.entity.Board;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BoardImageService {
    List<String> saveBoardImages(Long boardId, List<MultipartFile> boardImages) throws IOException;
    String saveBoardImage(MultipartFile multipartFile, Board board);
}
