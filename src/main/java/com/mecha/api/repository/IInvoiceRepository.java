package com.mecha.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mecha.api.model.Invoice;

@Repository
public interface IInvoiceRepository extends JpaRepository<Invoice, Long> {
    
}
