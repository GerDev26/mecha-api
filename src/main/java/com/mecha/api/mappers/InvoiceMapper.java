package com.mecha.api.mappers;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.mecha.api.dto.invoice.InvoiceRequestDTO;
import com.mecha.api.dto.invoice.InvoiceResponseDTO;
import com.mecha.api.model.Invoice;

@Component
public class InvoiceMapper implements IMapper<InvoiceRequestDTO, InvoiceResponseDTO, Invoice> {
    
    @Override
    public Invoice RequestToEntity(InvoiceRequestDTO invoiceRequestDTO) {
        Invoice invoice = new Invoice();
        invoice.setTotal_price(invoiceRequestDTO.getTotal_price());
        return invoice;
    }

    @Override
    public InvoiceResponseDTO EntityToResponse(Invoice invoice) {
        InvoiceResponseDTO invoiceResponseDTO = new InvoiceResponseDTO();
        invoiceResponseDTO.setId(invoice.getId());
        invoiceResponseDTO.setTotal_price(invoice.getTotal_price());
        invoiceResponseDTO.setCreated_at(invoice.getCreated_at());
        invoiceResponseDTO.setUpdated_at(invoice.getUpdated_at());
        return invoiceResponseDTO;
    }
}
