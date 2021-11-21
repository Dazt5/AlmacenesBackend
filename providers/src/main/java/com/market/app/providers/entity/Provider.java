package com.market.app.providers.entity;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="proveedores")
public class Provider {
	
	@Id
	private BigInteger nitproveedor;
	@Field("nombre_proveedor")
	private String nombre_proveedor;
	@Field("telefono_proveedor")
	private String telefono_proveedor;
	@Field("direccion_proveedor")
	private String direccion_proveedor;
	@Field("ciudad_proveedor")
	private String ciudad_proveedor;
	
	public Provider(BigInteger nitproveedor, String nombre_proveedor, String telefono_proveedor,
			String direccion_proveedor, String ciudad_proveedor) {
		super();
		this.nitproveedor = nitproveedor;
		this.nombre_proveedor = nombre_proveedor;
		this.telefono_proveedor = telefono_proveedor;
		this.direccion_proveedor = direccion_proveedor;
		this.ciudad_proveedor = ciudad_proveedor;
	}

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

	@Override
	public String toString() {
		return "Provider [nitproveedor=" + nitproveedor + 
				", nombre_proveedor=" + nombre_proveedor + 
				", telefono_proveedor=" + telefono_proveedor + 
				", direccion_proveedor=" + direccion_proveedor + 
				", ciudad_proveedor=" + ciudad_proveedor + "]";
	}
	
	
	
}
