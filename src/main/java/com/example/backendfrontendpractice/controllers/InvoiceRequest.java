package com.example.backendfrontendpractice.controllers;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class InvoiceRequest {
    @NotEmpty
    private List<UUID> products;
}
