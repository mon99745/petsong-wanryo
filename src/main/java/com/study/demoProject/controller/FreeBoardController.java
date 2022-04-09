package com.study.demoProject.controller;

import com.study.demoProject.service.FreeBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class FreeBoardController {

    private final FreeBoardService freeBoardService;



    /**
     * freeboard 메인페이지
     */
    @GetMapping("/auth/freeboard-main")
    public String freeBoard() {
        return "MainMenu/community/freeboard/freeboard-main";
    }

    /**
     * 글작성 페이지
     */
    @GetMapping("/freeBoard/save")
    public String save() {
        return "layout/board/freeBoard-save";
    }

    /**
     * 글상세 페이지
     */
    // 주소 뒤에 {id} 이렇게 id를 받을 때는 @PathVariable을 사용하면 주소의 id로 받습니다.
    @GetMapping("/freeBoard/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("freeBoard", freeBoardService.detail(id));
        freeBoardService.updateCount(id);
        return "layout/board/freeBoard-detail";
    }

    /**
     * 글 수정 페이지
     */
    @GetMapping("/freeBoard/{id}/update")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("freeBoard", freeBoardService.detail(id));
        return "layout/board/freeBoard-update";
    }

}
