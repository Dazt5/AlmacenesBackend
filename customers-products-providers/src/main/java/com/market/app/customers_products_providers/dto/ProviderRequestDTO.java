package com.market.app.customers_products_providers.dto;

import java.math.BigInteger;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.market.app.customers_products_providers.entity.Provider;

public class ProviderRequestDTO {
	
	@JsonProperty("nitproveedor")
	private BigInteger nitproveedor;
	
	@NotBlank(message = "El nombre es obligatorio")
	@JsonProperty("nombre_proveedor")
	private String nombre_proveedor;
	
	@NotBlank(message = "El telefono es obligatorio")
	@JsonProperty("telefono_proveedor")
	private String telefono_proveedor;
	
	@NotBlank(message = "La direccion es obligatoria")
	@JsonProperty("direccion_proveedor")
	private String direccion_proveedor;
	
	@NotBlank(message = "La ciudad es obligatoria")
	@JsonProperty("ciudad_proveedor")
	private String ciudad_proveedor;

	public BigInteger getNitproveedor() {
		return nitproveedor;
	}

	public void setNitproveedor(BigInteger nitproveedor) {
		this.nitproveedor = nitproveedor;
	}

	public String getNombre_proveedor() {
		return nombre_proveedor;
	}

	public void setNombre_proveedor(String nombre_proveedor) {
		this.nombre_proveedor = nombre_proveedor;
	}

	public String getTelefono_proveedor() {
		return telefono_proveedor;
	}

	public void setTelefono_proveedor(String telefono_proveedor) {
		this.telefono_proveedor = telefono_proveedor;
	}

	public String getDireccion_proveedor() {
		return direccion_proveedor;
	}

	public void setDireccion_proveedor(String direccion_proveedor) {
		this.direccion_proveedor = direccion_proveedor;
	}

	public String getCiudad_proveedor() {
		return ciudad_proveedor;
	}

	public void setCiudad_proveedor(String ciudad_proveedor) {
		this.ciudad_proveedor = ciudad_proveedor;
	}
	
	@JsonIgnore
	public Provider toEntity() {
		return new Provider(
				this.getNitproveedor(),
				this.getNombre_proveedor(),
				this.getTelefono_proveedor(),
				this.getDireccion_proveedor(),
				this.getCiudad_proveedor()
		);
	}

	@Override
	public String toString() {
		return "ProviderRequestDTO [nitproveedor=" + nitproveedor + 
				", nombre_proveedor=" + nombre_proveedor + 
				", telefono_proveedor=" + telefono_proveedor + 
				", direccion_proveedor=" + direccion_proveedor + 
				", ciudad_proveedor=" + ciudad_proveedor + "]";
	}
	
}
