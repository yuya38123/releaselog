package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.LoginRequest;
import com.example.DTO.RegisterRequest;
import com.example.service.AccountService;

import lombok.Data;

@RestController
@RequestMapping("/api/auth")
public class AccountController {

	@Autowired
	AccountService accountService;

	@PostMapping("/register")
	public ResponseEntity<Void> registerUser(@RequestBody RegisterRequest rr) {

		accountService.registerUser(rr);

		return ResponseEntity.ok().build();
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest lr) {

		String res = accountService.login(lr);

		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setDisplayName(res);
		return ResponseEntity.ok(loginResponse);
	}

	@Data
	private class LoginResponse {
		private String displayName;
	}

}
