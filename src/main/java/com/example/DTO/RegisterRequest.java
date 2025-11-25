package com.example.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class RegisterRequest {
	@NotEmpty
	String email;
	@NotEmpty
	String password;
	@NotEmpty
	String displayName;
}
