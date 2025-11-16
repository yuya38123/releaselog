package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mapper.UserMapper;
import com.example.model.User;

@Service
public class AccountService {

	@Autowired
	UserMapper userMapper;

	@Transactional
	public void registerUser(User user) {

		userMapper.insert(user);
	}
}
