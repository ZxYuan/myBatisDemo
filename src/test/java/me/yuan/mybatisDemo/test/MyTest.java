package me.yuan.mybatisDemo.test;

import me.yuan.mybatisDemo.inter.IUserOperation;
import me.yuan.mybatisDemo.model.User;

import org.junit.Test;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyTest {
	
	@Test
	public void testAdd() throws Exception {
		Reader reader = null;
		SqlSessionFactory sqlSessionFactory = null;
		
		try{
			reader    = Resources.getResourceAsReader("Configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }catch(Exception e){
            e.printStackTrace();
        }
		
		SqlSession session = sqlSessionFactory.openSession();
        try {
        	//User user = (User) session.selectOne("me.yuan.mybatisDemo.models.UserMapper.selectUserByID", 1);
        	IUserOperation userOperation=session.getMapper(IUserOperation.class);
            User user = userOperation.selectUserByID(1);
        	System.out.println(user.getUserAddress());
        	System.out.println(user.getUserName());
        } finally {
        	session.close();
        }
	}

}

