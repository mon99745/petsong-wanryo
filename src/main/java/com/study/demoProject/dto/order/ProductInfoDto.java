package com.study.demoProject.dto.order;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class ProductInfoDto { //상품 등록 정보

    private Long id;
    private String product_category;
    private String product_name;
    private int product_price;
    private int product_stock;
    private String product_detail;
    private String product_date;
}