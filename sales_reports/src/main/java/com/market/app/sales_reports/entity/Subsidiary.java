package com.market.app.sales_reports.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "sucursales")
public class Subsidiary {

    @Id
    private String id;

    @Field("ciudad")
    private String ciudad;

    @Transient
    private Double total_ventas;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Double getTotal_ventas() {
        return total_ventas;
    }

    public void setTotal_ventas(Double total_ventas) {
        this.total_ventas = total_ventas;
    }
}
