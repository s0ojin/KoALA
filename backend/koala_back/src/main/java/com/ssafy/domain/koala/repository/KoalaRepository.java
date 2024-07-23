package com.ssafy.domain.koala.repository;

import com.ssafy.domain.koala.model.entity.Koala;
import com.ssafy.domain.user.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KoalaRepository extends JpaRepository<Koala, Long> {
    Koala findByUser(User user);
}
