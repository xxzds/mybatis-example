package com.anjz.test;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.anjz.model.AbcUser;
import com.anjz.utils.SqlSessionFactoryUtil;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;

/**
 * 
 * @author shuai.ding
 * @date 2016年11月8日下午4:36:51
 */
public class UserTest {

	public SqlSession session;
	
	@Before
	public void getSqlSession(){
		session = SqlSessionFactoryUtil.getSqlSession();
	}
	
	@After
	public void closeSqlSession(){
		SqlSessionFactoryUtil.closeSqlSession(session);
	}
	
	@Test
	public void queryUser(){
		List<AbcUser> list= session.selectList("UserMapper.queryUser");
		for(AbcUser user:list){
			System.out.println(user);
		}
	}
	
	
	/**
	 * 通过插件进行分页，测试
	 */
	@Test
	public void queryUserPage(){
		PageBounds pageBounds = new PageBounds(1,2);		
		List<AbcUser> list=session.selectList("UserMapper.queryUser", null,pageBounds);
		
		PageList<AbcUser> pageList = (PageList<AbcUser>)list; 
		
		Paginator paginator =  pageList.getPaginator();
		System.out.println("总记录数："+paginator.getTotalCount());
		System.out.println("页数："+paginator.getPage());
		System.out.println("分页大小："+paginator.getLimit());
		
		Integer[] showNumber=paginator.getSlider();
		for(Integer number:showNumber){
			System.out.print(number+",");
		}
		System.out.println();
	}
	
	@Test
	public void findUserById(){
		Integer id = 1;
		AbcUser user = session.selectOne("UserMapper.findUserById",id);
		if(user!=null){
			System.out.println(user);
		}
	}
	
	@Test
	public void findUserByName(){
		String name = "t";
		List<AbcUser> users = session.selectList("UserMapper.findUserByName",name);
		for(AbcUser user : users){
			System.out.println(user);
		}
	}
	
	@Test
	public void addUser(){
		AbcUser user = new AbcUser();
		user.setUser_name("now");
		user.setPassword("444");
		session.insert("UserMapper.addUser", user);
		session.commit();
	}
	
	@Test
	public void updateUser(){
		AbcUser user = new AbcUser();
		user.setId(1);
		user.setUser_name("我的嗨了");
		user.setPassword("123456");
		session.insert("UserMapper.updateUser", user);
		session.commit();
	}
	
	@Test
	public void deleteUser(){
		Integer id = 2;
		session.delete("UserMapper.deleteUser",id);
		session.commit();
	}
}
