package com.study.demoProject.domain.order;

import com.study.demoProject.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    Optional<Cart> findById(Long num);
    List<Cart> findAll();
    List<Cart> findByUser(User user);
    void deleteById(Long id);
}