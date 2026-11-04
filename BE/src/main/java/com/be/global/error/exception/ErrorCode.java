package com.be.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    LOGIN_FAILED(401, "아이디 또는 비밀번호가 옳지 않습니다."),
    LOGINID_NOTFOUNDED(404, "해당 아이디를 가진 유저가 존재하지 않습니다.");

    private final Integer code;
    private final String message;
}
