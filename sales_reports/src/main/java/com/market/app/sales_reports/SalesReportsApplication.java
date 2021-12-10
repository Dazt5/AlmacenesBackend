package com.market.app.sales_reports;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SalesReportsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesReportsApplication.class, args);
	}

}
