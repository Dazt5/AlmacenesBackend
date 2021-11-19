package com.market.app.products.services.implementations;


import com.market.app.products.dto.GeneralResponseDTO;
import com.market.app.products.entity.Product;
import com.market.app.products.services.interfaces.IFileService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.market.app.products.utils.Constants.SuccessfulMessages.*;
import static com.market.app.products.utils.Constants.ErrorMessages.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Service
public class FileServiceImpl implements IFileService {
    
	private final static Logger LOGGER = LoggerFactory.getLogger(FileServiceImpl.class);
    private final Path rootFolder = Paths.get("uploads");
    
    @Autowired
    ProductServiceImpl productService;
    
    @Override
    public void validation(MultipartFile file) throws Exception{
    	File fileUploaded = new File("uploads"+ File.separator + file.getOriginalFilename());
    	if(fileUploaded.exists()){
    		LOGGER.info("-- the file '" + file.getOriginalFilename() + "' already exists on the server, so it will e replaced by the new one. --");
    		fileUploaded.delete();
    	}
    }
    
    @Override
    public ResponseEntity<GeneralResponseDTO> save(MultipartFile file) throws Exception {
    	validation(file);
        Files.copy(file.getInputStream(), this.rootFolder.resolve(file.getOriginalFilename())); // enviando el archivo a la carpeta.
        return datos_db(file);
    }
        
    @Override
    public ResponseEntity<GeneralResponseDTO> datos_db(MultipartFile file) throws Exception {
                
        List<Product> productos = new ArrayList<>();
                
        try(Stream<String> streamFile = Files.lines(rootFolder.resolve(file.getOriginalFilename()))){ // leer directamente el archivo y almacenarlo en esta estructura
        	
            streamFile.map(linea -> linea.split(",")).map(array -> {
                                                
                BigInteger codigo_producto = new BigInteger(array[0]);
                String nombre_producto = array[1];
                BigInteger nitproveedor = new BigInteger(array[2]);
                Double precio_compra = Double.parseDouble(array[3]);
                Double ivacompra = Double.parseDouble(array[4]);
                Double precio_venta = Double.parseDouble(array[5]);
                
                Product producto = new Product(codigo_producto, nombre_producto, nitproveedor, precio_compra, ivacompra, precio_venta);
                                
                productService.create(producto);                               
                return producto;
                
            }).collect(Collectors.toList());
            
            GeneralResponseDTO response = new GeneralResponseDTO();
            response.setMessage(MESSAGE_RESOURCE_CREATED);
            return ResponseEntity.ok().body(response);
            
        } catch(IOException ioException){                        
            GeneralResponseDTO response = new GeneralResponseDTO();
            response.setMessage(MESSAGE_INTERNAL_SERVER_ERROR + ioException);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }        
    }
    
}
