package com.ssafy.domain.koala.controller;

import com.ssafy.domain.koala.service.KoalaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
