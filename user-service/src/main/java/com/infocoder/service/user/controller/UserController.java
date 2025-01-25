package com.infocoder.service.user.controller;

import com.infocoder.service.user.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping
    public User getUser() {
        return User
                .builder()
                .fullName("Madhva Ponnana")
                .email("madhav@gmal.com")
                .phone("+91-9324256789")
                .role("Customer")
                .build();
    }

}
