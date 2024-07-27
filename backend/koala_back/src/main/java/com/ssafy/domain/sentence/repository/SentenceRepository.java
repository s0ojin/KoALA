package com.ssafy.domain.sentence.repository;

import com.ssafy.domain.sentence.model.entity.Sentence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SentenceRepository extends JpaRepository<Sentence, Long> {
    @Query(value = "SELECT sentence_id, Users.user_id, sentence_text, topic_category, sentence_created_at, sentence_length FROM Sentences JOIN Users ON Sentences.user_id = Users.user_id WHERE topic_category = :topic AND Users.auth_id = 0 ORDER BY RAND() LIMIT 10", nativeQuery = true)
    List<Sentence> findRandomSentencesByTopic(@Param("topic") String topic);

    @Query(value = "SELECT * FROM Sentences WHERE user_id = :userId ORDER BY RAND() LIMIT 10", nativeQuery = true)
    List<Sentence> findRandomSentencesByUser(@Param("userId") Long userId);

    @Query(value = "SELECT sentence_id, Users.user_id, sentence_text, topic_category, sentence_created_at, sentence_length FROM Sentences JOIN Users ON Sentences.user_id = Users.user_id WHERE Users.auth_id = 0 OR Users.user_id = :userId ORDER BY RAND() LIMIT 10", nativeQuery = true)
    List<Sentence> findRandomSentences(@Param("userId") Long userId);

}
