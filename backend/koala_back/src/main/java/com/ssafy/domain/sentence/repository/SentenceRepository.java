package com.ssafy.domain.sentence.repository;

import com.ssafy.domain.sentence.model.entity.Sentence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SentenceRepository extends JpaRepository<Sentence, Long> {

}
