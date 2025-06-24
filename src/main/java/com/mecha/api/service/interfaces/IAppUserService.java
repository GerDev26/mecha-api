package com.mecha.api.service.interfaces;

import java.util.List;

import com.mecha.api.model.AppUser;

public interface IAppUserService {
    
    public List<AppUser> findAll();
    public void save(AppUser appUser);
    public AppUser findById(Long id);
    public void deleteById(Long id);
    public void update(Long id, AppUser appUser);

}
