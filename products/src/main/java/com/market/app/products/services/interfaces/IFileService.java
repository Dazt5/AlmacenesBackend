package com.market.app.products.services.interfaces;

import com.market.app.products.dto.GeneralResponseDTO;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface IFileService {
	
	public void validation(MultipartFile file) throws Exception;
    public ResponseEntity<GeneralResponseDTO> save(MultipartFile file) throws Exception;
    
    public ResponseEntity<GeneralResponseDTO> datos_db(MultipartFile file) throws Exception;  
    
}
