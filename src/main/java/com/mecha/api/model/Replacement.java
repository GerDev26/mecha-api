package com.mecha.api.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
    name = "replacements",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name", "vehicle_id"})
    }
)
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Replacement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;
    
    @Column(nullable = false)
    private Double unit_price;
    
    @OneToMany(mappedBy = "replacement")
    private List<InvoiceReplacement> invoiceReplacements;
}
