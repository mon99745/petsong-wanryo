package com.study.demoProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    /**
     * 회원로그인 페이지
     */
    @GetMapping("/auth/user/login")
    public String userLogin() {
        return "TopMenu/user/login";
    }

    /**
     * 회원가입 페이지
     */
    @GetMapping("/auth/user/save")
    public String userSave() {
        return "TopMenu/user/joinus";
    }

    /**
     * 회원페이지
     */
    @GetMapping("/user/page")
    public String userPage() {
        return "TopMenu/user/mypage.html";
    }

    /**
     * 회원수정 페이지
     */
    @GetMapping("/user/update")
    public String userUpdate() {
        return "TopMenu/user/user-update";
    }


}
