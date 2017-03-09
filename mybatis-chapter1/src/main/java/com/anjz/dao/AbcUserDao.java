package com.anjz.dao;

import java.util.List;

import com.anjz.model.AbcUser;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface AbcUserDao {
	
	public int insertSelective(AbcUser user);
	
	public AbcUser findById(Integer id);
	
	public List<AbcUser> find(AbcUser user);
	
	public List<AbcUser> findTest(AbcUser user);
	
	public PageList<AbcUser> find(PageBounds pageBounds);
}