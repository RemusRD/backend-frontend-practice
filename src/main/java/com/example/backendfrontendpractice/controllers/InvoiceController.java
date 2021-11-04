package com.example.backendfrontendpractice.controllers;

import com.example.backendfrontendpractice.services.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
//c1c007b6-ed3b-425e-9fda-f7be986855cc,9113b40b-9d8e-4b1d-80e7-18cd46011fbd
}
