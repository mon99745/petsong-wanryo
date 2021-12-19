package com.exam.demoExample.dto.board;

import com.exam.demoExample.domain.board.Board;
import com.exam.demoExample.domain.user.User;
import com.exam.demoExample.service.BoardService;
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
