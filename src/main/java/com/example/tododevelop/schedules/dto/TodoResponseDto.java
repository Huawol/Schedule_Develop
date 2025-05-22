package com.example.tododevelop.schedules.dto;

import com.example.tododevelop.schedules.entity.Todo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class TodoResponseDto {
    private final Long id;
    private final String title;
    private final String contents;
    private final Long userId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public final LocalDateTime createAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public final LocalDateTime modifiedAt;

    // 게시글 생성 기능 만들때 제작
    public TodoResponseDto(Todo todo) {
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.contents = todo.getContents();
        this.userId = todo.getUsers().getId();
        this.createAt = todo.getCreateAt();
        this.modifiedAt = todo.getModifiedAt();

    }

    // 전체 조회 기능 만들때 제작
    public static TodoResponseDto toDto(Todo todo) {
        return new TodoResponseDto(
                todo.getId(),
                todo.getTitle(),
                todo.getContents(),
                todo.getUsers().getId(),
                todo.getCreateAt(),
                todo.getModifiedAt()
        );
    }
}
