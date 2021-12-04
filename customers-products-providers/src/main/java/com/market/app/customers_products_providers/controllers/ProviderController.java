package com.market.app.customers_products_providers.controllers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.market.app.customers_products_providers.dto.ProviderRequestDTO;
import com.market.app.customers_products_providers.entity.Provider;
import com.market.app.customers_products_providers.services.implementations.ProviderServiceImpl;
import com.market.app.customers_products_providers.dto.GeneralResponseDTO;

import static com.market.app.customers_products_providers.utils.Constants.SuccessfulMessages.*;
import static com.market.app.customers_products_providers.utils.Constants.ErrorMessages.*;

@CrossOrigin
@RestController
@RequestMapping("/providers")
public class ProviderController {
	
	@Autowired
	private ProviderServiceImpl providerService;
	
	@GetMapping("/")
	public ResponseEntity<ArrayList<Provider>> getAllProviders(){
		return ResponseEntity.ok().body(providerService.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Provider>> getProviderById(@PathVariable BigInteger id){
		return ResponseEntity.ok().body(providerService.getById(id));
	}
	
	@PostMapping("/")
	public ResponseEntity<GeneralResponseDTO> createProvider(@RequestBody @Valid ProviderRequestDTO provider){
		try {
			
			if(provider.getNitproveedor() == null) {
				GeneralResponseDTO response = new GeneralResponseDTO();
				response.setMessage("El nit del proveedor es obligatorio");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			}
			
			Provider providerExist = providerService.getById(provider.getNitproveedor()).orElse(null);
			
			if(providerExist != null) {
				GeneralResponseDTO response = new GeneralResponseDTO();
				response.setMessage(MESSAGE_RESOURCE_CONFLICT);
				return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
			}
			
			providerService.create(provider);
			GeneralResponseDTO response = new GeneralResponseDTO();
			response.setMessage(MESSAGE_RESOURCE_CREATED);
			return ResponseEntity.ok().body(response);	
			
		} catch (Exception exception) {
			GeneralResponseDTO response = new GeneralResponseDTO();
			response.setMessage(MESSAGE_INTERNAL_SERVER_ERROR + exception.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<GeneralResponseDTO> updateProviderById(@RequestBody @Valid ProviderRequestDTO provider, @PathVariable BigInteger id){
		try {
			Provider actualProvider = providerService.update(provider.toEntity(), id);
			
			if(actualProvider == null) {
				GeneralResponseDTO response = new GeneralResponseDTO();
				response.setMessage(MESSAGE_RESOURCE_NOT_FOUND);
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);				
			}
			
			GeneralResponseDTO response = new GeneralResponseDTO();
			response.setMessage(MESSAGE_RESOURCE_UPDATED);
			return ResponseEntity.ok().body(response);
			
		} catch (Exception exception) {
			GeneralResponseDTO response = new GeneralResponseDTO();
			response.setMessage(MESSAGE_INTERNAL_SERVER_ERROR + exception.getMessage());;
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<GeneralResponseDTO> deleteProviderById(@PathVariable BigInteger id){
		try {
			Provider providerExist = providerService.getById(id).orElse(null);
			
			if(providerExist == null) {
				GeneralResponseDTO response = new GeneralResponseDTO();
				response.setMessage(MESSAGE_RESOURCE_NOT_FOUND);
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
			}
			
			providerService.delete(id);			
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
