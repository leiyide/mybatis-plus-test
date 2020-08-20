/**
 * 
 */
package com.leiyide;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Title:Swagger2
 * @Description: Swagger2配置类
 * @Company: 维坤智能科技 
 * @version v0.1
 * @author leiyide
 * @date 2019年6月17日 上午11:42:01
 */
@Configuration
public class Swagger2 {
	
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.leiyide.data.controler"))
				.paths(PathSelectors.any())
				.build();
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("springboot利用swagger构建api文档")
				.description("简单优雅的restfun风格")
				.version("v1.0")
				.build();
	}
}
