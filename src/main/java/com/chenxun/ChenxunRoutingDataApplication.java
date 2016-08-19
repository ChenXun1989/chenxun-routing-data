package com.chenxun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;

@SpringBootApplication
public class ChenxunRoutingDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChenxunRoutingDataApplication.class, args);
	}
}
