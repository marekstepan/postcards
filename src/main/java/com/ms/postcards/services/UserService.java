package com.ms.postcards.services;

import com.ms.postcards.dto.RegisterRequest;
import com.ms.postcards.dto.RegisterResponse;
import com.ms.postcards.exceptions.UserAlreadyExistsException;
import com.ms.postcards.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {

  User registerUser(RegisterRequest registerRequest) throws UserAlreadyExistsException;

  boolean isUsernameUsed(String username);

  boolean wrongPasswordLength(String password);

  User loadUserByUsername(String username);

  RegisterResponse generateUserResponse(User user);
}
