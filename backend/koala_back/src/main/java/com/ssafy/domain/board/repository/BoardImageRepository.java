package com.ssafy.domain.board.repository;

import com.ssafy.domain.board.model.entity.BoardImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardImageRepository extends JpaRepository<BoardImage, Long> {
}
