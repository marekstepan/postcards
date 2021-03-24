package com.ms.postcards.controllers;

import com.ms.postcards.dto.LoginRequest;
import com.ms.postcards.dto.LoginResponse;
import com.ms.postcards.dto.UserInfoResponse;
import com.ms.postcards.exceptions.BadLoginException;
import com.ms.postcards.exceptions.MissingParameterException;
import com.ms.postcards.models.User;
import com.ms.postcards.security.JwtTokenUtility;
import com.ms.postcards.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

  @Autowired
  private JwtTokenUtility jwtTokenUtility;
  @Autowired
  private AuthenticationManager authenticationManager;
  @Autowired
  private UserServiceImpl userServiceImpl;

  @PostMapping("/login")
  public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest loginRequest) throws Exception {

    if (loginRequest.getPassword() == null || loginRequest.getPassword().isEmpty()) {
      throw new MissingParameterException("Password is required");
    } else if (loginRequest.getUsername() == null || loginRequest.getUsername().isEmpty()) {
      throw new MissingParameterException("Username is required");
    }
    try {
      authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
      );
    } catch (BadCredentialsException e) {
      throw new BadLoginException("Bad login");
    }

    final User userDetails = userServiceImpl.loadUserByUsername(loginRequest.getUsername());
    String token = jwtTokenUtility.generateToken(userDetails);
    LoginResponse response = new LoginResponse();
    response.setStatus("OK");
    response.setPostcardsToken(token);
    return ResponseEntity.ok(response);
  }

  @GetMapping("/userinfo")
  public ResponseEntity<?> getUserInfo(Principal principal) {

    User user = userServiceImpl.loadUserByUsername(principal.getName());
    UserInfoResponse userInfo = new UserInfoResponse();
    userInfo.setUserId(user.getId());
    userInfo.setUsername(user.getUsername());
    return new ResponseEntity<>(userInfo, HttpStatus.OK);
  }

}

