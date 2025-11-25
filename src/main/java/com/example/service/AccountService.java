package com.example.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.DTO.RegisterRequest;
import com.example.exception.EmailAlreadyUsedException;
import com.example.mapper.MembershipsMapper;
import com.example.mapper.OrganizationMapper;
import com.example.mapper.UserMapper;
import com.example.model.MembershipRole;
import com.example.model.Memberships;
import com.example.model.Organizations;
import com.example.model.User;

@Service
public class AccountService {

	@Autowired
	UserMapper userMapper;
	@Autowired
	OrganizationMapper organizationMapper;
	@Autowired
	MembershipsMapper membershipsMapper;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Transactional
	public void registerUser(RegisterRequest rr) {

		if (existsByEmail(rr.getEmail())) {
			throw new EmailAlreadyUsedException(rr.getEmail());
		}
		User user = new User();
		BeanUtils.copyProperties(rr, user);
		user.setPasswordHash(passwordEncoder.encode(rr.getPassword()));
		userMapper.insert(user);

		Organizations organizations = new Organizations();
		organizations.setName(rr.getDisplayName());
		organizationMapper.insert(organizations);

		Memberships memberships = new Memberships();
		memberships.setUserId(user.getId());
		memberships.setOrgId(organizations.getId());
		memberships.setRole(MembershipRole.OWNER);
		membershipsMapper.insert(memberships);

	}

	public boolean existsByEmail(String email) {
		User user = userMapper.selectByEmail(email);

		if (user == null) {
			return false;
		}

		return true;
	}

}
