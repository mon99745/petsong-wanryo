package com.study.demoProject.controller.order;

import com.study.demoProject.domain.order.OrderDetail;
import com.study.demoProject.domain.user.User;
import com.study.demoProject.dto.order.OrderInfoDto;
import com.study.demoProject.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class OrderController {

    @Autowired
    private final OrderService orderService;

    //return "/경로"; = html 문서 경로
    //ruturn "redirect: /값"; = 맵핑 액션 이름

    //(관리자)전체 주문 목록
//    @GetMapping("/orders")
//    public String getOrders(Model model){
//        List<OrderDetailInfo> orders = orderService.findAllDetails();
//
//        model.addAttribute("orders", orders);
//        return "/admin/orderList";
//    }

    @GetMapping("/orders") //전체 주문 목록 확인
    public String getOrders(Model model){
        List<OrderDetail> orders = orderService.findAllDetails(); //모든 주문 불러오기

        model.addAttribute("orders", orders); //주문 리스트를 뷰로 전송
        return "/admin/orderList";
    }

    @GetMapping("/myOrders")
    public String getMyOrders(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal(); //현재 로그인 정보
        List<OrderDetail> orders = orderService.findMyDetails(user); //멤버의 주문목록 불러오기

        model.addAttribute("orders", orders); //멤버의 주문리스트 뷰로 전송
        return "/order/myOrder";
    }

    @PostMapping(value = "/order") //주문하기
    public ResponseEntity order(OrderInfoDto infoDTO, BindingResult bindingResult, Principal principal){
        if(bindingResult.hasErrors()){
            StringBuilder sb = new StringBuilder();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors){
                sb.append(fieldError.getDefaultMessage());
            }
            return new ResponseEntity<String>(sb.toString(), HttpStatus.BAD_REQUEST);
        }

        String name = principal.getName(); //현재 로그인 정보에서 이름 가져오기
        Long orderId; //주문번호 생성

        try {
            orderId = orderService.order(infoDTO, name); //주문 시도 및 주문번호 가져오기
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Long>(orderId, HttpStatus.OK);
    }

    @PostMapping(value = "/cancelOrder") //주문 취소
    public String cancelOrder(Long order_num){
        orderService.cancelOrder(order_num);

        return "redirect:/myOrders";
    }
}