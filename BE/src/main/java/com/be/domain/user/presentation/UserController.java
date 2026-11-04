package com.be.domain.user.presentation;

import com.be.domain.user.presentation.dto.request.SignInRequest;
import com.be.domain.user.presentation.dto.request.SignUpRequest;
import com.be.domain.user.presentation.dto.response.SignInResponse;
import com.be.domain.user.service.SignInService;
import com.be.domain.user.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final SignUpService signUpService;
    private final SignInService signInService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signUp(@RequestBody SignUpRequest signUpRequest) {
        signUpService.execute(signUpRequest);
    }

    @PostMapping("/signin")
    @ResponseStatus(HttpStatus.OK)
    public SignInResponse signIn(@RequestBody SignInRequest signInRequest) {
        return signInService.execute(signInRequest);
    }
}
