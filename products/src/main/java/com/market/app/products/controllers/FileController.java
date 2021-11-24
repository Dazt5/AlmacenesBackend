package com.market.app.products.controllers;

import com.market.app.products.dto.GeneralResponseDTO;
import com.market.app.products.services.implementations.FileServiceImpl;
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
