package com.example.tododevelop.users.dto;

import lombok.Getter;

@Getter
public class SignUpResponseDto {

    private final Long id;
    private final String userName;
    private final String userEmail;
    private final String userPassword;

    public SignUpResponseDto(Long id, String userName, String userEmail, String userPassword) {
        this.id = id;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }
}
