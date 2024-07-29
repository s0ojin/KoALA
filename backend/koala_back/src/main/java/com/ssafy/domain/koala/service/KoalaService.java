package com.ssafy.domain.koala.service;

import com.ssafy.domain.koala.model.dto.request.KoalaNameRequest;
import com.ssafy.domain.koala.model.dto.response.KoalaResponse;

public interface KoalaService {

	KoalaResponse findKoala();

	KoalaResponse updateKoalaName(KoalaNameRequest koalaNameRequest);
}
