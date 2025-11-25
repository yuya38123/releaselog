package com.example.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Organizations {

	private int id;
	private String name;
	private LocalDateTime createdAt;
}
