package com.example.tododevelop.users.dto;

import com.example.tododevelop.users.entity.Users;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UsersResponseDto {

    private final String userName;
    private final String userEmail;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime createAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime modifiedAt;

    public UsersResponseDto(Users users) {
        this.userName = users.getUserName();
        this.userEmail = users.getUserEmail();
        this.createAt = users.getCreateAt();
        this.modifiedAt = users.getModifiedAt();
    }
}
