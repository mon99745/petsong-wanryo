package com.study.demoProject.service.order;

import com.study.demoProject.domain.order.*;
import com.study.demoProject.domain.user.User;
import com.study.demoProject.domain.user.UserRepository;
import com.study.demoProject.dto.order.OrderInfoDto;
import com.study.demoProject.exception.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Component
public class OrderService {

    @Autowired
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;

    //단순 주문 로직
    public Long order(OrderInfoDto infoDto, String username) {
        Product product = productRepository.findById(infoDto.getProduct_num()).orElseThrow(() -> new ProductNotFoundException("오류: 상품 정보가 없습니다."));
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));

        List<OrderDetail> orderDetails = new ArrayList<>();
        OrderDetail orderDetail = OrderDetail.createOrderDetail(product, infoDto.getOrder_quantity());
        orderDetails.add(orderDetail);
        Order order = Order.createOrder(user, orderDetails);
        orderRepository.save(order);

        orderDetail.addOrderNum(order);
        orderDetailRepository.save(orderDetail);

        return order.getId();
    }

    //주문 취소
    public void cancelOrder(Long order_num){
        Order order = orderRepository.findById(order_num).orElseThrow(EntityNotFoundException::new);
        order.cancelOrder();
    }

    //다량 주문 로직
    public Long orders(List<OrderInfoDto> orderInfoDtoList, String username) {

        // 로그인한 유저 조회
        User user = userRepository.findByUsername(username).orElseThrow();

        // OrderInfoDto 객체를 이용하여 item 객체와 count 값을 얻어낸 뒤, 이를 이용하여 OrderDetail 객체(들) 생성
        List<OrderDetail> orderDetailList = new ArrayList<>();
        for (OrderInfoDto orderInfoDto : orderInfoDtoList) {
            Product product = productRepository.findById(orderInfoDto.getProduct_num()).orElseThrow(EntityNotFoundException::new);
            OrderDetail orderDetail = OrderDetail.createOrderDetail(product, orderInfoDto.getOrder_quantity());
            orderDetailList.add(orderDetail);
        }

        //Order Entity 클래스에 존재하는 createOrder 메소드로 Order 생성 및 저장
        Order order = Order.createOrder(user, orderDetailList);
        orderRepository.save(order);
        return order.getId();
    }

    //전체 주문 조회
    public List<Order> findAll(){return orderRepository.findAll();}

    //전체 주문 상세 조회
    public List<OrderDetail> findAllDetails(){return orderDetailRepository.findAll();}

    //나의 주문 조회
    public List<OrderDetail> findMyDetails(User user){
        return orderDetailRepository.findByOrderUser(user);
    }

    public Optional<Order> findById(Long order_num) {return orderRepository.findById(order_num);}
}
