package com.example.tododevelop.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionStatus {

    PASSWORDS_DO_NOT_MATCH(401,"\uD83E\uDEF8 비밀번호가 일치 하지 않습니다."),
    POST_IS_EMPTY(404,"\uD83E\uDEF8  해당 게시글이 존재 하지 않습니다."),
    USER_IS_NOT_EXIST(404,"\uD83E\uDEF8  사용자가 존재 하지 않습니다."),
    USEREMAIL_iS_EXIST(409,"\uD83E\uDEF8  이미 등록된 이메일입니다.");

    private final int statusCode;
    private final String message;

}
