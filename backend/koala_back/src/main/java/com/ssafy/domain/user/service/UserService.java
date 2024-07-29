package com.ssafy.domain.user.service;

import com.ssafy.domain.user.model.dto.request.UserSignUpRequest;
import com.ssafy.domain.user.model.dto.request.UserUpdateRequest;
import com.ssafy.domain.user.model.dto.response.UserFindResponse;
import com.ssafy.domain.user.model.dto.response.UserResponse;
import com.ssafy.global.auth.jwt.dto.JwtToken;

public interface UserService {
	UserResponse signUp(UserSignUpRequest userSignUpRequest);

	JwtToken signIn(String loginId, String password);

	JwtToken generateNewAccessToken(String refreshToken);

	boolean checkLoginId(String loginId);

	boolean checkNickname(String nickname);

	UserFindResponse findUser();

	UserResponse updateUser(UserUpdateRequest userUpdateRequest);

	void deleteUser();
}
