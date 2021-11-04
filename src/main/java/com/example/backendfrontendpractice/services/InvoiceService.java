package com.example.backendfrontendpractice.services;

import com.example.backendfrontendpractice.models.Invoice;
import com.example.backendfrontendpractice.models.Product;
import com.example.backendfrontendpractice.repositories.InvoiceRepository;
import com.example.backendfrontendpractice.repositories.ProductRepository;
import com.example.backendfrontendpractice.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public Invoice createInvoice(List<UUID> productIds, String username) {
        final var user = userRepository.findByUsername(username).orElseThrow(() -> new IllegalArgumentException("User not found"));
        final var productsInInvoice = productRepository.findAllById(productIds);
        final var invoiceTotal = productsInInvoice.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        //for loop to get the total instead of reduce
        /*BigDecimal totalamount = BigDecimal.ZERO;
        for (var product : productsInInvoice) {
            totalamount = totalamount.add(product.getPrice());
        }
        */

        final var invoice = Invoice.builder()
                .products(productsInInvoice)
                .total(invoiceTotal)
                .owner(user)
                .build();
        return invoiceRepository.save(invoice);
    }

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Invoice getInvoiceById(UUID id) {
        return invoiceRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invoice not found"));
    }
}
