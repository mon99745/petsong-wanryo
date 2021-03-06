package com.study.demoProject.config;

import com.study.demoProject.config.auth.PrincipalDetailService;
import com.study.demoProject.domain.user.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.RememberMeConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity // 시큐리티 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PrincipalDetailService principalDetailService;

    @Bean //@Bean을 통해 비밀번호 암호화 스프링 부트 2.0부터는 필수
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(principalDetailService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // 페이지에 관한 권한 설정
                .csrf()
                    .disable() //csrf 토큰 해제
                .authorizeRequests() // URL별 권한 관리를 설정하는 옵션
                    .antMatchers("/","/index","/auth/**","/js/**", "/css/**","/image/**").permitAll()
                    .antMatchers("/layout/**","/MainMenu/**").permitAll()
//                  .antMatchers("/").hasRole("USER") // USER, ADMIN만 접근 가능
//                  .antMatchers("/admin/**").hasRole("ADMIN") // ADMIN만 접근 가능
//                  .antMatchers("/index/admin").hasAuthority(Role.ADMIN.getKey()) //"/index/admin" 경로는 "ADMIN" 권한을 가진 사용자만 접근 가능
//                  .antMatchers("/index/user").hasAuthority(Role.USER.getKey()) //"/index/user" 경로는 "USER" 권한을 가진 사용자만 접근 가능
                    .anyRequest().authenticated()
                    .and()

                //로그인에 관한 권한 설정
                .formLogin() //권한이 없는 사람이 페이지를 이동하려고 하면 로그인 페이지로 이동
                    .loginPage("/auth/user/login") //해당하는 로그인 페이지 URL로 이동
                    //loginProcessingUrl에 form의 action url을 여기다 적어줍니다.
                    ///auth/user/login이 URL의 API Controller를 작성하지 않는 이유는 스프링 시큐리티가 얘를 가로채서 대신 작업을 수행해줍니다.
                    .loginProcessingUrl("/auth/user/login") //시큐리티가 해당 주소로 요청오는 로그인을 가로채서 대신 로그인
                    .defaultSuccessUrl("/") //로그인이 성공하면 해당 URL로 이동
//                    .successForwardUrl("/")
                .and()
                .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/auth/user/login")
                    .invalidateHttpSession(true); //세션 날리기


        // 보류 remember.me
        http
                .rememberMe().tokenValiditySeconds(60 * 60 * 7) // 쿠키를 얼마나 유지할 것인지 계산합니다. (7일 설정)
                .userDetailsService(principalDetailService);

    }

    @Bean
    @Override
    // 회원수정 후에 세션을 유지하기 위해 코드를 수정
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}

