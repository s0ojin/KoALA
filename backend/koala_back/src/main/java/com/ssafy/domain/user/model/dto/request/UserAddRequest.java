package com.ssafy.domain.user.model.dto.request;

import com.ssafy.domain.user.model.entity.User;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.json.JSONObject;

@Getter
@NoArgsConstructor
@Builder
public class UserAddRequest {

    // null, "", "   " 데이터 전부 걸러낸다.
    @NotBlank(message = "유저 아이디는 필수 입력 값입니다.")
    private String loginId;

    @NotBlank(message = "유저 비밀번호는 필수 입력 값입니다.")
    private String password;

    @NotBlank(message = "유저 이름은 필수 입력 값입니다.")
    private String name;

    @NotBlank(message = "유저 닉네임은 필수 입력 값입니다.")
    private String nickname;

    public UserAddRequest(JSONObject jsonObject) {
        this.loginId = jsonObject.getString("loginId");
        this.password = jsonObject.getString("password");
        this.name = jsonObject.getString("name");
        this.nickname = jsonObject.getString("nickname");
    }

    public UserAddRequest(User user) {
        this.loginId = user.getLoginId();
        this.password = user.getPassword();
        this.name = user.getName();
        this.nickname = user.getNickname();
    }

    public UserAddRequest(String loginId, String password, String name, String nickname) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
    }

}
