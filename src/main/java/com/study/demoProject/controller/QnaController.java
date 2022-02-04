package com.study.demoProject.controller;

import com.study.demoProject.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class QnaController {
    private final BoardService boardService;

    /**
     * QnA 페이지
     */
    @GetMapping("/auth/board/qna")
    public String qna() {
        return "TopMenu/board/qna/QnA";
    }


    /**
     * 글작성 페이지
     */
    @GetMapping("/board/qna/save")
    public String save() {
        return "TopMenu/board/qna/qna-save";
    }

    /**
     * 글상세 페이지
     */
    // 주소 뒤에 {id} 이렇게 id를 받을 때는 @PathVariable을 사용하면 주소의 id로 받습니다.
    @GetMapping("/board/qna/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("board", boardService.detail(id));
        boardService.updateCount(id);
        return "TopMenu/board/qna/qna-detail";
    }

    /**
     * 글 수정 페이지
     */
    @GetMapping("/board/qna/{id}/update")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("board", boardService.detail(id));
        return "TopMenu/board/qna/qna-update";
    }
}
