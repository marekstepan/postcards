package com.ms.postcards.security;

import com.ms.postcards.models.User;
import com.ms.postcards.repositories.UserRepository;
import com.ms.postcards.services.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@ComponentScan("com.ms.postcards")
class JwtTokenUtilityTest {

  JwtTokenUtility jwtTokenUtility = new JwtTokenUtility();
  String token =
              "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTYxODgzMzA0NSwiaWF0IjoxNjE3MzYxOD"
    + "E2fQ.bIV6T9hzBMNXd_72mupMjDp65voLjVjh32uc_0HiRKo";

  String tokenNoExp =
      "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTYxNzM2MTY4MH0.-TsAPiR-ri6M0mx9Ew7kPRh6_v"
    + "fs2MBjyqVF1xZLMfY";

  @MockBean
  private UserRepository userRepository;

  @InjectMocks
  private UserServiceImpl userServiceImpl = new UserServiceImpl(userRepository);

  @Test
  void extractUsername() {
    assertEquals("admin", jwtTokenUtility.extractUsername(token));
  }

  @Test
  void extractExpiration() {
    Date date = jwtTokenUtility.extractExpiration(token);
    System.out.println(date);
    assertTrue(date.after(new Date()));
  }

  @Test
  void validateToken() {
    User user = new User();
    user.setUsername("admin");

    assertTrue(jwtTokenUtility.validateToken(tokenNoExp, user));
  }

}