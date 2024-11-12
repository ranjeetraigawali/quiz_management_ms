package com.quiz.service;

import com.quiz.dto.LoginResponse;
import com.quiz.dto.LoginUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "auth-service")
public interface AuthenticationClient {

    @GetMapping("/auth/authenticatedUser")
    Boolean isUserLoggedIn();

    @PostMapping("/auth/login")
    LoginResponse authenticate(@RequestBody LoginUser loginUser);
}
