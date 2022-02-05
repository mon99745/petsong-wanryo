package com.study.demoProject.domain.order;

import com.study.demoProject.domain.user.User;
import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

/*
Spring Data JPA
식별자를 직접 할당하여 관리
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)// 파라미터가 없는 생성자를 생성
@Entity
@javax.persistence.Table(name="order_info")
@Getter
@Setter
//주문 그 자체, 예: 주문1에 개밥*1 개옷*2 이라면 이들을 포함할 주문1에 해당

public class Order {
    public enum OrderStatus{
        ORDER, CANCEL
    }
    @Id // 직접할당
    @javax.persistence.Id //Prime Key

    @Column(name = "order_num", unique = true) //Entity Key?
    @GeneratedValue(strategy= GenerationType.IDENTITY)// DB에 위임을 통해 기본 키 생성
    private Long id;

    @ManyToOne
    @JoinColumn(name="username")
    private User user;

    //주문번호 삭제시 주문상세까지 삭제 orphanRemoval
    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER, orphanRemoval = true)
    private List<OrderDetail> orderDetails = new ArrayList<>();

    private LocalDateTime reg_time;

    private LocalDateTime update_time;

    @Enumerated(EnumType.STRING)
    private OrderStatus order_status;




    @Builder
    public Order(User user, List<OrderDetail> orderDetails, LocalDateTime reg_time, LocalDateTime update_time, OrderStatus order_status) {

        this.user = user;
        this.orderDetails = orderDetails; //order_detail
        this.reg_time = reg_time;
        this.update_time=update_time;
        this.order_status = order_status;
    }

    //주문에 주문상세 주입. 예: 주문번호1에 들어갈 주문상세 개밥*1을 주입하는 과정
    public void addOrderDetail(OrderDetail orderDetail){
        orderDetails.add(orderDetail);
        orderDetail.setOrder(this);
    }

    //첫 주문시 주문생성
    public static Order createOrder(User user, List<OrderDetail> orderDetails){
        Order order = new Order();
        order.setUser(user); //멤버 정보 set

        for(OrderDetail orderDetail : orderDetails){ //주문 상세 리스트 주입
            order.addOrderDetail(orderDetail);
        }

        order.setOrder_status(OrderStatus.ORDER); //주문상태를 ORDER로 set
        order.setReg_time(LocalDateTime.now()); //주문시간
        return order; //완성된 주문정보
    }

    public int getTotalPrice(){
        int totalPrice = 0;

        for(OrderDetail orderDetail : orderDetails){
            totalPrice += orderDetail.getTotalPrice();
        }
        return totalPrice;
    }

    //주문 취소
    public void cancelOrder(){
        this.order_status = OrderStatus.CANCEL; //주문 상태를 CANCEL로

        for(OrderDetail orderDetail : orderDetails){ //주문 취소, 재고 원상복구
            orderDetail.cancel();
        }
    }
}
