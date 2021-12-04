package com.market.app.customers_products_providers.repository;

import com.market.app.customers_products_providers.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;

public interface IProductRepository extends MongoRepository<Product, BigInteger> {
    
}
