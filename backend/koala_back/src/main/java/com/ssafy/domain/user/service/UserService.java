package com.ssafy.domain.user.service;

import com.ssafy.domain.user.model.dto.request.UserAddRequest;
import com.ssafy.domain.user.model.entity.User;
import com.ssafy.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // 회원가입
    @Transactional
    public void signUp(UserAddRequest userAddRequest) {
        userRepository.save(User.builder()
                .loginId(userAddRequest.getLoginId())
                .password(userAddRequest.getPassword())
                .name(userAddRequest.getName())
                .nickname(userAddRequest.getNickname())
                .build());
        // TODO -> 코알라 생성, 권한 생성, 경험치/레벨/유칼립투스 생성
    }

}
