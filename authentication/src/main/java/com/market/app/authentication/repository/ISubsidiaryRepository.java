package com.market.app.authentication.repository;

import com.market.app.authentication.entity.Subsidiary;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ISubsidiaryRepository extends MongoRepository<Subsidiary, String> {
}
