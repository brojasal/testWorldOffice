package com.worldOffice.carrito.dto;

import java.io.Serializable;

@SuppressWarnings("serial")

public class ProductoDTO implements Serializable{
	
	private String nombre;
	private String marca;
	private String precio;
	private String cantidadStock;
	private String estado;
	private String procentajeDescuento;
	
	public ProductoDTO() {
		// TODO Auto-generated constructor stub
	}
	public ProductoDTO(String nombre,
	 String marca,
	 String precio,
	 String cantidadStock,
	 String estado,
	 String procentajeDescuento) {
		this.nombre = nombre;
		this.marca = marca;
		this.precio = precio;
		this.cantidadStock = cantidadStock;
		this.estado = estado;
		this.procentajeDescuento = procentajeDescuento;
		
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public String getCantidadStock() {
		return cantidadStock;
	}
	public void setCantidadStock(String cantidadStock) {
		this.cantidadStock = cantidadStock;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getProcentajeDescuento() {
		return procentajeDescuento;
	}
	public void setProcentajeDescuento(String procentajeDescuento) {
		this.procentajeDescuento = procentajeDescuento;
	}

	@Override
	public String toString() {
		return "ProductoDTO [nombre=" + nombre + ", marca=" + marca + ", precio=" + precio + ", cantidadStock="
				+ cantidadStock + ", estado=" + estado + ", procentajeDescuento=" + procentajeDescuento + "]";
	}
	
	
}
