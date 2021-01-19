package com.worldOffice.carrito.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table (name = "carrito")
public class CarritoEntity {
	
	@Column(name = "consecutivo", scale = 10, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@SequenceGenerator(name= "seq_carrito", sequenceName = "seq_carrito")
	private long consecutivo;
	
	@Column (name = "persona_consecutivo", nullable = true, insertable = false, updatable = false)
	private long personaConsecutivo;
	
	@Column(name = "producto_consecutivo", nullable = true, insertable = false, updatable = false)
	private long productoConsecutivo;
	
	@Column(name = "cantidad", nullable = true)
	private int cantidad;
		
	@JoinColumn(name = "persona_consecutivo", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private PersonaEntity persona;

	@JoinColumn(name = "producto_consecutivo", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private ProductoEntity producto;

	public long getConsecutivo() {
		return consecutivo;
	}

	public void setConsecutivo(long consecutivo) {
		this.consecutivo = consecutivo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public PersonaEntity getPersona() {
		return persona;
	}

	public void setPersona(PersonaEntity persona) {
		this.persona = persona;
	}

	public ProductoEntity getProducto() {
		return producto;
	}

	public void setProducto(ProductoEntity producto) {
		this.producto = producto;
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
	
	
}
