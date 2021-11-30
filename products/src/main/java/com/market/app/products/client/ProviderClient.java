package com.market.app.products.client;

import java.math.BigInteger;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.market.app.products.model.Provider;

@FeignClient(name = "provider-service", url = "http://localhost:8003")
@RequestMapping("/providers")
public interface ProviderClient {
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Provider>> getProviderById(@RequestHeader("Authorization") String header, @PathVariable BigInteger id);
	
}
