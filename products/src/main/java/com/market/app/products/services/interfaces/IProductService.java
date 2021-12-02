package com.market.app.products.services.interfaces;

import com.market.app.products.dto.ProductRequestDTO;
import com.market.app.products.entity.Product;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Optional;

public interface IProductService {
    
    ArrayList<Product> getAll();
    Optional<Product> getById(BigInteger id);
    Product create(ProductRequestDTO producto);
    Product update(Product producto, BigInteger id);
    void delete(BigInteger id);
    
}
