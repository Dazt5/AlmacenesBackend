package com.market.app.customers_products_providers.controllers;

import com.market.app.customers_products_providers.services.implementations.FileServiceImpl;
import com.market.app.customers_products_providers.dto.GeneralResponseDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
@RequestMapping("/products/file")
public class FileController {
    
    @Autowired
    FileServiceImpl fileService;
    
    @PostMapping("/upload")
    public ResponseEntity<GeneralResponseDTO> uploadFiles(@RequestParam("files") MultipartFile file) throws Exception{
        return fileService.save(file);        
    }
    
} 
