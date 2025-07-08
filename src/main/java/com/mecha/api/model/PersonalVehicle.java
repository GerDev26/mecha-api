package com.mecha.api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "personal_vehicles")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonalVehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    
    @Column(nullable = false)
    private String domain;
    
    private Integer mileage;
    
    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private AppUser user;
}
