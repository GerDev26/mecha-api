package com.mecha.api.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mecha.api.model.Invoice;
import com.mecha.api.repository.IInvoiceRepository;
import com.mecha.api.service.interfaces.IInvoiceService;
import com.mecha.api.exceptions.NotFoundException;

@Service
public class InvoiceService implements IInvoiceService {
    
    @Autowired
    private IInvoiceRepository invoiceRepository;

    @Override
    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice findById(Long id) {
        return invoiceRepository.findById(id).orElseThrow(() -> new NotFoundException("Invoice not found"));
    }

    @Override
    public Invoice save(Invoice invoice) {
        invoiceRepository.save(invoice);
        invoice.setCreated_at(LocalDate.now());
        return invoice;
    }

    @Override
    public Invoice update(Long id, Invoice invoice) {
        Invoice invoiceUpdated = this.findById(id);
        invoiceUpdated.setTotal_price(invoice.getTotal_price());
        invoiceUpdated.setUpdated_at(LocalDate.now());
        invoiceRepository.save(invoiceUpdated);
        return invoiceUpdated;
    }

    @Override
    public void deleteById(Long id) {
        Invoice invoice = this.findById(id);
        invoiceRepository.delete(invoice);
    }
}
