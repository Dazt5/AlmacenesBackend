package com.market.app.customers_products_providers.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.market.app.customers_products_providers.entity.Customer;
import java.math.BigInteger;

public interface ICustomerRepository extends MongoRepository<Customer, BigInteger>{

}
