package com.example.tododevelop.users.dto;

import com.example.tododevelop.users.entity.Users;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SignUpResponseDto {

    private final Long id;
    private final String userName;
    private final String userEmail;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime createAt;
    //private final LocalDateTime modifiedAt;

    public SignUpResponseDto(Users users) {
        this.id = users.getId();
        this.userName = users.getUserName();
        this.userEmail = users.getUserEmail();
        this.createAt = users.getCreateAt();
        //this.modifiedAt = users.getModifiedAt();
    }
}
