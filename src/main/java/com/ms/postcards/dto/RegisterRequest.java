package com.ms.postcards.dto;

import com.ms.postcards.validation.Extended;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

  @NotBlank(message = "Username is required!!")
  private String username;

  @NotBlank(message = "Password is required")
  @Size(min = 8, groups = Extended.class, message = "Password must be at least 8 Characters long!")
  private String password;

}
