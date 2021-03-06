package com.market.app.sales_reports.services.implementations;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.app.sales_reports.dto.SaleRequestDTO;
import com.market.app.sales_reports.entity.Sale;
import com.market.app.sales_reports.repository.ISaleRepository;
import com.market.app.sales_reports.services.interfaces.ISaleService;

@Service
public class SaleServiceImpl implements ISaleService {

	@Autowired
	ISaleRepository saleRepository;
	
	@Override
	public ArrayList<Sale> getAll() {
		return (ArrayList<Sale>) saleRepository.findAll();
	}
	
	@Override
	public Optional<Sale> getById(String id) {
		return saleRepository.findById(id);
	}

	@Override
	public Sale create(SaleRequestDTO sale, String subsidiary) {

		Sale newSale = sale.toEntity();
		newSale.setSucursal(subsidiary);

		return saleRepository.save(sale.toEntity());
	}

}
