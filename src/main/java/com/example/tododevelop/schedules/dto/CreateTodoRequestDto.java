package com.example.tododevelop.schedules.dto;

import lombok.Getter;

@Getter
public class CreateTodoRequestDto {

    private final String title;
    private final String contents;
    private final Long userId;

    public CreateTodoRequestDto(String title, String contents, Long userId) {
        this.title = title;
        this.contents = contents;
        this.userId = userId;
    }
}
