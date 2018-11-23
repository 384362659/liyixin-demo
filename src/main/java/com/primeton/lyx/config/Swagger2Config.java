package com.primeton.lyx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
	/**
	 * swagger 2的配置文件，swagg
	 * er2的内容配置在这里
	 * @return
	 */
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				//扫描的controller定义的api在哪个包下
				.apis(RequestHandlerSelectors.basePackage("com.primeton.lyx.controller"))
				.paths(PathSelectors.any())
				.build();
	}
	/**
	 * 构建API详细信息
	 * @return
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				//标题
				.title("springboot利用swagger构建api文档")
				//描述
				.description("简单优雅的restfun风格")
				// 创建人
				.contact(new Contact("李一新", "", "lyx708152lyx@163.com"))
				//版本号
				.version("1.0")
				.build();
	}

}
