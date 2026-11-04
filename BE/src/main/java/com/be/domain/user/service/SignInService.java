package com.be.domain.user.service;

import com.be.domain.user.domain.User;
import com.be.domain.user.domain.repository.UserRepository;
import com.be.domain.user.presentation.dto.JwtToken;
import com.be.domain.user.presentation.dto.request.SignInRequest;
import com.be.domain.user.presentation.dto.response.SignInResponse;
import com.be.global.error.exception.ErrorCode;
import com.be.global.error.exception.UserException;
import com.be.global.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SignInService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    @Transactional
    public SignInResponse execute(SignInRequest signInRequest) {
        if (userRepository.existsByLoginId(signInRequest.loginId())) {
            User user = userRepository.findByLoginId(signInRequest.loginId());

            if (!user.getPassword().equals(passwordEncoder.encode(signInRequest.password()))) {
                System.out.println(user.getPassword());
                System.out.println(passwordEncoder.encode(signInRequest.password()));
                throw new UserException(ErrorCode.LOGIN_FAILED);
            }
            JwtToken token = jwtProvider.generateToken(signInRequest.loginId());
            return new SignInResponse(token.getAccessToken(), token.getRefreshToken());
        }
        else {
            throw new UserException(ErrorCode.LOGINID_NOTFOUNDED);
        }
    }
}
