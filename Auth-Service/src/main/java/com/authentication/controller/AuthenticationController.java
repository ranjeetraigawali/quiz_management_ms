package com.authentication.controller;

import com.authentication.dto.LoginResponse;
import com.authentication.dto.LoginUser;
import com.authentication.dto.RegisterUser;
import com.authentication.entity.User;
import com.authentication.service.AuthenticationService;
import com.authentication.service.impl.AuthenticationServiceImpl;
import com.authentication.service.impl.JWTServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final JWTServiceImpl jwtService;
    private final AuthenticationService authenticationService;

    public AuthenticationController(JWTServiceImpl jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUser registerUser) {
        User registeredUser = authenticationService.signUp(registerUser);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUser loginUser) {
        User authenticatedUser = authenticationService.authenticate(loginUser);
        String jwtToken = jwtService.generateToken(authenticatedUser);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());
        return ResponseEntity.ok(loginResponse);
    }
}
