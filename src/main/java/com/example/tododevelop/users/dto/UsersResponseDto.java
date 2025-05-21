package com.example.tododevelop.users.dto;

import lombok.Getter;

@Getter
public class UsersResponseDto {

    private final String userName;
    private final String userEmail;

    public UsersResponseDto(String userName, String userEmail) {
        this.userName = userName;
        this.userEmail = userEmail;
    }
}
