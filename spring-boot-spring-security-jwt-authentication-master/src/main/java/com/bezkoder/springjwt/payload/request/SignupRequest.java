package com.bezkoder.springjwt.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SignupRequest {
  @NotBlank(message = "It's Null Bro !!")
  private String email;

  @NotBlank(message = "It's Null Bro !!")
  private String username;

  @NotBlank(message = "It's Null Bro !!")
  private String birthday;

  @NotBlank(message = "It's Null Bro !!")
  private String password;

  private Set<String> role;



}
