package com.study.demoProject.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// DAO라 불리는 DB 계층 접근자
// 자동으로 bean등록이 된다.
@Repository // 생략 가능
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(@Param("username") String username);

}