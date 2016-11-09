package com.anjz.utils;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * sqlSession工具类
 * @author shuai.ding
 * @date 2016年11月8日下午4:20:57
 */
public class SqlSessionFactoryUtil {
	private static String XML_PATH = "mybatis-config.xml";
	private static SqlSessionFactory factory;
	
	static{
		Reader r = null;
		try {
			r = Resources.getResourceAsReader(XML_PATH);
			factory = new SqlSessionFactoryBuilder().build(r);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取应用中的SqlSessionFactory
	 * @return SqlSessionFactory
	 */
	public static SqlSessionFactory getSqlSessionFactory(){
		return factory;
	}
	
	/**
	 * 获取应用中的SqlSession
	 * @return SqlSession
	 */
	public static SqlSession getSqlSession(){
		return factory.openSession();
	}
	
	/**
	 * 关闭SqlSession
	 * @param session
	 */
	public static void closeSqlSession(SqlSession session){
		if(session != null){
			session.close();
		}
	}
}
