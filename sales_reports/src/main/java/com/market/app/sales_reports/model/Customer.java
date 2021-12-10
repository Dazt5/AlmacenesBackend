package com.market.app.sales_reports.model;

import java.math.BigInteger;

public class Customer {
	
	private BigInteger cedula_cliente;
	private String nombre_cliente;
	private String direccion_cliente;
	private String telefono_cliente;
	private String email_cliente;

	public Customer() {
		
	}
	
	public Customer(BigInteger cedula_cliente, String nombre_cliente, String direccion_cliente, String telefono_cliente, String email_cliente) {
		super();
		this.cedula_cliente = cedula_cliente;
		this.nombre_cliente = nombre_cliente;
		this.direccion_cliente = direccion_cliente;
		this.telefono_cliente = telefono_cliente;
		this.email_cliente = email_cliente;
	}
	
	public BigInteger getCedula_cliente() {
		return cedula_cliente;
	}
	
	public void setCedula_cliente(BigInteger cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}
	
	public String getNombre_cliente() {
		return nombre_cliente;
	}
	
	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}
	
	public String getDireccion_cliente() {
		return direccion_cliente;
	}
	
	public void setDireccion_cliente(String direccion_cliente) {
		this.direccion_cliente = direccion_cliente;
	}
	
	public String getTelefono_cliente() {
		return telefono_cliente;
	}
	
	public void setTelefono_cliente(String telefono_cliente) {
		this.telefono_cliente = telefono_cliente;
	}
	
	public String getEmail_cliente() {
		return email_cliente;
	}
	
	public void setEmail_cliente(String email_cliente) {
		this.email_cliente = email_cliente;
	}

	@Override
	public String toString() {
		return "Customer [cedula_cliente=" + cedula_cliente + 
				", nombre_cliente=" + nombre_cliente + 
				", direccion_cliente=" + direccion_cliente + 
				", telefono_cliente=" + telefono_cliente + 
				", email_cliente=" + email_cliente + "]";
	}

	
}
