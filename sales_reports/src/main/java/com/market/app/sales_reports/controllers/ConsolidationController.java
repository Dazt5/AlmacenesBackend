package com.market.app.sales_reports.controllers;

import com.market.app.sales_reports.dto.ConsolidateCityResponseDTO;
import com.market.app.sales_reports.services.implementations.ConsolidationDefaultImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/consolidate")
public class ConsolidationController {

    @Autowired
    private ConsolidationDefaultImpl consolidationService;

    @GetMapping("/")
    public ResponseEntity<ConsolidateCityResponseDTO> getConsolidate(){

        return ResponseEntity.ok().body(consolidationService.generateConsolidate());
    }

}
