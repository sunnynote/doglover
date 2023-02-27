package com.mytest.doglover;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class DogloverApplication {

	public static void main(String[] args) {
		SpringApplication.run(DogloverApplication.class, args);
	}

}
