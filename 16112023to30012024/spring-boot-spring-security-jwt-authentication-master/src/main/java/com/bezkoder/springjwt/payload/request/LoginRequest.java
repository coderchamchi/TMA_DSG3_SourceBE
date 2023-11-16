package com.bezkoder.springjwt.payload.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginRequest {
	@NotBlank(message = "It's Null Bro !!")
  	private String email;

	@NotBlank(message = "It's Null Bro !!")
	private String password;
}
