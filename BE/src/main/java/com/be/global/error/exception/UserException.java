package com.be.global.error.exception;

import lombok.Getter;

@Getter
public class UserException extends RuntimeException {
    public final ErrorCode errorCode;

    public UserException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
