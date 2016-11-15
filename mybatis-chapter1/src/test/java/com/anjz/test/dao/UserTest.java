package com.anjz.test.dao;

import javax.annotation.Resource;

import org.junit.Test;

import com.anjz.dao.AbcUserDao;
import com.anjz.model.AbcUser;
import com.anjz.test.BaseTest;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;

/**
 * 
 * @author shuai.ding
 * @date 2016年11月8日下午3:43:01
 */
public class UserTest extends BaseTest{
	
	@Resource
	private AbcUserDao abcUserDao;
	
	
	@Test
	public void insertTest(){
		for(int i=0;i<20;i++){
			AbcUser user = new AbcUser();
			user.setUserName("test");
			user.setPassword("123456");
			abcUserDao.insertSelective(user);
		}		
	}
	
	
	/**
	 * 列表测试
	 */
	@Test
	public void findTest(){
		abcUserDao.find();
	}
	
	/**
	 * 分页测试
	 */
	@Test
	public void findByPage(){
		PageBounds pageBounds = new PageBounds(6,2);		
		PageList<AbcUser> pageList= abcUserDao.find(pageBounds);
		
		Paginator paginator =  pageList.getPaginator();
		System.out.println("总记录数："+paginator.getTotalCount());
		System.out.println("页数："+paginator.getPage());
		System.out.println("分页大小："+paginator.getLimit());
		
		Integer[] showNumber=paginator.slider(10);
		StringBuffer strTemp=new StringBuffer();
		for(Integer number:showNumber){
			strTemp.append(number+",");
		}
		System.out.println(strTemp.substring(0, strTemp.length()-1));
	}
}
