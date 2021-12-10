package com.market.app.sales_reports.entity;

import java.math.BigInteger;

public class DetalleVentas {

	private BigInteger codigo_producto;
	private String nombre_producto;
	private Integer cantidad_producto;	
	private Double valor_total;
	private Double valor_venta;
	private Double valoriva;
	
	public DetalleVentas() {
		
	}

	public DetalleVentas(Integer cantidad_producto, String nombre_producto, BigInteger codigo_producto, Double valor_total, Double valor_venta,
			Double valoriva) {
		super();
		this.cantidad_producto = cantidad_producto;
		this.nombre_producto = nombre_producto;
		this.codigo_producto = codigo_producto;
		this.valor_total = valor_total;
		this.valor_venta = valor_venta;
		this.valoriva = valoriva;
	}

	public Integer getCantidad_producto() {
		return cantidad_producto;
	}

	public void setCantidad_producto(Integer cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public BigInteger getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(BigInteger codigo_producto) {
		this.codigo_producto = codigo_producto;
	}

	public Double getValor_total() {
		return valor_total;
	}

	public void setValor_total(Double valor_total) {
		this.valor_total = valor_total;
	}

	public Double getValor_venta() {
		return valor_venta;
	}

	public void setValor_venta(Double valor_venta) {
		this.valor_venta = valor_venta;
	}

	public Double getValoriva() {
		return valoriva;
	}

	public void setValoriva(Double valoriva) {
		this.valoriva = valoriva;
	}

	@Override
	public String toString() {
		return "DetalleVentas [cantidad_producto=" + cantidad_producto + 
				", codigo_producto=" + codigo_producto + 
				", valor_total=" + valor_total + 
				", valor_venta=" + valor_venta + 
				", valoriva=" + valoriva + "]";
	}
	
}
