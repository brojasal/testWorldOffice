package com.worldOffice.carrito.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name = "persona")
public class PersonaEntity {
	@Column(name = "consecutivo", scale = 10, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@SequenceGenerator(name= "seq_persona", sequenceName = "seq_persona")
	private Long consecutivo;
	
	@Column (name = "nombre", scale = 200, nullable = true)
	private String nombre;
	
	@Column(name = "documento", nullable = true)
	private int documento;
	
	@Column(name = "tipoPersona", nullable = true)
	private String tipoPersona;

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

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public String getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}
	
	
}
