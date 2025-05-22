package com.example.tododevelop.schedules.dto;

import com.example.tododevelop.schedules.entity.Todo;
import lombok.Getter;

@Getter
public class TodoResponseDto {
    private final Long id;
    private final String title;
    private final String contents;
    private final String userName;

    // 게시글 생성 기능 만들때 제작
    public TodoResponseDto(Long id, String title, String contents, String userName) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.userName = userName;
    }

    // 전체 조회 기능 만들때 제작
    public static TodoResponseDto toDto(Todo todo) {
        return new TodoResponseDto(
                todo.getId(),
                todo.getTitle(),
                todo.getContents(),
                todo.getUsers().getUserName()
        );
    }
}
