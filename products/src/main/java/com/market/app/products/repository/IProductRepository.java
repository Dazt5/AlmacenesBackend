package com.market.app.products.repository;

import com.market.app.products.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;

public interface IProductRepository extends MongoRepository<Product, BigInteger> {
    
}
