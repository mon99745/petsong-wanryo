package com.study.demoProject.domain.order;

import com.study.demoProject.domain.user.User;
import lombok.AccessLevel;
import org.springframework.data.annotation.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PROTECTED)// 파라미터가 없는 생성자를 생성
@Entity
@javax.persistence.Table(name="cart")
@Getter
@Setter
public class Cart {
    @Id // 직접할당
    @javax.persistence.Id
    @Column(name = "cart_num", unique = true) //Entity Key?
    @GeneratedValue(strategy= GenerationType.IDENTITY)// DB에 위임을 통해 기본 키 생성
    private Long id;

    @ManyToOne
    @JoinColumn(name="id")
    private User user;

    private int cart_quantity;

    @ManyToOne
    @JoinColumn(name="product_num")
    private Product Product;





    //장바구니 생성
    public static Cart createCart(User user, Product Product, int cart_quantity){
        Cart cart = new Cart(); //새로운 장바구니
        cart.setUser(user);
        cart.setProduct(Product);//담은 상품 정보
        cart.setCart_quantity(cart_quantity); //장바구니에 담은 상품 개수

        return cart;
    }

    //총액
    public int getTotalPrice(){
        return Product.getProduct_price() * cart_quantity;
    }
}
