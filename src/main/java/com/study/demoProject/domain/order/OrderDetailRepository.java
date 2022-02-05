package com.study.demoProject.domain.order;

import com.study.demoProject.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

    Optional<OrderDetail> findById(Long num);

    List<OrderDetail> findAll();

    List<OrderDetail> findByOrderUser(User user);
}