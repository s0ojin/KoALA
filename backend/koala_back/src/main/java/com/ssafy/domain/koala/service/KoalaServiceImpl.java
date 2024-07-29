package com.ssafy.domain.koala.service;

import com.ssafy.domain.koala.model.dto.response.KoalaResponse;
import com.ssafy.domain.koala.repository.KoalaRepository;
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

}
