package com.sipl.hibernate.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = { "com.sipl.hibernate.example" })

public class HibernateExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateExampleApplication.class, args);
	}

}
