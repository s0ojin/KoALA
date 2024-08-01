package com.ssafy.domain.board.model.dto.request;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PROTECTED;

@Getter
@Setter
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
public class BoardImageRequest {
    private Long boardId;
    private List<MultipartFile> boardImages = new ArrayList<>();
}
