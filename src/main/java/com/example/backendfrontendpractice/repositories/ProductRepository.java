package com.example.backendfrontendpractice.repositories;

import com.example.backendfrontendpractice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
