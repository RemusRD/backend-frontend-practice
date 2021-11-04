package com.example.backendfrontendpractice.controllers;


import com.example.backendfrontendpractice.models.Invoice;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Builder
public class InvoiceResponse {
    private UUID id;
    private int number;
    private BigDecimal total;
    private UserResponse owner;
    private List<ProductResponse> products;

    public static InvoiceResponse fromInvoice(Invoice invoice) {

//        final var productResponses = new ArrayList();
//        for (var product : invoice.getProducts()) {
//            productResponses.add(ProductResponse.fromProduct(product));
//        }

        return InvoiceResponse.builder()
                .id(invoice.getId())
                .total(invoice.getTotal())
                .owner(UserResponse.fromUser(invoice.getOwner()))
                .products(invoice.getProducts().stream()
                        .map(ProductResponse::fromProduct)
                        .collect(Collectors.toList()))
                .build();
    }
}
