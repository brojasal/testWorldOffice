package com.worldOffice.carrito.dto;

public class CarritoDTO {
	private long personaConsecutivo;
	private long productoConsecutivo;
	private int cantidad;
	
	
	
	public CarritoDTO(long personaConsecutivo, long productoConsecutivo, int cantidad) {
		super();
		this.personaConsecutivo = personaConsecutivo;
		this.productoConsecutivo = productoConsecutivo;
		this.cantidad = cantidad;
	}
	
	public long getPersonaConsecutivo() {
		return personaConsecutivo;
	}
	public void setPersonaConsecutivo(long personaConsecutivo) {
		this.personaConsecutivo = personaConsecutivo;
	}
	public long getProductoConsecutivo() {
		return productoConsecutivo;
	}
	public void setProductoConsecutivo(long productoConsecutivo) {
		this.productoConsecutivo = productoConsecutivo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
