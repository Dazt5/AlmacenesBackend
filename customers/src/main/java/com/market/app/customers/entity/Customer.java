package com.market.app.customers.entity;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="clientes")
public class Customer {

	@Id
	private BigInteger cedula_cliente;
	@Field("nombre_cliente")
	private String nombre_cliente;
	@Field("direccion_cliente")
	private String direccion_cliente;
	@Field("telefono_cliente")
	private String telefono_cliente;
	@Field("email_cliente")
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
	
	
	
}
