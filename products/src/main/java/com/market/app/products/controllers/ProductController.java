package com.market.app.products.controllers;

import com.market.app.products.dto.GeneralResponseDTO;
import com.market.app.products.entity.Product;
import com.market.app.products.services.implementations.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.math.BigInteger;
import java.util.Optional;
import org.springframework.http.HttpStatus;

import static com.market.app.products.utils.Constants.ErrorMessages.*;
import static com.market.app.products.utils.Constants.SuccessfulMessages.*;

@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductController {
        
    @Autowired
    private ProductServiceImpl productService;
    
    @GetMapping("/")
    public ResponseEntity<ArrayList<Product>> getAllProducts(){
        return ResponseEntity.ok().body(productService.getAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> getById(@PathVariable BigInteger id){
        return ResponseEntity.ok().body(productService.getById(id));
    }
    
    @PostMapping("/")
    public ResponseEntity<GeneralResponseDTO> createProduct(@RequestBody Product producto){
        try {
            
            if (producto.getCodigo_producto() == null) {
                GeneralResponseDTO response = new GeneralResponseDTO();
                response.setMessage("El código del producto es obligatorio");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }
            
            Product productExist = productService.getById(producto.getCodigo_producto()).orElse(null);
            
            if (productExist != null) {
                GeneralResponseDTO response = new GeneralResponseDTO();
                response.setMessage(MESSAGE_RESOURCE_CONFLICT);
                return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
            } 
            
            productService.create(producto);
            GeneralResponseDTO response = new GeneralResponseDTO();
            response.setMessage(MESSAGE_RESOURCE_CREATED);
            return ResponseEntity.ok().body(response);
            
        } catch (Exception exception) {
            GeneralResponseDTO response = new GeneralResponseDTO();
            response.setMessage(MESSAGE_INTERNAL_SERVER_ERROR + exception.getMessage());
            return ResponseEntity.ok().body(response);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<GeneralResponseDTO> updateProductById(@RequestBody Product producto, @PathVariable BigInteger id){
        try {
            Product updateProduct = productService.update(producto, id);
            if (updateProduct == null) {
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
    public ResponseEntity<GeneralResponseDTO> deleteProductById(@PathVariable BigInteger id){
        try {
            Product productExist = productService.getById(id).orElse(null);
            if (productExist == null) {
                GeneralResponseDTO response = new GeneralResponseDTO();
                response.setMessage(MESSAGE_RESOURCE_NOT_FOUND);
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
            productService.delete(id);
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
