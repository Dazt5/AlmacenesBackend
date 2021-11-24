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
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.market.app.products.utils.Constants.SuccessfulMessages.*;
import static com.market.app.products.utils.Constants.ErrorMessages.*;
import static com.market.app.products.utils.Constants.Validations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Service
public class FileServiceImpl implements IFileService {

    private final static Logger LOGGER = LoggerFactory.getLogger(FileServiceImpl.class);

    @Autowired
    private ProductServiceImpl productService;

    @Override
    public ResponseEntity<GeneralResponseDTO> validation(MultipartFile file) {
        if (file.isEmpty() || file.getContentType() == null) {
            GeneralResponseDTO response = new GeneralResponseDTO();
            response.setMessage(MESSAGE_FILE_EMPTY);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        if (!file.getContentType().equals(CONTENT_TYPE_CSV)) {
            GeneralResponseDTO response = new GeneralResponseDTO();
            response.setMessage(MESSAGE_FILE_NOT_ACCEPTED);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        return null;
    }

    @Override
    public ResponseEntity<GeneralResponseDTO> save(MultipartFile file) throws Exception {
        if (validation(file) != null) {
            return validation(file);
        }

        return datos_db(file);
    }

    @Override
    public ResponseEntity<GeneralResponseDTO> datos_db(MultipartFile file) throws Exception {
        InputStream data = file.getInputStream();
        String line = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(data));

        try {
            while ((line = reader.readLine()) != null) {
                String[] product = line.split(",");
                System.out.println(product);
                BigInteger codigo_producto = new BigInteger(product[0]);
                String nombre_producto = product[1];
                BigInteger nitproveedor = new BigInteger(product[2]);
                Double precio_compra = Double.parseDouble(product[3]);
                Double ivacompra = Double.parseDouble(product[4]);
                Double precio_venta = Double.parseDouble(product[5]);

                Product producto = new Product(codigo_producto, nombre_producto, nitproveedor, precio_compra, ivacompra, precio_venta);
                productService.create(producto);
            }
            GeneralResponseDTO response = new GeneralResponseDTO();
            response.setMessage(MESSAGE_RESOURCE_CREATED);
            return ResponseEntity.ok().body(response);
        } catch (IOException ioException) {
            LOGGER.error("IOException ", ioException);
            GeneralResponseDTO response = new GeneralResponseDTO();
            response.setMessage(MESSAGE_INTERNAL_SERVER_ERROR + ioException);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        } catch (Exception exception) {
            LOGGER.error("Exception tipe ", exception);
            GeneralResponseDTO response = new GeneralResponseDTO();
            response.setMessage(MESSAGE_INTERNAL_SERVER_ERROR + exception);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
