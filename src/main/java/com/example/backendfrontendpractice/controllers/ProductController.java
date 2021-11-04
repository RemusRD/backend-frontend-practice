package com.example.backendfrontendpractice.controllers;

import com.example.backendfrontendpractice.models.Product;
import com.example.backendfrontendpractice.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Validated
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/products")
    public ProductResponse createProduct(@RequestBody CreateProductRequest request) {
        final var product = productService.createProduct(request.getName(), request.getPrice());
        return ProductResponse.fromProduct(product);
    }

    //get all products
    @GetMapping("/products")
    public List<ProductResponse> getAllProducts() {
        return productService
                .getAllProducts()
                .stream()
                .map(ProductResponse::fromProduct)
                .collect(Collectors.toList());
    }
}
