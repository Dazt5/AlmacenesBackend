package com.market.app.customers.controllers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.market.app.customers.dto.GeneralResponseDTO;
import com.market.app.customers.entity.Customer;
import com.market.app.customers.services.implementations.CustomerServiceImpl;

import static com.market.app.customers.utils.Constants.SuccessFulMessages.*;
import static com.market.app.customers.utils.Constants.ErrorMessages.*;

@CrossOrigin
@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerServiceImpl customerService;
	
	@GetMapping("/")
	public ResponseEntity<ArrayList<Customer>> getAllCustomers() {
		return ResponseEntity.ok().body(customerService.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Customer>> getById(@PathVariable BigInteger id){
		return ResponseEntity.ok().body(customerService.getById(id));
	}
	
	@PostMapping("/")
	public ResponseEntity<GeneralResponseDTO> createCustomer(@RequestBody Customer customer){
		try {
			
			if(customer.getCedula_cliente() == null) {
				GeneralResponseDTO response = new GeneralResponseDTO();
				response.setMessage("La cédula del cliente es obligatoria");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			}
			
			Customer customerExist = customerService.getById(customer.getCedula_cliente()).orElse(null);
			
			if(customerExist != null) {
				GeneralResponseDTO response = new GeneralResponseDTO();
				response.setMessage(MESSAGE_RESOURCE_CONFLICT);
				return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
			}
			
			customerService.create(customer);
			GeneralResponseDTO response = new GeneralResponseDTO();
			response.setMessage(MESSAGE_RESOURCE_CREATED);
			return ResponseEntity.ok().body(response);
			
		} catch (Exception exception){			
			GeneralResponseDTO response = new GeneralResponseDTO();
			response.setMessage(MESSAGE_INTERNAL_SERVER_ERROR + exception.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<GeneralResponseDTO> updateCustomerById(@RequestBody Customer customer, @PathVariable BigInteger id) {
		try {			
			Customer actualCustomer = customerService.update(customer, id);
			if(actualCustomer == null) {
				GeneralResponseDTO response = new GeneralResponseDTO();
				response.setMessage(MESSAGE_RESOURCE_NOT_FOUND);
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
			}
			GeneralResponseDTO response = new GeneralResponseDTO();
			response.setMessage(MESSAGE_RESOURCE_UPDATED);
			return ResponseEntity.ok().body(response);
		} catch (Exception exception) {
			GeneralResponseDTO response = new GeneralResponseDTO();
			response.setMessage(MESSAGE_INTERNAL_SERVER_ERROR + exception.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<GeneralResponseDTO> deleteCustomerByid(@PathVariable BigInteger id){
		try {
			Customer customerExist = customerService.getById(id).orElse(null);
			if(customerExist == null) {
				GeneralResponseDTO response = new GeneralResponseDTO();
				response.setMessage(MESSAGE_RESOURCE_NOT_FOUND);
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
			}
			customerService.delete(id);
			GeneralResponseDTO response = new GeneralResponseDTO();
			response.setMessage(MESSAGE_RESOURCE_DELETED);
			return ResponseEntity.ok().body(response);
		} catch (Exception exception) {
			GeneralResponseDTO response = new GeneralResponseDTO();
			response.setMessage(MESSAGE_INTERNAL_SERVER_ERROR + exception.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}
	
}
