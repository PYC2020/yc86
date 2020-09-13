package com.yc.C85S3PlySpringBoot;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.yc.C85S3PlySpringBoot.biz.MailService;
import com.yc.C85S3PlySpringBoot.dao.ProductMapper;

@SpringBootTest
class C85S3PlySpringBootApplicationTests {
	@Resource
	ProductMapper pm;
	@Resource
	MailService ms;
	@Test
	void contextLoads() {
		Assert.isTrue(pm.selectAll().size()>0,"没有数据");
	}
	@Test
	void test2() {
		ms.sendSimpleMail("1607548751@qq.com","密码重置","你的验证码为123，请不要告诉别人");
	}

}
