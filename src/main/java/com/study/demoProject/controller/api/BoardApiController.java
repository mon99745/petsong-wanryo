package com.study.demoProject.controller.api;

import com.study.demoProject.config.auth.PrincipalDetail;
import com.study.demoProject.dto.board.BoardSaveRequestDto;
import com.study.demoProject.dto.board.BoardUpdateRequestDto;
import com.study.demoProject.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BoardApiController {

    private final BoardService boardService;

    /**
     * 글작성 API
     */
    @PostMapping("/api/v1/board")
    // @PostMapping이므로 @RequestBody를 꼭붙여주어야 한다.
    // 어떤 사용자가 게시글을 작성하는지 알기 위해 @AuthenticationPrincipal 정보를 파라미터로 받는다.
    public Long save(@RequestBody BoardSaveRequestDto boardSaveRequestDto,
                     @AuthenticationPrincipal PrincipalDetail principalDetail) {
        return boardService.save(boardSaveRequestDto, principalDetail.getUser());
    }

    /**
     * 글삭제 API
     */
    @DeleteMapping("/api/v1/board/{id}")
    // id값을 주소에 받기 위해 @PathVariable
    public Long deleteById(@PathVariable Long id) {
        boardService.deleteById(id);
        return id;
    }

//    /**
//     * 글수정 API
//     */
//    @PutMapping("/api/v1/board/{id}")
//    public Long update(@PathVariable Long id, @RequestBody BoardUpdateRequestDto boardUpdateRequestDto) {
//        return boardService.update(id, boardService);
//    }
    /**
     * 글수정 API
     */
    @PutMapping("/api/v1/board/{id}")
    public Long update(@PathVariable Long id, @RequestBody BoardUpdateRequestDto boardUpdateRequestDto) {
        return boardService.update(id, boardUpdateRequestDto);
    }
}