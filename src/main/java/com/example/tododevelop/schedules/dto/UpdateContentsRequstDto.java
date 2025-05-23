package com.example.tododevelop.schedules.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UpdateContentsRequstDto {

    @NotNull(message = "\uD83E\uDEF8 내용을 입력해주세요")
    private final String newContents;

    public UpdateContentsRequstDto(String newContents) {
        this.newContents = newContents;
    }
}
