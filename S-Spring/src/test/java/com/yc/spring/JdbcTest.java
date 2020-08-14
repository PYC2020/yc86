package com.yc.spring;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.yc.spring.bank.biz.BankBiz;

@RunWith(SpringRunner.class)
@ContextConfiguration("/jdbc.xml")
public class JdbcTest {

	@Autowired
	private JdbcTemplate jdbcTemplate; // DBHelper

	@Autowired
	private BankBiz bbiz;

//	@Test
//	public void test1() {
//		jdbcTemplate.update("insert into account values(NULL,'D',2000)");
//	}

//	@Test
//	public void test2() {
//		bbiz.register(6, "aB", 12000);
//		bbiz.register(5, "aC", 32000);
//	}
//
	@Test
	public void test3() {
		bbiz.save(1, 500);
	}







}