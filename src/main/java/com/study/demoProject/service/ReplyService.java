package com.study.demoProject.service;

import com.study.demoProject.domain.user.User;
import com.study.demoProject.domain.board.Board;
import com.study.demoProject.domain.board.BoardRepository;
import com.study.demoProject.domain.reply.Reply;
import com.study.demoProject.domain.reply.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ReplyService {

    private final ReplyRepository replyRepository;
    private final BoardRepository boardRepository;

    @Transactional
    // 댓글을 저장할 때는 Board의 Id 값을 가져와야 한다.
    // 그래서 Board를 영속화시켜서 Board와 User를 저장
    public void replySave(Long boardId, Reply reply, User user) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException("해당 boardId가 없습니다. id=" + boardId));

        reply.save(board, user);
        replyRepository.save(reply);
    }

    @Transactional
    public void replyDelete(Long replyId) {
        replyRepository.deleteById(replyId);
    }
}