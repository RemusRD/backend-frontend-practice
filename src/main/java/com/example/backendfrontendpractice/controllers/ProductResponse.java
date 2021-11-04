package com.example.backendfrontendpractice.controllers;

import com.example.backendfrontendpractice.models.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Builder
@ToString
@Getter
public class ProductResponse {
    private String id;
    private String name;
    private BigDecimal price;

    public static ProductResponse fromProduct(Product product) {
        return ProductResponse.builder()
                .id(product.getId().toString())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }
}