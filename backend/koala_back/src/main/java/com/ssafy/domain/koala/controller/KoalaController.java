package com.ssafy.domain.koala.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.domain.koala.model.dto.request.KoalaNameRequest;
import com.ssafy.domain.koala.service.KoalaService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/koalas")
public class KoalaController {

	private final KoalaService koalaService;

	@GetMapping
	public ResponseEntity<?> getKoala() {
		return ResponseEntity.ok().body(koalaService.findKoala());
	}

	@PatchMapping("/{koala_id}")
	public ResponseEntity<?> updateKoalaName(@PathVariable("koala_id") Long koalaId,
		@RequestBody KoalaNameRequest koalaNameRequest) {
		return ResponseEntity.ok().body(koalaService.updateKoalaName(koalaNameRequest, koalaId));
	}

	@GetMapping("/{koala_id}/leaves")
	public ResponseEntity<?> increaseKoalaExp(@PathVariable("koala_id") Long koalaId) {
		return ResponseEntity.ok().body(koalaService.increaseKoalaExp(koalaId));
	}

}
