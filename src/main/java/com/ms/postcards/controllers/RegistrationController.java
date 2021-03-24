package com.ms.postcards.controllers;

import com.ms.postcards.dto.RegisterRequest;
import com.ms.postcards.dto.RegisterResponse;
import com.ms.postcards.models.User;
import com.ms.postcards.services.UserServiceImpl;
import com.ms.postcards.validation.ValidationSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

  @Autowired
  private final UserServiceImpl userService;

  public RegistrationController(UserServiceImpl userService) {
    this.userService = userService;
  }

  @PostMapping("/register")
  public ResponseEntity<?> registerUser(@Validated(ValidationSequence.class)
                                        @RequestBody RegisterRequest registerRequest) {
    User user = userService.registerUser(registerRequest);
    RegisterResponse response = userService.generateUserResponse(user);
    return ResponseEntity.ok(response);
  }

}
