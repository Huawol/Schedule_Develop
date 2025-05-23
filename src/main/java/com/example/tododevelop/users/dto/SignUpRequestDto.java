package com.example.tododevelop.users.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class SignUpRequestDto {

    @NotNull(message = "이름을 입력해주세요")
    @Size(min=1, max=10, message = "\uD83E\uDEF8 10글자 이하로 입력해주세요!!")
    private final String userName;


    private final String userEmail;

    @NotBlank(message = "비밀번호 입력해주세요")
    private final String userPassword;

    public SignUpRequestDto(String userName, String userEmail, String userPassword) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }
}
