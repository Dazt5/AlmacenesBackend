package com.market.app.products.entity;

import java.math.BigInteger;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "productos")
public class Product {
    
    @Id
    private BigInteger codigo_producto;
    @Field("nombre_producto")
    private String nombre_producto;
    @Field("nitproveedor")
    private BigInteger nitproveedor;
    @Field("precio_compra")
    private Double precio_compra;
    @Field("ivacompra")
    private Double ivacompra;
    @Field("precio_venta")
    private Double precio_venta;
    
    public Product() {        
    }

    public Product(BigInteger codigo_producto, String nombre_producto, BigInteger nitproveedor, Double precio_compra, Double ivacompra, Double precio_venta) {
        this.codigo_producto = codigo_producto;
        this.nombre_producto = nombre_producto;
        this.nitproveedor = nitproveedor;
        this.precio_compra = precio_compra;
        this.ivacompra = ivacompra;
        this.precio_venta = precio_venta;
    }    
    
    public BigInteger getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(BigInteger codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public BigInteger getNitproveedor() {
        return nitproveedor;
    }

    public void setNitproveedor(BigInteger nitproveedor) {
        this.nitproveedor = nitproveedor;
    }

    public Double getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(Double precio_compra) {
        this.precio_compra = precio_compra;
    }

    public Double getIvacompra() {
        return ivacompra;
    }

    public void setIvacompra(Double ivacompra) {
        this.ivacompra = ivacompra;
    }

    public Double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(Double precio_venta) {
        this.precio_venta = precio_venta;
    }

    @Override
    public String toString() {
        return "Product{" + 
                "codigo_producto=" + codigo_producto + 
                ", nombre_producto=" + nombre_producto + 
                ", nitproveedor=" + nitproveedor + 
                ", precio_compra=" + precio_compra + 
                ", ivacompra=" + ivacompra + 
                ", precio_venta=" + precio_venta + 
                '}';
    }

    
    
} 
