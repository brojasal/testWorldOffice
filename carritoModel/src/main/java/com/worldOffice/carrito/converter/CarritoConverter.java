package com.worldOffice.carrito.converter;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.worldOffice.carrito.dao.PersonaDAO;
import com.worldOffice.carrito.dao.ProductoDAO;
import com.worldOffice.carrito.dto.CarritoDTO;
import com.worldOffice.carrito.entity.CarritoEntity;
import com.worldOffice.carrito.entity.PersonaEntity;
import com.worldOffice.carrito.entity.ProductoEntity;
@Component
public class CarritoConverter {
	
	private static final Logger log = LoggerFactory.getLogger(CarritoConverter.class);
	@Autowired
	ProductoDAO productoDAO;
	@Autowired
	PersonaDAO personaDAO;
	
	public CarritoEntity convertirCarritoEntity(CarritoDTO carritoDTO) {
		CarritoEntity carritoEntity = new CarritoEntity();
		try {
			Optional<ProductoEntity> prodEntity = productoDAO.findById(carritoDTO.getProductoConsecutivo());
			Optional<PersonaEntity> personaEntity= personaDAO.findById(carritoDTO.getPersonaConsecutivo());
			carritoEntity.setPersona(personaEntity.get());
			carritoEntity.setProducto(prodEntity.get());
			carritoEntity.setCantidad(carritoDTO.getCantidad());
		}catch(Exception e) {
			e.printStackTrace();
		}
		log.info("Se ha transformado carrito entity ");
		return carritoEntity;
	}
}
