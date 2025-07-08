package com.mecha.api.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vehicles")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    
    @Column(nullable = false)
    private String model;
    
    @Column(nullable = false)
    private String brand;
    
    @OneToMany(mappedBy = "vehicle")
    private List<Replacement> replacements;
    
    @OneToMany(mappedBy = "vehicle")
    private List<PersonalVehicle> personalVehicles;
}
