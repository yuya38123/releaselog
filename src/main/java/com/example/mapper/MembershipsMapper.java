package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.model.Memberships;

@Mapper
public interface MembershipsMapper {

	public void insert(Memberships memberships);
}
