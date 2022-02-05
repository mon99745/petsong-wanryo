package com.study.demoProject.dto.order;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class CartOrderDto {
    private Long cart_num;
    private List<CartOrderDto> CartOrderDtoList;
}