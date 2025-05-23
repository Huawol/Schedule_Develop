package com.example.tododevelop.schedules.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;


@Getter
public class CreateTodoRequestDto {

    @NotNull(message = "\uD83E\uDEF8 제목을 입력해주세요")
    private final String title;
    @NotNull(message = "\uD83E\uDEF8 내용을 입력해주세요")
    private final String contents;
    @NotNull(message = "\uD83E\uDEF8 ID를 입력해주세요")
    private final Long userId;

    public CreateTodoRequestDto(String title, String contents, Long userId) {
        this.title = title;
        this.contents = contents;
        this.userId = userId;
    }
}
