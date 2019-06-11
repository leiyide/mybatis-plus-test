package com.leiyide;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.leiyide.data.domain.mapper"})
public class MybatPlusTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatPlusTestApplication.class, args);
	}

}
