package com.authentication.service.impl;

import com.authentication.dto.LoginUser;
import com.authentication.dto.RegisterUser;
import com.authentication.entity.User;
import com.authentication.repository.UserRepository;
import com.authentication.service.AuthenticationService;
import com.authentication.service.JWTService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTServiceImpl jwtServiceImpl;

    public AuthenticationServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JWTServiceImpl jwtServiceImpl){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtServiceImpl = jwtServiceImpl;
    }
    @Override
    public User signUp(RegisterUser registerUser) {
        User user = new User();
        user.setName(registerUser.getName());
        user.setEmail(registerUser.getEmail());
        user.setPassword(passwordEncoder.encode(registerUser.getPassword()));
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());
        return userRepository.save(user);
    }

    @Override
    public User authenticate(LoginUser loginUser) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getEmail(),
                        loginUser.getPassword()
                )
        );
        return userRepository.findByEmail(loginUser.getEmail()).orElseThrow();
    }

    @Override
    public Boolean isUserLoggedIn() {
        Authentication  authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null) {
            Object object = authentication.getPrincipal();
            if(object != null)
                return true;
        }
        return false;
    }

    public void validateToken(String token) {
        jwtServiceImpl.validateToken(token);
    }
}
