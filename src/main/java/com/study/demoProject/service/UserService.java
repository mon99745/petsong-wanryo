package com.study.demoProject.service;

import com.study.demoProject.config.auth.PrincipalDetail;
import com.study.demoProject.domain.user.User;
import com.study.demoProject.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor //생성자 주입을 받기 위해
// 스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌. IoC를 해준다.
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    /**
     * 회원가입 로직
     */
    @Transactional
    public Long save(User user) {
        String hashPw = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(hashPw);
        return userRepository.save(user).getCode();
    }

    /**
     * 회원수정 로직
     */
    @Transactional
    // UserService 클래스에서도
    // @AuthenticationPrincipal PrincipalDetail principalDetail를 파라미터로
    // 받아서 update된 유저 정보를 principalDetail에 집어넣는다.
    public Long update(User user,
                       @AuthenticationPrincipal PrincipalDetail principalDetail) {
        User userEntity = userRepository.findByUsername(user.getUsername()).orElseThrow(() -> new IllegalArgumentException("해당 회원이 없습니다. Code=" + user.getUsername()));
        userEntity.update(bCryptPasswordEncoder.encode(user.getPassword()), user.getUser_nickname());
        principalDetail.setUser(userEntity); //추가
        return userEntity.getCode();
    }

}

