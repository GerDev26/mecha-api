package com.mecha.api.controller.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mecha.api.model.AppUser;
import com.mecha.api.service.interfaces.IAppUserService;

@RestController
@RequestMapping("user")
public class AppUserController {

    @Autowired
    private IAppUserService appUserService;

    @GetMapping
    public List<AppUser> index() {
        return appUserService.findAll();
    }

    @GetMapping("/{id}")
    public AppUser show(@PathVariable Long id) {
        return appUserService.findById(id);
    }
    
    @PostMapping
    public void store(@RequestBody AppUser appUser) {
        appUserService.save(appUser);
    }
    
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody AppUser appUser) {
        appUserService.update(id, appUser);
    }
    
    @DeleteMapping("/{id}")
    public void destroy(@PathVariable Long id) {
        appUserService.deleteById(id);
    }

}
