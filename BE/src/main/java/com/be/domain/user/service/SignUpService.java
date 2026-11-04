package com.be.domain.user.service;

import com.be.domain.user.domain.User;
import com.be.domain.user.domain.repository.UserRepository;
import com.be.domain.user.presentation.dto.request.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SignUpService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void execute(SignUpRequest signUpRequest) {

        User user = User.builder()
                .loginId(signUpRequest.getLoginId())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .build();
        userRepository.save(user);
    }
}
