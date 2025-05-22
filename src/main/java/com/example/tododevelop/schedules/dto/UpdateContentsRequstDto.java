package com.example.tododevelop.schedules.dto;

import lombok.Getter;

@Getter
public class UpdateContentsRequstDto {

    private final String newContents;

    public UpdateContentsRequstDto(String newContents) {
        this.newContents = newContents;
    }
}
