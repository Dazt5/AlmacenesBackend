package com.market.app.sales_reports.controllers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Optional;

import javax.validation.Valid;

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

import com.market.app.sales_reports.dto.GeneralResponseDTO;
import com.market.app.sales_reports.dto.SaleRequestDTO;
import com.market.app.sales_reports.entity.DetalleVentas;
import com.market.app.sales_reports.entity.Sale;
import com.market.app.sales_reports.services.implementations.SaleServiceImpl;

import static com.market.app.sales_reports.utils.Constants.SuccessfulMessages.*;
import static com.market.app.sales_reports.utils.Constants.ErrorMessages.*;

@CrossOrigin
@RestController
@RequestMapping("/sales")
public class SaleController {
	
	@Autowired
	private SaleServiceImpl saleService;
	
	@GetMapping("/")
	public ResponseEntity<ArrayList<Sale>> getAllSales() {
		return ResponseEntity.ok().body(saleService.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Sale>> getSaleById(@PathVariable String id) {
		return ResponseEntity.ok().body(saleService.getById(id));
	}
	
	@PostMapping("/")
	public ResponseEntity<GeneralResponseDTO> createSale(@RequestBody @Valid SaleRequestDTO sale) {

		try {
			System.out.println(sale.toString());
			saleService.create(sale);
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
