package com.market.app.customers.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.app.customers.entity.Customer;
import com.market.app.customers.repository.ICustomerRepository;
import com.market.app.customers.services.interfaces.ICustomerService;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService{

	@Autowired
	ICustomerRepository customerRepository;

	@Override
	public ArrayList<Customer> getAll() {		
		return (ArrayList<Customer>) customerRepository.findAll();
	}

	@Override
	public Optional<Customer> getById(BigInteger id) {		
		return customerRepository.findById(id);
	}

	@Override
	public Customer create(Customer customer) {		
		return customerRepository.save(customer);
	}

	@Override
	public Customer update(Customer customer, BigInteger id) {
		Customer actualCustomer = customerRepository.findById(id).orElse(null);
		
		if(actualCustomer == null) return null;
		
		actualCustomer.setNombre_cliente(customer.getNombre_cliente());
		actualCustomer.setDireccion_cliente(customer.getDireccion_cliente());
		actualCustomer.setTelefono_cliente(customer.getTelefono_cliente());
		actualCustomer.setEmail_cliente(customer.getEmail_cliente());
		
		return customerRepository.save(actualCustomer);		
	}

	@Override
	public void delete(BigInteger id) {
		customerRepository.deleteById(id);		
	}
	
	
	
}