package com.mecha.api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "invoices_works")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceWork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "invoice_id", nullable = false)
    private Invoice invoice;
    
    @ManyToOne
    @JoinColumn(name = "work_id", nullable = false)
    private Work work;
    
    @Column(nullable = false)
    private Double unit_price;
}
