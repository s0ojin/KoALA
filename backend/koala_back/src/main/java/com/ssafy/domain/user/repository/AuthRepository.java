package com.ssafy.domain.user.repository;

import com.ssafy.domain.user.model.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<Auth, Long> {
    Auth findByAuthName(String authName);
}
