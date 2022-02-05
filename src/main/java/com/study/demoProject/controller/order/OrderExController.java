package com.study.demoProject.controller.order;

import org.springframework.web.bind.annotation.GetMapping;

public class OrderExController {
    // Top Menu 컨트롤러
    /**
     * cart.html
     */
    @GetMapping("/auth/TopMenu/order/cart")
    public String cart() {
        return "TopMenu/order/cart.html";
    }

    /**
     * orderlist.html
     */
    @GetMapping("/auth/TopMenu/order/orderlist")
    public String orderlist() {
        return "TopMenu/order/orderlist.html";
    }

    /**
     * wish.html
     */
    @GetMapping("/auth/TopMenu/order/wish")
    public String wish() {
        return "TopMenu/order/wish.html";
    }
}
