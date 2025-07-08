package com.mecha.api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "invoices_replacements")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceReplacement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "replacements_id", nullable = false)
    private Replacement replacement;
    
    @ManyToOne
    @JoinColumn(name = "invoices_id", nullable = false)
    private Invoice invoice;
    
    @Column(nullable = false)
    private Integer quantity;
    
    @Column(nullable = false)
    private Double unit_price;
}
