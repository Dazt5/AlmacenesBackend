package com.market.app.customers_products_providers.services.interfaces;

import com.market.app.customers_products_providers.dto.GeneralResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface IFileService {
	
	public ResponseEntity<GeneralResponseDTO> validation(MultipartFile file) throws Exception;
    public ResponseEntity<GeneralResponseDTO> save(MultipartFile file) throws Exception;
    
    public ResponseEntity<GeneralResponseDTO> datos_db(MultipartFile file) throws Exception;  
    
}
