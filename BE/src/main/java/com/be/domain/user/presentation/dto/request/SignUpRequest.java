package com.be.domain.user.presentation.dto.request;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignUpRequest {
    @Size(min = 3, max = 30)
    private String loginId;

    private String password;
}
