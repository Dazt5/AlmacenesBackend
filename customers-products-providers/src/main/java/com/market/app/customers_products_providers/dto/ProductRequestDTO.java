package com.market.app.customers_products_providers.dto;

import java.math.BigInteger;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.market.app.customers_products_providers.entity.Product;


public class ProductRequestDTO {
	
	@JsonProperty("codigo_producto")
    private BigInteger codigo_producto;
	
	@NotBlank(message = "El nombre es obligatorio")
	@JsonProperty("nombre_producto")
    private String nombre_producto;
	
	@PositiveOrZero(message = "El nit del proveedor tiene que ser mayor o igual a 0")
	@JsonProperty("nitproveedor")
    private BigInteger nitproveedor;
	
	@PositiveOrZero(message = "El precio de compra tiene que ser mayor o igual a 0")
	@JsonProperty("precio_compra")
    private Double precio_compra;
	
	@PositiveOrZero(message = "El iva del producto tiene que ser mayor o igual a 0")
	@JsonProperty("ivacompra")
    private Double ivacompra;
	
	@PositiveOrZero(message = "El precio de venta tiene que ser mayor o igual a 0")
	@JsonProperty("precio_venta")
    private Double precio_venta;

	public ProductRequestDTO() {
		
	}
		
	public ProductRequestDTO(BigInteger codigo_producto,
			@NotBlank(message = "El nombre es obligatorio") String nombre_producto,
			@NotBlank(message = "El nit es obligatorio") BigInteger nitproveedor,
			@NotBlank(message = "El precio de compra es obligatorio") Double precio_compra,
			@NotBlank(message = "El iva es obligatorio") Double ivacompra,
			@NotBlank(message = "El precio de venta es obligatorio") Double precio_venta) {
		super();
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
	
	@JsonIgnore
	public Product toEntity() {
		return new Product(
				this.getCodigo_producto(),
				this.getNombre_producto(),
				this.getNitproveedor(),
				this.getPrecio_compra(),
				this.getIvacompra(),
				this.getPrecio_venta()
		);
	}

	@Override
	public String toString() {
		return "ProductRequestDTO [codigo_producto=" + codigo_producto + 
				", nombre_producto=" + nombre_producto + 
				", nitproveedor=" + nitproveedor + 
				", precio_compra=" + precio_compra + 
				", ivacompra=" + ivacompra + 
				", precio_venta=" + precio_venta + "]";
	}
		
}
