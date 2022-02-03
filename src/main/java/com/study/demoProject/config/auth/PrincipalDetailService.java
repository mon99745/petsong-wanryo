package com.study.demoProject.config.auth;

import com.study.demoProject.domain.user.User;
import com.study.demoProject.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service // Bean 등록 (IoC)
/*
 UserDetailsService를 상속받게 되면 오버라이딩을 해야하는데 이 메소드는 DB에 username이 있는지 확인하는 메소드입니다.
 PrincipalDetail(principal)을 리턴을 하게 되면 시큐리티의 세션에 유저 정보가 저장됩니다.
*/
public class PrincipalDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    // LoginForm에서 action="/login" 되면
    // 스프링 필터 체인이 낚아채서 loadUserByUsername함수를 호출한다.

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User principal =  userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다. " + username));
        return new PrincipalDetail(principal);
    }
}