package com.example.backendfrontendpractice.repositories;

import com.example.backendfrontendpractice.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InvoiceRepository extends JpaRepository<Invoice, UUID> {
}
