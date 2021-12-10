package com.market.app.sales_reports.controllers;

import java.util.ArrayList;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.market.app.sales_reports.utils.JwtManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.market.app.sales_reports.clients.ICustomerClient;
import com.market.app.sales_reports.dto.GeneralResponseDTO;
import com.market.app.sales_reports.dto.SaleRequestDTO;
import com.market.app.sales_reports.entity.Sale;
import com.market.app.sales_reports.model.Customer;
import com.market.app.sales_reports.services.implementations.SaleServiceImpl;

import static com.market.app.sales_reports.utils.Constants.SuccessfulMessages.*;
import static com.market.app.sales_reports.utils.Constants.ErrorMessages.*;
import static com.market.app.sales_reports.utils.Constants.JWTConfig.*;

@CrossOrigin
@RestController
@RequestMapping("/sales")
public class SaleController {
	
	@Autowired
	private SaleServiceImpl saleService;

	@Autowired
	private JwtManager jwtManager;
	
	@Autowired
	ICustomerClient customerClient;
	
	@GetMapping("/")
	public ResponseEntity<ArrayList<Sale>> getAllSales() {
		return ResponseEntity.ok().body(saleService.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Sale>> getSaleById(@PathVariable String id) {
		return ResponseEntity.ok().body(saleService.getById(id));
	}
	
	@PostMapping("/")
	public ResponseEntity<GeneralResponseDTO> createSale(@RequestBody @Valid SaleRequestDTO sale, HttpServletRequest request) {

		try {
			
			System.out.println(request.getHeader(AUTHORIZATION_HEADER_NAME));
			System.out.println("\n");
			System.out.println(jwtManager.getSubsidiary(request));
			
			System.out.println(request.getHeader(AUTHORIZATION_HEADER_NAME));
			System.out.println("\n");
			System.out.println(jwtManager.getSubsidiary(request));
			
			String token = request.getHeader(AUTHORIZATION_HEADER_NAME);
			String subsidiary = jwtManager.getSubsidiary(request);
			System.out.println(sale.toString());
			
			Customer customer = customerClient.getById(token, sale.getCedula_cliente()).getBody().orElse(null);
			if(customer == null) {
				GeneralResponseDTO response = new GeneralResponseDTO();
				response.setMessage("No existe ningún cliente relacionado a la cedula que proporsionó, por favor verifique el dato.");		
				return ResponseEntity.ok().body(response);
			}
			
			saleService.create(sale,subsidiary);
			GeneralResponseDTO response = new GeneralResponseDTO();
			response.setMessage(MESSAGE_RESOURCE_CREATED);		
			return ResponseEntity.ok().body(response);
			
		} catch (Exception exception) {
			GeneralResponseDTO response = new GeneralResponseDTO();
			response.setMessage(MESSAGE_INTERNAL_SERVER_ERROR + exception.getMessage());	
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
		
	}
	
}
