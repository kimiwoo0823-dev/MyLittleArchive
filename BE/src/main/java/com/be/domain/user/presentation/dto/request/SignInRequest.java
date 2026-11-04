package com.be.domain.user.presentation.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

public record SignInRequest (
        @JsonProperty("login_id")
        String loginId,
        String password
) {
    @Builder
    public SignInRequest (
            String loginId,
            String password
    ) {
        this.loginId = loginId;
        this.password = password;
    }
}
