package com.market.app.sales_reports.services.implementations;

import com.market.app.sales_reports.dto.ConsolidateCityResponseDTO;
import com.market.app.sales_reports.entity.Sale;
import com.market.app.sales_reports.entity.Subsidiary;
import com.market.app.sales_reports.repository.ISaleRepository;
import com.market.app.sales_reports.repository.ISubsidiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class ConsolidationDefaultImpl {
    @Autowired
    private ISaleRepository saleRepository;

    @Autowired
    private ISubsidiaryRepository subsidiaryRepository;

    public ConsolidateCityResponseDTO generateConsolidate() {
        List<Subsidiary> subsidiaryList = subsidiaryRepository.findAll();
        subsidiaryList.forEach(subsidiary -> {
            List<Sale> sales = saleRepository.findBySucursal(subsidiary.getId());
            AtomicReference<Double> totalPerSubsidiary = new AtomicReference<>(0D);
            sales.forEach(sale -> {
                totalPerSubsidiary.updateAndGet(v -> v + sale.getTotal_venta());
            });
            subsidiary.setTotal_ventas(totalPerSubsidiary.get());
        });

        ConsolidateCityResponseDTO response = new ConsolidateCityResponseDTO();
        response.setSubsidiaries(subsidiaryList);
        AtomicReference<Double> total = new AtomicReference<>(0D);
        response.getSubsidiaries().forEach(subsidiary -> {
            total.updateAndGet(v -> v + subsidiary.getTotal_ventas());
        });

        response.setTotal(total.get());
        return response;
    }
}
