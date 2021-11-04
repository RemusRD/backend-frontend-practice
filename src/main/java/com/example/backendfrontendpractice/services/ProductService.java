package com.example.backendfrontendpractice.services;

import com.example.backendfrontendpractice.controllers.ProductResponse;
import com.example.backendfrontendpractice.models.Product;
import com.example.backendfrontendpractice.repositories.ProductRepository;
import com.example.backendfrontendpractice.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product createProduct(String productName, BigDecimal price) {
        final var product = Product.builder()
                .name(productName)
                .price(price)
                .build();
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(UUID id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
    }
}
