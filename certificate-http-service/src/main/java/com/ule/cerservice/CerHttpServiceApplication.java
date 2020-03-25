package com.ule.cerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.ule.cerservice.mapper")
public class CerHttpServiceApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CerHttpServiceApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CerHttpServiceApplication.class);
	}
}
