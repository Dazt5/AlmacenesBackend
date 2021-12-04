package com.market.app.customers_products_providers.repository;

import java.math.BigInteger;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.market.app.customers_products_providers.entity.Provider;

public interface IProviderRepository extends MongoRepository<Provider, BigInteger> {

}
