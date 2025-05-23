package com.example.tododevelop.users.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class LoginRequestDto {

    @NotNull(message = "\uD83E\uDEF8 이메일을 입력해주세요")
    //@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$}", message = "\uD83E\uDEF8 어!! 이메일형식으로 만들어주세요")
    private final String userEmail;

    @NotBlank(message = "\uD83E\uDEF8 비밀번호를 입력해주세요")
    private final String userPassword;

    public LoginRequestDto(String userEmail, String userPassword) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }
}
