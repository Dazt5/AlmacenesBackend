package com.market.app.authentication.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

@Document(collection = "sucursales")
public class Subsidiary {

    @Id
    private String id;

    @Field("ciudad")
    private String ciudad;

    @Field("total_ventas")
    private BigDecimal total_ventas;

    public Subsidiary(String id, String ciudad, BigDecimal total_ventas) {
        this.id = id;
        this.ciudad = ciudad;
        this.total_ventas = total_ventas;
    }

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

    public BigDecimal getTotal_ventas() {
        return total_ventas;
    }

    public void setTotal_ventas(BigDecimal total_ventas) {
        this.total_ventas = total_ventas;
    }
}
