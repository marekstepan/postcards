package com.ms.postcards.services;

import com.ms.postcards.dto.RegisterRequest;
import com.ms.postcards.dto.RegisterResponse;
import com.ms.postcards.exceptions.UserAlreadyExistsException;
import com.ms.postcards.models.User;
import com.ms.postcards.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

  private final UserRepository userRepository;
  PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
  @Value("${passwordLength:0}")
  private int passwordLength;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User registerUser(RegisterRequest registerRequest) throws UserAlreadyExistsException {
    if (isUsernameUsed(registerRequest.getUsername())) {
      throw new UserAlreadyExistsException("There is a already a user with the name: " + registerRequest.getUsername());
    }
    User user = new User();
    user.setUsername(registerRequest.getUsername());
    user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
    user.setCreated(new Timestamp(System.currentTimeMillis()));
    user.setEdited(new Timestamp(System.currentTimeMillis()));
    userRepository.save(user);
    return user;
  }

  @Override
  public boolean isUsernameUsed(String username) {
    return userRepository.findByUsername(username).isPresent();
  }

  @Override
  public boolean wrongPasswordLength(String password) {
    return password.length() < passwordLength;
  }

  @Override
  public User loadUserByUsername(String username) throws UsernameNotFoundException {
    if (userRepository.findByUsername(username).isPresent()) {
      return userRepository.findByUsername(username).get();
    } else {
      throw new UsernameNotFoundException("There is no user with name: " + username);
    }
  }

  @Override
  public RegisterResponse generateUserResponse(User user) {
    RegisterResponse response = new RegisterResponse();
    response.setId(user.getId());
    response.setUsername(user.getUsername());
    return response;
  }

}
