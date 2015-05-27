package me.yuan.mybatisDemo.test;

import me.yuan.mybatisDemo.inter.IUserOperation;
import me.yuan.mybatisDemo.model.User;

import org.junit.Test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyTest {
	
	//@Test
	public void testSelect() throws Exception {
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
        	System.out.println(user.getUserName());
        	System.out.println(user.getUserAddress());
        } finally {
        	session.close();
        }
	}
	
	//@Test
	public void testSelectList() throws Exception {
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
            List<User> userList = userOperation.selectUsers("summer");
            for(User user : userList){
            	System.out.println(user.getUserName());
            	System.out.println(user.getUserAddress());
            }
        	
        } finally {
        	session.close();
        }
	}
	
	//@Test
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
		User user=new User();
        user.setUserAddress("火星");
        user.setUserName("江蛤蛤");
        user.setUserAge(80);
		try {
        	//User user = (User) session.selectOne("me.yuan.mybatisDemo.models.UserMapper.selectUserByID", 1);
        	IUserOperation userOperation=session.getMapper(IUserOperation.class);
            userOperation.addUser(user);
            session.commit();
            System.out.println("Please check the db to see if the user is inserted");
        } finally {
        	session.close();
        }
	}
	
	//@Test
	public void testUpdate() throws Exception {
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
        	User user = userOperation.selectUserByID(4);            
            user.setUserAddress("Naive");
            userOperation.updateUser(user);
            session.commit();
            System.out.println("Please check the db to see if the user is updated");
        } finally {
        	session.close();
        }
	}
	
	@Test
	public void testDelete() throws Exception {
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
            userOperation.deleteUser(2);
            session.commit();
            System.out.println("Please check the db to see if the user is deleted");
        } finally {
        	session.close();
        }
	}

}

