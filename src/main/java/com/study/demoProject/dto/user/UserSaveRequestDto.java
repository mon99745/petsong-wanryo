package com.study.demoProject.dto.user;

import com.study.demoProject.domain.user.Role;
import com.study.demoProject.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class UserSaveRequestDto {

    private String username;
    private String password;
    private String user_name;
    private String user_nickname;
    private String user_birth;
    private String user_phone;
    private String user_email;
    private String user_address;


    private Role role;

    public User toEntity() {
        return User.builder()
                .username(username)
                .password(password)
                .user_name(user_name)
                .user_nickname(user_nickname)
                .user_birth(user_birth)
                .user_phone(user_phone)
                .user_email(user_email)
                .user_address(user_address)
                .role(Role.USER)
                .build();
    }
}
