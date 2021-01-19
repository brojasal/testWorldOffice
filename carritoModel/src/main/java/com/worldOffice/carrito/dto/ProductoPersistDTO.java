package com.worldOffice.carrito.dto;

public class ProductoPersistDTO extends ProductoDTO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long consecutivo;

	public Long getConsecutivo() {
		return consecutivo;
	}

	public void setConsecutivo(Long consecutivo) {
		this.consecutivo = consecutivo;
	}	
	
}
