package com.market.app.customers.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.market.app.customers.entity.Customer;
import java.math.BigInteger;

public interface ICustomerRepository extends MongoRepository<Customer, BigInteger>{

}
