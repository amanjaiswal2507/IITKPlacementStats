package com.Aman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.Aman.demo.controller"})
public class BootIitkApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(BootIitkApplication.class, args);
	}
	

}
