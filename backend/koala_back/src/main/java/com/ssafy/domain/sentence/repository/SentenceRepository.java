package com.ssafy.domain.sentence.repository;

import com.ssafy.domain.sentence.model.entity.Sentence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SentenceRepository extends JpaRepository<Sentence, Long> {
    @Query(value = "SELECT * FROM Sentence WHERE topic = :topic ORDER BY RAND() LIMIT 10", nativeQuery = true)
    List<Sentence> findRandomSentencesByTopic(@Param("topic") String topic);


}
