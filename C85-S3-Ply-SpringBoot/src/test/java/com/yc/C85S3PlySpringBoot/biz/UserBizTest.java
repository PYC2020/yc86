package com.yc.C85S3PlySpringBoot.biz;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import com.yc.C85S3PlySpringBoot.dao.UserDao;
import com.yc.damai.bean.DmUser;

@SpringBootTest
public class UserBizTest {
	@MockBean
	private UserDao udao;
	@Resource
	private UserBiz ubiz;

	@Test
	public void testlogin() {

		try {
			DmUser u = new DmUser();
			Mockito.when(udao.selectByLogin("武松", "123")).thenReturn(u);
			DmUser user=ubiz.login("武松","123");
			Assert.isTrue(user != null, "没抄到");
			System.out.println("测试完成");

		} catch (BizException e) {
			// TODO Auto-generated catch block
			Assert.isTrue(e == null, "dao类异常");
			e.printStackTrace();
		}

//		

	}
}
