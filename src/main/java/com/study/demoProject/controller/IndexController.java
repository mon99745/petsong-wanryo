package com.study.demoProject.controller;

import com.study.demoProject.domain.board.Board;
import com.study.demoProject.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final BoardService boardService;

@GetMapping("/")
// @PageableDefault를 설정하면 페이지의 size, 정렬순을 정할 수 있다.
// 한 페이지당 5 Size, 최신글을 제일 맨위로 볼 수 있게 해둠.
public String index(Model model,
                    @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                    @RequestParam(required = false, defaultValue = "") String search) {
    Page<Board> boards = boardService.findByTitleContainingOrContentContaining(search, search, pageable);

    // boards.getPageable().getPageNumber() : 현재 페이지 번호
    // startPage, endPage는 페이지 목록에서 시작 페이지 번호와 끝 페이지 번호
    int startPage = Math.max(1, boards.getPageable().getPageNumber() - 4);
    int endPage = Math.min(boards.getTotalPages(), boards.getPageable().getPageNumber() + 4);
    model.addAttribute("startPage", startPage);
    model.addAttribute("endPage", endPage);
    model.addAttribute("boards", boards);
    return "index";
    }
}
