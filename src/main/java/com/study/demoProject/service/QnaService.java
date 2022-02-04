package com.study.demoProject.service;

import com.study.demoProject.domain.board.Board;
import com.study.demoProject.domain.board.BoardRepository;
import com.study.demoProject.domain.user.User;
import com.study.demoProject.dto.board.BoardSaveRequestDto;
import com.study.demoProject.dto.board.BoardUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class QnaService {
    private final BoardRepository boardRepository;

    /**
     * 글작성 로직
     */
    @Transactional
    public Long save(BoardSaveRequestDto boardSaveRequestDto, User user) {
        boardSaveRequestDto.setUser(user);
        return boardRepository.save(boardSaveRequestDto.toEntity()).getId();
    }

//    /**
//     * 글목록 로직
//     */
//    // JPA의 findAll() 메소드를 사용하면 테이블의 raw 데이터를 모두 조회해서 가져온다.
//    public List<Board> findAll() {
//        return boardRepository.findAll();
//    }

    /**
     * 글상세 로직
     */
    @Transactional(readOnly = true)
    public Board detail(Long id) {
        return boardRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("글 상세보기 실패 : 아이디를 찾을 수 없습니다. id=" +id);
                });
    }
    /**
     * 글삭제 로직
     */
    // JpaRepository의 deleteById는 void타입
    @Transactional
    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }


    /**
     * 글수정 로직
     */
    //먼저 boardRepository.findById(id)로 찾아서 Board를 영속화시킨다.
    // 그러면 영속성 컨텍스트에 Board 객체가 담아진다.
    // 그리고 나서 Board의 값을 변경시키면 Service가 종료되는 시점에 트랜잭션이 종료되고 더티체킹이 일어난다.
    @Transactional
    public Long update(Long id, BoardUpdateRequestDto boardUpdateRequestDto) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 id가 없습니다. id=" + id));
        board.update(boardUpdateRequestDto.getTitle(), boardUpdateRequestDto.getContent());
        return id;
    }

    /**
     * 글 조회수 로직
     */
    @Transactional
    public int updateCount(Long id) {
        return boardRepository.updateCount(id);
    }

    /**
     * 글목록 로직 (페이징)
     */
    @Transactional(readOnly = true)
    public Page<Board> findByTitleContainingOrContentContaining(String title, String content, Pageable pageable) {
        return boardRepository.findByTitleContainingOrContentContaining(title, content, pageable);
    }


}
