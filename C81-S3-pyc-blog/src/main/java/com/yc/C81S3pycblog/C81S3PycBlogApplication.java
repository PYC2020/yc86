package com.yc.C81S3pycblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("dao")
public class C81S3PycBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(C81S3PycBlogApplication.class, args);
	}

}
