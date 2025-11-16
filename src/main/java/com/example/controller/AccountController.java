package com.example.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.AccountService;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@RestController
@RequestMapping("/api/auth")
public class AccountController {

	@Autowired
	AccountService accountService;

	@PostMapping("/register")
	public ResponseEntity<Void> registerUser(@RequestBody RegisterRequest rr) {

		User registerUserInfo = new User();

		BeanUtils.copyProperties(rr, registerUserInfo);

		accountService.registerUser(registerUserInfo);

		return ResponseEntity.ok().build();
	}

	@Data
	static class RegisterRequest {
		@NotEmpty
		String email;
		@NotEmpty
		String password;
		@NotEmpty
		String displayName;
	}
}