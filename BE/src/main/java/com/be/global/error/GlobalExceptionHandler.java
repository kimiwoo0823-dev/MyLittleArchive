package com.be.global.error;

import com.be.global.error.exception.ErrorCode;
import com.be.global.error.exception.UserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserException.class)
    public ResponseEntity<ErrorResponse> handleUserException(UserException e) {
        ErrorCode errorCode = e.getErrorCode();
        Integer code = errorCode.getCode();
        String message = errorCode.getMessage();
        log.warn("{}: {}", code, message);
        return ResponseEntity.status(code).body(ErrorResponse.res(code, message));
    }
}
