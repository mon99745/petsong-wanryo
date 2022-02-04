package com.study.demoProject.domain.board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QnaRepository extends JpaRepository<Board, Long> {

    @Modifying
    @Query("update Board p set p.count = p.count + 1 where p.id = :id")
    int updateCount(Long id);

    // Containing이라는 키워드를 사용하면 JPA에서 LIKE문으로 실행
    // 제목이나 내용으로 검색될 수 있게
    Page<Board> findByTitleContainingOrContentContaining(@Param("title") String title,
                                                         @Param("content") String content, Pageable pageable);
}