package com.anjz.test.dao;

import javax.annotation.Resource;

import org.junit.Test;

import com.anjz.dao.AbcUserDao;
import com.anjz.test.BaseTest;

/**
 * 
 * @author shuai.ding
 * @date 2016年11月8日下午3:43:01
 */
public class UserTest extends BaseTest{
	
	@Resource
	private AbcUserDao abcUserDao;
	
	@Test
	public void findTest(){
		abcUserDao.find();
	}
}
