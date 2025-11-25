package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.model.Organizations;

@Mapper
public interface OrganizationMapper {

	public void insert(Organizations organizations);
}
