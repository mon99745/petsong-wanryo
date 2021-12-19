package com.study.demoProject.domain.reply;

import com.study.demoProject.domain.user.User;
import com.study.demoProject.domain.BaseTimeEntity;
import com.study.demoProject.domain.board.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@DynamicUpdate// 변경 필드반 반영
public class Reply extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 500)
    private String content;

    @ManyToOne
    @JoinColumn(name = "boardId")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public void save(Board board, User user) {
        this.board = board;
        this.user = user;
    }
}