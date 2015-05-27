package me.yuan.mybatisDemo.test;

import me.yuan.mybatisDemo.inter.IUserOperation;
import me.yuan.mybatisDemo.model.User;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MybatisSpringTest {
	@Test
	public void testDelete() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");  
		IUserOperation mapper = (IUserOperation)ctx.getBean("userMapper"); 
		
		User user = mapper.selectUserByID(3);
		System.out.println(user.getUserAddress()); 
	}
}
