package com.market.app.sales_reports.dto;

import com.market.app.sales_reports.entity.Subsidiary;
import java.util.List;

public class ConsolidateCityResponseDTO {

    private List<Subsidiary> subsidiaries;

    private Double total;

    public List<Subsidiary> getSubsidiaries() {
        return subsidiaries;
    }

    public void setSubsidiaries(List<Subsidiary> subsidiaries) {
        this.subsidiaries = subsidiaries;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
