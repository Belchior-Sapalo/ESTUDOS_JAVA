package com.belchiorsapalo.api.configs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.belchiorsapalo.api.domain.User;
import com.belchiorsapalo.api.repositories.UserRepository;

import jakarta.annotation.PostConstruct;

@Configuration
@Profile("local")
public class LocalConfig {
    
    private UserRepository uRepository;

    @Autowired
    public LocalConfig(UserRepository uRepository){
        this.uRepository = uRepository;
    }

    @PostConstruct
    public void startDB(){
        User u1 = new User(null, "Belchior", "belchior@gmail.com", "1234");
        User u2 = new User(null, "Agostinho", "agostinho@gmail.com", "1234");

        uRepository.saveAll(List.of(u1, u2));
    }
}
