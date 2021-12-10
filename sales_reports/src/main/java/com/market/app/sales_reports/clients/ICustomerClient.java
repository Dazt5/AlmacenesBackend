package com.market.app.sales_reports.clients;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.market.app.sales_reports.model.Customer;

@FeignClient(name = "customer-service", url = "http://localhost:8001/customers")
public interface ICustomerClient {

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Customer>> getById(@RequestHeader("Authorization") String header, @PathVariable BigInteger id);
	
}
