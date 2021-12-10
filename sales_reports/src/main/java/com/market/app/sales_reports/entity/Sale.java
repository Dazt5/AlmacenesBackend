package com.market.app.sales_reports.entity;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "ventas")
public class Sale {

	@Id
	private String codigo_venta;
	@Field("cedula_cliente")
	private BigInteger cedula_cliente;
	@Field("sucursal")
	private BigInteger sucursal;
	@Field("ivaventa")
	private Double ivaventa;
	@Field("valor_venta")
	private Double valor_venta;
	@Field("total_venta")
	private Double total_venta;
	private List<DetalleVentas> detalleVenta;
	
	public Sale() {
		
	}

	public Sale(String codigo_venta, BigInteger cedula_cliente, BigInteger detalle_venta, BigInteger sucursal,
			Double ivaventa, Double valor_venta, Double total_venta, List<DetalleVentas> detalleVenta) {
		super();
		this.codigo_venta = codigo_venta;
		this.cedula_cliente = cedula_cliente;
		this.sucursal = sucursal;
		this.ivaventa = ivaventa;
		this.valor_venta = valor_venta;
		this.total_venta = total_venta;
		this.detalleVenta = detalleVenta;
	}

	public String getCodigo_venta() {
		return codigo_venta;
	}

	public void setCodigo_venta(String codigo_venta) {
		this.codigo_venta = codigo_venta;
	}

	public BigInteger getCedula_cliente() {
		return cedula_cliente;
	}

	public void setCedula_cliente(BigInteger cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}
	
	public BigInteger getSucursal() {
		return sucursal;
	}

	public void setSucursal(BigInteger sucursal) {
		this.sucursal = sucursal;
	}

	public Double getIvaventa() {
		return ivaventa;
	}

	public void setIvaventa(Double ivaventa) {
		this.ivaventa = ivaventa;
	}

	public Double getTotal_venta() {
		return total_venta;
	}

	public void setTotal_venta(Double total_venta) {
		this.total_venta = total_venta;
	}

	public Double getValor_venta() {
		return valor_venta;
	}

	public void setValor_venta(Double valor_venta) {
		this.valor_venta = valor_venta;
	}		

	public List<DetalleVentas> getDetalleVenta() {
		return detalleVenta;
	}

	public void setDetalleVenta(List<DetalleVentas> detalleVenta) {
		this.detalleVenta = detalleVenta;
	}

	@Override
	public String toString() {
		return "Sale [codigo_venta=" + codigo_venta + 
				", cedula_cliente=" + cedula_cliente +
				", sucursal=" + sucursal + 
				", ivaventa=" + ivaventa + 
				", valor_venta=" + valor_venta + 
				", total_venta=" + total_venta + 
				", detalleVenta=" + detalleVenta + "]";
	}

}
