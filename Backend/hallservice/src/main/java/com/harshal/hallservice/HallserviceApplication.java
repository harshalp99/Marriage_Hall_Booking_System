package com.harshal.hallservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HallserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HallserviceApplication.class, args);
	}

}
