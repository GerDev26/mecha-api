package com.mecha.api.model;

import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    
    @Column(nullable = false)
    private String alias;
    
    private String name;
    private String lastname;
    
    @Column(name = "phone_number")
    private String phoneNumber;
    
    @Column(unique = true)
    private String email;
    private String password;
    
    @Column(nullable = false)
    private boolean isEnabled;
    
    @Column(nullable = false)
    private boolean accountNotExpired;
    
    @Column(nullable = false)
    private boolean accountNotLocked;
    
    @Column(nullable = false)
    private boolean credentialNotExpired;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", 
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;
    
    @OneToMany(mappedBy = "user")
    private List<PersonalVehicle> personalVehicles;
}
