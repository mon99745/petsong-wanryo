package com.study.demoProject.service.order;

import com.study.demoProject.domain.order.Product;
import com.study.demoProject.domain.order.ProductRepository;
import com.study.demoProject.dto.order.ProductInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Component
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    public Long save(ProductInfoDto InfoDto) {

        return productRepository.save(Product.builder()
                .product_category(InfoDto.getProduct_category())
                .product_name(InfoDto.getProduct_name())
                .product_price(InfoDto.getProduct_price())
                .product_stock(InfoDto.getProduct_stock())
                .product_detail(InfoDto.getProduct_detail())
                .product_date(InfoDto.getProduct_date()).build()).getId();
    }
    //일반 상품 조회
    public Optional<Product> findById(Long num){ //Long or String??
        return productRepository.findById(num);
    }
    //전체 상품 조회
    public List<Product> findAll(){return productRepository.findAll();}

    public int updateById(Long num, String name, int price){
        return productRepository.updateById(num, name, price);
    }
}
