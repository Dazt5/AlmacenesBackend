package com.market.app.sales_reports.repository;

import java.math.BigInteger;
//import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.market.app.sales_reports.entity.Sale;

public interface ISaleRepository extends MongoRepository<Sale, BigInteger>{

	//public ArrayList<Sale> findByCedulaCliente(BigInteger cedulaCliente);
	
} 