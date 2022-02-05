package com.study.demoProject.service.order;

import com.study.demoProject.domain.order.Cart;
import com.study.demoProject.domain.order.CartRepository;
import com.study.demoProject.domain.order.Product;
import com.study.demoProject.domain.order.ProductRepository;
import com.study.demoProject.domain.user.User;
import com.study.demoProject.domain.user.UserRepository;
import com.study.demoProject.dto.order.CartInfoDto;
import com.study.demoProject.dto.order.CartOrderDto;
import com.study.demoProject.dto.order.OrderInfoDto;
import com.study.demoProject.exception.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Component
public class CartService {

    @Autowired
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final OrderService orderService;

    //장바구니 추가
    public Long addCart(CartInfoDto infoDto, String username) {
        Product product = productRepository.findById(infoDto.getProduct_num()).orElseThrow(() -> new ProductNotFoundException("오류: 상품 정보가 없습니다."));
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));

        Cart cart = Cart.createCart(user, product, infoDto.getCart_quantity()); //장바구니 생성
        cartRepository.save(cart);

        return cart.getId();
    }

    //카트의 상품 주문로직
    public Long orderCart(List<CartOrderDto> cartOrderDtoList, String username){
        List<OrderInfoDto> orderInfoDtoList = new ArrayList<>(); //장바구니 리스트

        for(CartOrderDto CartOrderDto : cartOrderDtoList){ //장바구니 항목들 정리
            Cart cart = cartRepository.findById(CartOrderDto.getCart_num()).orElseThrow();//고객이 담은 장바구니 항목 불러오기
            OrderInfoDto orderInfoDto = new OrderInfoDto();
            orderInfoDto.setProduct_num(cart.getProduct().getId()); //상품번호
            orderInfoDto.setOrder_quantity(cart.getCart_quantity()); //수량
            orderInfoDtoList.add(orderInfoDto);
        }

        //주문 로직
        Long orderId = orderService.orders(orderInfoDtoList, username);

        //주문완료 후 장바구니 삭제
        for (CartOrderDto cartOrderDto : cartOrderDtoList){
            Cart cart = cartRepository.findById(cartOrderDto.getCart_num()).orElseThrow();
            cartRepository.delete(cart);
        }
        return orderId;
    }
    //나의 장바구니
    public List<Cart> findMyCart(User user) {
        return cartRepository.findByUser(user);

    }

    //장바구니 삭제
    public void deleteById(Long id) {
        cartRepository.deleteById(id);
    }
}