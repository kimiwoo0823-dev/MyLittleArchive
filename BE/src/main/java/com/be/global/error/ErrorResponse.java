package com.be.global.error;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

public record ErrorResponse(
        @JsonProperty("error-code")
        Integer errorCode,
        @JsonProperty("error-message")
        String errorMessage
                ) {
    @Builder
    public static ErrorResponse res(
            Integer code,
            String message
    ) {
        return ErrorResponse.builder()
                .code(code)
                .message(message)
                .build();
    }
}
