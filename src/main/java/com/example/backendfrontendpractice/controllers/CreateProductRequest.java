package com.example.backendfrontendpractice.controllers;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@NoArgsConstructor
@Getter
public class CreateProductRequest {
    @NotBlank
    private String name;
    @Positive
    private BigDecimal price;
}
