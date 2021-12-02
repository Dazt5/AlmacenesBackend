package com.market.app.customers.dto;

import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.market.app.customers.entity.Customer;

import javax.validation.constraints.NotBlank;

public class CustomerRequestDTO {

	@JsonProperty("cedula_cliente")
	private BigInteger cedula_cliente;
	
	@NotBlank(message = "El nombre es obligatorio")
	@JsonProperty("nombre_cliente")
	private String nombre_cliente;
	
	@NotBlank(message = "La dirección es obligatoria")
	@JsonProperty("direccion_cliente")
	private String direccion_cliente;
	
	@NotBlank(message = "El telefono es obligatorio")
	@JsonProperty("telefono_cliente")
	private String telefono_cliente;
	
	@NotBlank(message = "El email es obligatorio")
	@JsonProperty("email_cliente")
	private String email_cliente;

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

	@JsonIgnore
	public Customer toEntity() {
		return new Customer(
				this.getCedula_cliente(),
				this.getNombre_cliente(),
				this.getDireccion_cliente(),
				this.getTelefono_cliente(),
				this.getEmail_cliente()
		);
	}
	
	@Override
	public String toString() {
		return "CustomerRequestDTO [cedula_cliente=" + cedula_cliente + 
				", nombre_cliente=" + nombre_cliente + 
				", direccion_cliente=" + direccion_cliente + 
				", telefono_cliente=" + telefono_cliente + 
				", email_cliente=" + email_cliente + "]";
	}	
	
}
