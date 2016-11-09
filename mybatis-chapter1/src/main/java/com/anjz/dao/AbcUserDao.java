package com.anjz.dao;

import java.util.List;

import com.anjz.model.AbcUser;

public interface AbcUserDao {
	
	public AbcUser findById(Integer id);
	
	public List<AbcUser> find();
}