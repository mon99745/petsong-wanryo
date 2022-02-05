package com.study.demoProject.controller.order;

import com.study.demoProject.domain.order.Cart;
import com.study.demoProject.domain.user.User;
import com.study.demoProject.dto.order.CartInfoDto;
import com.study.demoProject.dto.order.CartOrderDto;
import com.study.demoProject.service.order.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller

public class CartController {
    @Autowired
    private final CartService cartService;

    @GetMapping("/myCart")
    public String getMyCart(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal(); //현재 로그인 정보
        List<Cart> cart = cartService.findMyCart(user); //멤버의 주문목록 불러오기

        model.addAttribute("cart", cart); //멤버의 주문리스트 뷰로 전송
        return "/member/myCart";
    }

    //    @PostMapping(value = "/order", produces = "application/json") //주문하기, application/json 부분은 지워야 할 듯
    @PostMapping(value = "/addCart") //주문하기, application/json 부분은 지워야 할 듯
    public ResponseEntity addCart(CartInfoDto infoDto, BindingResult bindingResult, Principal principal) {
        if (bindingResult.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                sb.append(fieldError.getDefaultMessage());
            }
            return new ResponseEntity<String>(sb.toString(), HttpStatus.BAD_REQUEST);
        }

        String name = principal.getName(); //현재 로그인 정보에서 이름 가져오기
        Long cartId; //장바구니번호 생성

        try {
            cartId = cartService.addCart(infoDto, name); //주문 시도 및 주문번호 가져오기
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Long>(cartId, HttpStatus.OK); //장바구니번호 리턴
    }

    @PostMapping(value = "/cart/order")
    public ResponseEntity cartOrder(CartOrderDto cartOrderDto, Principal principal) {
        List<CartOrderDto> cartOrderDtoList = cartOrderDto.getCartOrderDtoList(); //전달된 장바구니의 항목 리스트

        if (cartOrderDtoList == null || cartOrderDtoList.size() == 0) { //리스트가 비었거나 0개면
            return new ResponseEntity<String>("선택된 상품이 없습니다.", HttpStatus.BAD_REQUEST);
        }
        //주문로직에 장바구니 리스트와 멤버 정보 전달
        Long orderId = cartService.orderCart(cartOrderDtoList, principal.getName());
        //주문번호 리턴
        return new ResponseEntity<Long>(orderId, HttpStatus.OK);
    }

    @PostMapping(value = "/deleteCart") //장바구니 항목 상제
    public String deleteCart(Long cart_num) {
        cartService.deleteById(cart_num);
        return "redirect:/myCart";
    }
}
