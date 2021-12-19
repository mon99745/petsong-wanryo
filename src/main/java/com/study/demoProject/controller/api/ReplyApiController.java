package com.study.demoProject.controller.api;

import com.study.demoProject.config.auth.PrincipalDetail;
import com.study.demoProject.domain.reply.Reply;
import com.study.demoProject.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ReplyApiController {

    private final ReplyService replyService;

    // boardId 는 @PathVariable 통해서, Reply는 JSON으로 보내주고,
    // User 정보는 @AuthenticationPrincipal로 보내준다.

    @PostMapping("/api/v1/board/{boardId}/reply")
    public void save(@PathVariable Long boardId,
                     @RequestBody Reply reply,
                     @AuthenticationPrincipal PrincipalDetail principalDetail) {
        replyService.replySave(boardId, reply, principalDetail.getUser());
    }

    //댓글 삭제 맵핑
    @DeleteMapping("/api/v1/board/{boardId}/reply/{replyId}")
    public void delete(@PathVariable Long replyId) {
        replyService.replyDelete(replyId);
    }
}

