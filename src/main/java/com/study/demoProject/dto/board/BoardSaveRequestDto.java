package com.study.demoProject.dto.board;

import com.study.demoProject.domain.user.User;
import com.study.demoProject.domain.board.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BoardSaveRequestDto {

    private String title;
    private String content;
    private int count;
    private User user;

    public Board toEntity() {

        return Board.builder()
                .title(title)
                .content(content)
                .count(0)
                .user(user)
                .build();
    }

    public void setUser(User user) {
        this.user = user;
    }
}
