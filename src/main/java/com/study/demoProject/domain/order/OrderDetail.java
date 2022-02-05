package com.study.demoProject.domain.order;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

import javax.persistence.*;
import java.util.Optional;


/*
Spring Data JPA
식별자를 직접 할당하여 관리
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)// 파라미터가 없는 생성자를 생성
@Entity
@javax.persistence.Table(name="order_detail")
@Getter
@Setter
//주문상세 (예: 주문번호 1에 개밥*1개, 개옷*2개, 고양이밥*1개 중 개밥*1 개옷*2 고양이밥*2 가 주문상세에 해당)

public class OrderDetail {
    @Id // 직접할당
    @javax.persistence.Id //Prime Key
    @Column(name = "order_detail_num", unique = true) //Entity Key?
    @GeneratedValue(strategy= GenerationType.IDENTITY)// DB에 위임을 통해 기본 키 생성
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_num")
    private Order order;

    private int order_quantity;

    private int order_price;

    @ManyToOne
    @JoinColumn(name="product_num")
    private Product product;




    @Builder
    public OrderDetail( int order_quantity, int order_price, Product product, Order order) {

        this.order_quantity = order_quantity;
        this.order_price = order_price; //상품의 구입당시 가격
        this.product = product; //product_num
        this.order = order; //order_num
    }

    //주문 상세 기록 생성
    public static OrderDetail createOrderDetail(Product product, int order_quantity){
        OrderDetail orderDetail = new OrderDetail(); //새로운 주문 상세 기록
        orderDetail.setProduct(product);//이 주문의 상품 정보
        orderDetail.setOrder_quantity(order_quantity); //이 주문의 주문 개수
        orderDetail.setOrder_price(product.getProduct_price()); //이 주문의 당시 가격

        product.removeStock(order_quantity); //재고 차감
        return orderDetail;
    }

    //각 주문상세항목에 주문번호 주입하기
    public void addOrderNum(Order order){
        this.order = order;
    }

    //총액
    public int getTotalPrice(){
        return order_price * order_quantity;
    }

    //주문취소+재고 원상복구
    public void cancel(){
        this.getProduct().addStock(order_quantity);
    }
}
