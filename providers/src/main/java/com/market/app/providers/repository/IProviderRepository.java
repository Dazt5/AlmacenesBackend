package com.market.app.providers.repository;

import java.math.BigInteger;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.market.app.providers.entity.Provider;

public interface IProviderRepository extends MongoRepository<Provider, BigInteger> {

}
