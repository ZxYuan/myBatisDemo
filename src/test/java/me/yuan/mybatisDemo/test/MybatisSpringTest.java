package me.yuan.mybatisDemo.test;

import java.util.List;

import me.yuan.mybatisDemo.inter.IUserOperation;
import me.yuan.mybatisDemo.model.User;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MybatisSpringTest {
	//@Test
	public void testSelect() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");  
		IUserOperation mapper = (IUserOperation)ctx.getBean("userMapper"); 
		
		User user = mapper.selectUserByID(3);
		System.out.println(user.getUserAddress()); 
	}
	
	//@Test
	public void testSelectList() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");  
		IUserOperation mapper = (IUserOperation)ctx.getBean("userMapper"); 
		
		List<User> userList = mapper.selectUsers("summer");
		for(User user : userList){
        	System.out.println(user.getUserName());
        	System.out.println(user.getUserAddress());
        }
	}
	
	//@Test
	public void testAdd() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");  
		IUserOperation mapper = (IUserOperation)ctx.getBean("userMapper"); 
		
		User user=new User();
        user.setUserAddress("火星");
        user.setUserName("summer");
        user.setUserAge(80);
		mapper.addUser(user); // who did session.commit()?
		System.out.println("Please check the db to see if the user is inserted");
	}
	
	//@Test
	public void testUpdate() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");  
		IUserOperation mapper = (IUserOperation)ctx.getBean("userMapper"); 
		
		User user = mapper.selectUserByID(4);
		user.setUserAddress("too simple");
		mapper.updateUser(user); // who did session.commit()?
		System.out.println("Please check the db to see if the user is updated");
	}
	
	@Test
	public void testDelete() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");  
		IUserOperation mapper = (IUserOperation)ctx.getBean("userMapper"); 
		mapper.deleteUser(6); // who did session.commit()?
		System.out.println("Please check the db to see if the user is deleted");
	}
}
