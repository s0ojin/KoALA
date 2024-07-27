package com.ssafy.global.common;

import com.ssafy.domain.user.model.entity.User;
import com.ssafy.domain.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserInfoProvider {
    private final UserRepository userRepository;

    public UserInfoProvider(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public User getCurrentUser() {
        Authentication authentication = getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            log.warn("Authentication is null or not authenticated");
            throw new BadCredentialsException("User is not authenticated");
        }
        Object principal = authentication.getPrincipal();
        String loginId = principal instanceof UserDetails ? ((UserDetails) principal).getUsername() : principal.toString();
        return userRepository.findByLoginId(loginId)
                .orElseThrow(() -> new BadCredentialsException("User not found with login ID: " + loginId));
    }

    public Long getCurrentUserId() {
        Authentication authentication = getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            log.warn("Authentication is null or not authenticated");
            return null;
        }
        Object principal = authentication.getPrincipal();
        String loginId = principal instanceof UserDetails ? ((UserDetails) principal).getUsername() : principal.toString();

        return userRepository.findByLoginId(loginId)
                .map(User::getUserId)
                .orElseThrow(() -> new BadCredentialsException("No user found with login ID: " + loginId));
    }

    public String getCurrentLoginId() {
        Authentication authentication = getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            log.warn("Authentication is null or not authenticated");
            throw new BadCredentialsException("User is not authenticated");
        }
        Object principal = authentication.getPrincipal();
        return principal instanceof UserDetails ? ((UserDetails) principal).getUsername() : principal.toString();
    }

    public String getCurrentNickname() {
        Authentication authentication = getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            log.warn("Authentication is null or not authenticated");
            throw new BadCredentialsException("User is not authenticated");
        }
        Object principal = authentication.getPrincipal();
        String loginId = principal instanceof UserDetails ? ((UserDetails) principal).getUsername() : principal.toString();

        return userRepository.findByLoginId(loginId)
                .map(User::getNickname)
                .orElseThrow(() -> new BadCredentialsException("No user found with login ID: " + loginId));
    }
}
