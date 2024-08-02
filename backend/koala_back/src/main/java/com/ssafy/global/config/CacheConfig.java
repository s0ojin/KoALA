package com.ssafy.global.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching // Spring에서 캐시 기능을 활성화
public class CacheConfig {

	@Bean
	public CacheManager cacheManager() {
		// "chatHistory"라는 이름의 캐시를 생성
		// 하나의 캐시를 사용하고 사용자 ID를 키로 사용하여 각 사용자의 데이터를 구분할 예정
		return new ConcurrentMapCacheManager("chatHistory");
	}
}
