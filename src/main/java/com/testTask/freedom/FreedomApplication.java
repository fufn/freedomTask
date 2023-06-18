package com.testTask.freedom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FreedomApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreedomApplication.class, args);
	}

}
