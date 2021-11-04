package com.example.backendfrontendpractice.controllers;

import com.example.backendfrontendpractice.services.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Validated
public class InvoiceController {
    private final InvoiceService invoiceService;

    @PostMapping("/invoices")
    public InvoiceResponse createInvoice(@RequestBody @Valid InvoiceRequest invoiceRequest) {
        final var invoice = invoiceService.createInvoice(invoiceRequest.getProducts());
        return InvoiceResponse.fromInvoice(invoice);
    }

    @GetMapping("/invoices")
    public List<InvoiceResponse> getInvoices() {
        final var invoices = invoiceService.getAllInvoices();
//        final var invoiceResponses = new ArrayList();
//        for (var invoice : invoices) {
//            invoiceResponses.add(InvoiceResponse.fromInvoice(invoice));
//        }
        return invoices.stream()
                .map(InvoiceResponse::fromInvoice)
                .collect(Collectors.toList());
    }
    @GetMapping("/invoices/{id}")
    public InvoiceResponse getInvoiceById(@PathVariable UUID id) {
        final var invoice = invoiceService.getInvoiceById(id);
        return InvoiceResponse.fromInvoice(invoice);
    }
}

