package com.mecha.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mecha.api.exceptions.NotFoundException;
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
    public AppUser save(AppUser appUser) {
        // Encriptar la contraseña antes de guardar
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUserRepository.save(appUser);
        return appUser;
    }
    
    @Override
    public AppUser findById(Long id) {
        return appUserRepository.findById(id).orElseThrow(() -> new NotFoundException("user not founded"));
    }
    
    @Override
    public void deleteById(Long id) {
        AppUser appUser = this.findById(id);
        appUserRepository.delete(appUser);
    }
    
    @Override
    public AppUser update(Long id, AppUser appUser) {
        AppUser appUserUpdated = this.findById(id);
        appUserUpdated.setEmail(appUser.getEmail());
        appUserUpdated.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUserUpdated.setAlias(appUser.getAlias());
        appUserUpdated.setName(appUser.getName());
        appUserUpdated.setLastname(appUser.getLastname());
        appUserUpdated.setPhoneNumber(appUser.getPhoneNumber());
        appUserUpdated.setEnabled(appUser.isEnabled());
        appUserUpdated.setAccountNotExpired(appUser.isAccountNotExpired());
        appUserUpdated.setAccountNotLocked(appUser.isAccountNotLocked());
        appUserUpdated.setCredentialNotExpired(appUser.isCredentialNotExpired());
        appUserUpdated.setRoles(appUser.getRoles());
        appUserRepository.save(appUserUpdated);
        return appUserUpdated;
    }
    
}
