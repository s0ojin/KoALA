package com.ssafy.global.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

// 어떤 회원이 API 요청했는지 조회할 수 있는 클래스
public class SecurityUtil {
    public static String getCurrentUserName() {
        final Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        if(authentication== null || authentication.getName() == null){
            throw new RuntimeException("No authentication information");
        }
        return authentication.getName();
    }

    public static String getJWTInfo(){
        return null;
    }
}
