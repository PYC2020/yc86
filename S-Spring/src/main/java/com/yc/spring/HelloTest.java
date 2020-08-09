package com.yc.spring;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yc.spring.dao.UserDao;

public class HelloTest {
	@Test
	public void Test() {
		ClassPathXmlApplicationContext ctx=
				new ClassPathXmlApplicationContext("beans.xml");
		Hello h=(Hello)ctx.getBean("Hello");
		h.say();
		ctx.close();
	}
	@Test
	public void Test1() {
		ClassPathXmlApplicationContext ctx=
				new ClassPathXmlApplicationContext("beans.xml");
		UserDao udao1=(UserDao) ctx.getBean("mdao");
		UserDao udao2=(UserDao) ctx.getBean("odao");
		udao1.selectUserId("zs");
		udao2.selectUserId("ls");
		ctx.close();
	}
}
