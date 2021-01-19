package com.worldOffice.carrito.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name = "producto")

public class ProductoEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "consecutivo", scale = 10, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@SequenceGenerator(name= "seq_producto", sequenceName = "seq_producto")
	private Long consecutivo;
	
	@Column (name = "nombre", scale = 200, nullable = true)
	private String nombre;
	
	@Column(name = "cantidad_stock", nullable = true)
	private int cantidadStock;
	
	@Column(name = "precio", nullable = true)
	private double precio;
	
	@Column(name = "porcentaje_descuento", nullable = true)
	private double porcentajeDescuento;
	
	@Column(name = "marca", scale = 10, nullable = true)
	private String marca;
	
	@Column(name = "estado", scale = 10, nullable = true)
	private String estado;

	public Long getConsecutivo() {
		return consecutivo;
	}

	public void setConsecutivo(Long consecutivo) {
		this.consecutivo = consecutivo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidadStock() {
		return cantidadStock;
	}

	public void setCantidadStock(int cantidadStock) {
		this.cantidadStock = cantidadStock;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(double porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	}
