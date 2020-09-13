package com.yc.C81S3pycblog;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import bean.Category;
import dao.CategoryMapper;

@SpringBootTest
class C81S3PycBlogApplicationTests {

	@Resource
	private CategoryMapper cm;
	
	@Test
	void contextLoads() {
		for(Category c:cm.selectAll()) {
			System.out.println(c.getName());
		}
	}

}
