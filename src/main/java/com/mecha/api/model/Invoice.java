package com.mecha.api.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "invoices")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    
    @Column(nullable = false)
    private Double total_price;
    
    @Column(nullable = false)
    private LocalDate created_at;
    
    @Column(nullable = false)
    private LocalDate updated_at;
    
    @OneToMany(mappedBy = "invoice")
    private List<InvoiceReplacement> invoiceReplacements;
    
    @OneToMany(mappedBy = "invoice")
    private List<InvoiceWork> invoiceWorks;
}
