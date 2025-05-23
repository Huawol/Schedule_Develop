package com.example.tododevelop.users.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UpdatePasswordRequstDto {

    @NotBlank
    private final String oldPassword;
    @NotBlank
    private final String newPassword;

    public UpdatePasswordRequstDto(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }
}
