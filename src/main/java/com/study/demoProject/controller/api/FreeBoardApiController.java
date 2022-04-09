package com.study.demoProject.controller.api;

import com.study.demoProject.config.auth.PrincipalDetail;
import com.study.demoProject.domain.board.FreeBoard;
import com.study.demoProject.dto.board.FreeBoardSaveRequestDto;
import com.study.demoProject.dto.board.FreeBoardUpdateRequestDto;
import com.study.demoProject.service.FreeBoardService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class FreeBoardApiController {

    private final FreeBoardService freeBoardService;

    /**
     * 메인페이지 API
     */
    @GetMapping("/api/v1/freeBoard")
// @PageableDefault를 설정하면 페이지의 size, 정렬순을 정할 수 있다.
// 한 페이지당 5 Size, 최신글을 제일 맨위로 볼 수 있게 해둠.
    public String freeBoard(Model model,
                            @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                            @RequestParam(required = false, defaultValue = "") String search) {
        Page<FreeBoard> boards = freeBoardService.findByTitleContainingOrContentContaining(search, search, pageable);

        // boards.getPageable().getPageNumber() : 현재 페이지 번호
        // startPage, endPage는 페이지 목록에서 시작 페이지 번호와 끝 페이지 번호
        int startPage = Math.max(1, boards.getPageable().getPageNumber() - 4);
        int endPage = Math.min(boards.getTotalPages(), boards.getPageable().getPageNumber() + 4);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("boards", boards);
        return "freeboard";
    }

    /**
     * 글작성 API
     */
    @PostMapping("/api/v1/freeBoard")
    // @PostMapping이므로 @RequestBody를 꼭붙여주어야 한다.
    // 어떤 사용자가 게시글을 작성하는지 알기 위해 @AuthenticationPrincipal 정보를 파라미터로 받는다.
    public Long save(@RequestBody FreeBoardSaveRequestDto freeBoardSaveRequestDto,
                     @AuthenticationPrincipal PrincipalDetail principalDetail) {
        return freeBoardService.save(freeBoardSaveRequestDto, principalDetail.getUser());
    }

    /**
     * 글삭제 API
     */
    @DeleteMapping("/api/v1/freeBoard/{id}")
    // id값을 주소에 받기 위해 @PathVariable
    public Long deleteById(@PathVariable Long id) {
        freeBoardService.deleteById(id);
        return id;
    }

    /**
     * 글수정 API
     */
    @PutMapping("/api/v1/freeBoard/{id}")
    public Long update(@PathVariable Long id, @RequestBody FreeBoardUpdateRequestDto freeBoardUpdateRequestDto) {
        return freeBoardService.update(id, freeBoardUpdateRequestDto);
    }
}