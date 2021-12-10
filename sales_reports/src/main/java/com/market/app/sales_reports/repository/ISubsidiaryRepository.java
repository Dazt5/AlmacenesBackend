package com.market.app.sales_reports.repository;

import com.market.app.sales_reports.entity.Subsidiary;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ISubsidiaryRepository extends MongoRepository<Subsidiary, String> {
}
