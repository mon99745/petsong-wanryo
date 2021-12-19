package com.study.demoProject.dto.board;

import com.study.demoProject.domain.board.Board;
import com.study.demoProject.domain.user.User;
import com.study.demoProject.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BoardUpdateRequestDto {

    private String title;
    private String content;

}
