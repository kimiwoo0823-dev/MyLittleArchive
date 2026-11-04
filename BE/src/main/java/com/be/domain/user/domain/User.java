package com.be.domain.user.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Table(name = "tbl_user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    Long id;

    @Column(name = "login_id", unique = true, nullable = false)
    String loginId;

    @Column(name = "password", nullable = false)
    String password;

    @Builder
    public User(String loginId, String password) {
        this.loginId = loginId;
        this.password = password;
    }
}
