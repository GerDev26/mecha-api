package com.mecha.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mecha.api.model.AppUser;
import com.mecha.api.repository.IAppUserRepository;
import com.mecha.api.service.interfaces.IAppUserService;

@Service
public class AppUserService implements IAppUserService {
    
    @Autowired
    private IAppUserRepository appUserRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public List<AppUser> findAll() {
        return appUserRepository.findAll();
    }
    
    @Override
    public void save(AppUser appUser) {
        // Encriptar la contraseña antes de guardar
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUserRepository.save(appUser);
    }
    
    @Override
    public AppUser findById(Long id) {
        return appUserRepository.findById(id).orElseThrow(() -> new RuntimeException("AppUser not found"));
    }
    
    @Override
    public void deleteById(Long id) {
        AppUser appUser = this.findById(id);
        appUserRepository.delete(appUser);
    }
    
    @Override
    public void update(Long id, AppUser appUser) {
        AppUser appUserUpdated = this.findById(id);
        appUserUpdated.setUsername(appUser.getUsername());
        appUserUpdated.setEmail(appUser.getEmail());
        // Encriptar la contraseña antes de guardar
        appUserUpdated.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUserUpdated.setPhoneNumber(appUser.getPhoneNumber());
        appUserUpdated.setEnabled(appUser.isEnabled());
        appUserUpdated.setAccountNotExpired(appUser.isAccountNotExpired());
        appUserUpdated.setAccountNotLocked(appUser.isAccountNotLocked());
        appUserUpdated.setCredentialNotExpired(appUser.isCredentialNotExpired());
        appUserUpdated.setRoles(appUser.getRoles());
        appUserRepository.save(appUserUpdated);
    }
    
}
