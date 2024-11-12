package com.authentication.service;

import com.authentication.dto.LoginUser;
import com.authentication.dto.RegisterUser;
import com.authentication.entity.User;

public interface AuthenticationService {
    User signUp(RegisterUser registerUser);
    User authenticate(LoginUser loginUser);
    Boolean isUserLoggedIn();
}
