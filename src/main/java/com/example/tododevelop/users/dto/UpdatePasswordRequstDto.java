package com.example.tododevelop.users.dto;

import lombok.Getter;

@Getter
public class UpdatePasswordRequstDto {

    private final String oldPassword;
    private final String newPassword;

    public UpdatePasswordRequstDto(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }
}
