package com.example.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class User {

	private int id;
	private String email;
	private String passwordHash;
	private String displayName;
	private LocalDateTime createdAt;
}
