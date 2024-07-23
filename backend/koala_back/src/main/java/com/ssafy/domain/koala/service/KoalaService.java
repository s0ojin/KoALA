package com.ssafy.domain.koala.service;

import com.ssafy.domain.koala.model.entity.Koala;
import com.ssafy.domain.koala.repository.KoalaRepository;
import com.ssafy.domain.user.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class KoalaService {

    private final KoalaRepository koalaRepository;

    public void createKoala(User user) {
        Koala koala = new Koala(user, "코알라", 1, 0, 1);
        koalaRepository.save(koala);
    }
}
