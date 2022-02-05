package com.study.demoProject.dto.order;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class OrderInfoDto { //주문 실행 정보

    @NotNull(message = "상품 정보가 없습니다.")
    private Long product_num;

    @Min(value = 1, message = "최소 주문 가능 수량은 1개 입니다.") //작동 하는가??
    @Max(value = 999, message = "최대 주문 가능 수량은 999개 입니다.") //작동 하는가??
    private int order_quantity;
    private List<OrderInfoDto> OrderInfoDtoList;
}