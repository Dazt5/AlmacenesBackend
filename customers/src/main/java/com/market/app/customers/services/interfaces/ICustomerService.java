package com.market.app.customers.services.interfaces;

import com.market.app.customers.dto.CustomerRequestDTO;
import com.market.app.customers.entity.Customer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Optional;

public interface ICustomerService {
	
	public ArrayList<Customer> getAll();
	public Optional<Customer> getById(BigInteger id);
	public Customer create(CustomerRequestDTO customer);
	public Customer update(Customer customer, BigInteger id);
	public void delete(BigInteger id);
	
}
