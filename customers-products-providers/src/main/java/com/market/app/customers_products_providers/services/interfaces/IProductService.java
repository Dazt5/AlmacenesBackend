package com.market.app.customers_products_providers.services.interfaces;

import com.market.app.customers_products_providers.dto.ProductRequestDTO;
import com.market.app.customers_products_providers.entity.Product;
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
