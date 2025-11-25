package com.example.model;

import lombok.Data;

@Data
public class Memberships {

	private int id;
	private int userId;
	private int orgId;
	private MembershipRole role;

}
