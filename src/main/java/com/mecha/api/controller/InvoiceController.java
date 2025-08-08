package com.mecha.api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import com.mecha.api.dto.validations.Store;
import com.mecha.api.dto.validations.Update;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import com.mecha.api.service.interfaces.IInvoiceService;

import com.mecha.api.dto.api.ApiBodyDTO;
import com.mecha.api.dto.invoice.InvoiceRequestDTO;
import com.mecha.api.dto.invoice.InvoiceResponseDTO;
import com.mecha.api.mappers.InvoiceMapper;
import com.mecha.api.model.Invoice;

import java.util.List;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
    
    @Autowired
    private IInvoiceService invoiceService;

    @Autowired
    private InvoiceMapper invoiceMapper;
    
    @GetMapping
    public ResponseEntity<ApiBodyDTO> index() {
        List<InvoiceResponseDTO> invoices = invoiceService.findAll().stream()
                .map(invoiceMapper::EntityToResponse)
                .toList();
        return ResponseEntity.ok(new ApiBodyDTO("Showing all Invoices", invoices));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiBodyDTO> show(@PathVariable Long id) {
        InvoiceResponseDTO invoice = invoiceMapper.EntityToResponse(invoiceService.findById(id));
        return ResponseEntity.ok(new ApiBodyDTO("Showing Invoice", invoice));
    }

    @PostMapping
    public ResponseEntity<ApiBodyDTO> store(@Validated(Store.class) @RequestBody InvoiceRequestDTO invoiceRequestDTO) {
        Invoice invoice = invoiceMapper.RequestToEntity(invoiceRequestDTO);
        invoiceService.save(invoice);
        return ResponseEntity.created(null).body(new ApiBodyDTO("Invoice created successfully"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiBodyDTO> update(@PathVariable Long id, @Validated(Update.class) @RequestBody InvoiceRequestDTO invoiceRequestDTO) {
        Invoice invoice = invoiceMapper.RequestToEntity(invoiceRequestDTO);
        invoiceService.update(id, invoice);
        return ResponseEntity.ok(new ApiBodyDTO("Invoice updated successfully"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiBodyDTO> destroy(@PathVariable Long id) {
        invoiceService.deleteById(id);
        return ResponseEntity.ok(new ApiBodyDTO("Invoice deleted successfully"));
    }
}
