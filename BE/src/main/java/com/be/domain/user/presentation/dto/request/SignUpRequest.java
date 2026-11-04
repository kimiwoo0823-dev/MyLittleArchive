package com.be.domain.user.presentation.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;
import lombok.Builder;

public record SignUpRequest (
        @Size(min = 3, max = 30)
        @JsonProperty("login_id")
        String loginId,
        @Size(min = 6, max = 20)
        String password
    ) {
    @Builder
    public SignUpRequest(
            String loginId,
            String password
        ) {
        this.loginId = loginId;
        this.password = password;
    }
}
