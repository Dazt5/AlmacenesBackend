package com.market.app.sales_reports.services.interfaces;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Optional;

import com.market.app.sales_reports.dto.SaleRequestDTO;
import com.market.app.sales_reports.entity.Sale;

public interface ISaleService {

	public ArrayList<Sale> getAll();
	public Optional<Sale> getById(String id);
	public Sale create(SaleRequestDTO sale, String subsidiary);
	
}
