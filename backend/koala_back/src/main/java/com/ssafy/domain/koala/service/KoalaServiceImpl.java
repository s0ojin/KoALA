package com.ssafy.domain.koala.service;

import com.ssafy.domain.koala.model.dto.request.KoalaNameRequest;
import com.ssafy.domain.koala.model.dto.response.KoalaResponse;
import com.ssafy.domain.koala.model.entity.Koala;
import com.ssafy.domain.koala.repository.KoalaRepository;
import com.ssafy.domain.user.model.entity.User;
import com.ssafy.global.common.UserInfoProvider;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class KoalaServiceImpl implements KoalaService {

	private final KoalaRepository koalaRepository;
	private final UserInfoProvider userInfoProvider;

	@Override
	public KoalaResponse findKoala() {
		return KoalaResponse.toDto(koalaRepository.findByUser(userInfoProvider.getCurrentUser()));
	}

	@Override
	@Transactional
	public KoalaResponse updateKoalaName(KoalaNameRequest koalaNameRequest, Long koalaId) {
		// user 정보와 비교해서 koala의 user 정보가 일치하는지 확인
		User user = userInfoProvider.getCurrentUser();
		Koala koala = koalaRepository.findById(koalaId)
			.orElseThrow(() -> new IllegalArgumentException("해당 id의 코알라 정보가 존재하지 않습니다."));
		if (!koala.getUser().equals(user)) {
			throw new IllegalArgumentException("해당 유저의 코알라 정보와 일치하지 않습니다.");
		}

		// 코알라 이름 변경
		koalaRepository.save(koalaNameRequest.toEntity(koala, koalaNameRequest.getKoalaName()));
		return KoalaResponse.toDto(koala);
	}
}
