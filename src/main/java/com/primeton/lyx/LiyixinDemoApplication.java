package com.primeton.lyx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;



@SpringBootApplication
@EnableSwagger2
@MapperScan("com.primeton.lyx.dao")
public class LiyixinDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiyixinDemoApplication.class, args);
	}
}
