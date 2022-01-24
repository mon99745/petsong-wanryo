package com.study.demoProject.controller.api;

import com.study.demoProject.config.auth.PrincipalDetail;
import com.study.demoProject.domain.user.User;
import com.study.demoProject.dto.user.UserSaveRequestDto;
import com.study.demoProject.service.UserService;
import com.study.demoProject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    /**
     * 회원가입 API
     */
    @PostMapping("/auth/api/v1/user")
    public Long save(@RequestBody UserSaveRequestDto userSaveRequestDto) {
        return userService.save(userSaveRequestDto.toEntity());
    }

    /**
     * 회원수정 API
     */
    @PutMapping("/api/v1/user")
    // @AuthenticationPrincipal에 PrincipalDetail타입으로 파라미터를 받으면 유저 정보를 얻을 수 있다.
    public Long update(@RequestBody User user, @AuthenticationPrincipal PrincipalDetail principalDetail) {
        userService.update(user, principalDetail);
        return user.getCode();
    }

}
