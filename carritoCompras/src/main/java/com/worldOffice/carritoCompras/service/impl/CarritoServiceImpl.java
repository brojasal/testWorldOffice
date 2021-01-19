package com.worldOffice.carritoCompras.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worldOffice.carrito.converter.CarritoConverter;
import com.worldOffice.carrito.converter.CarritoPersonaConverter;
import com.worldOffice.carrito.converter.ProductoConverter;
import com.worldOffice.carrito.dao.CarritoDAO;
import com.worldOffice.carrito.dao.PersonaDAO;
import com.worldOffice.carrito.dao.ProductoDAO;
import com.worldOffice.carrito.dto.CarritoDTO;
import com.worldOffice.carrito.dto.CarritoPersonaDTO;
import com.worldOffice.carrito.dto.ProductoDTO;
import com.worldOffice.carrito.dto.ProductoPersistDTO;
import com.worldOffice.carrito.entity.CarritoEntity;
import com.worldOffice.carrito.entity.ProductoEntity;
import com.worldOffice.carrito.repository.CarritoRepository;
import com.worldOffice.carrito.repository.ProductoRepository;
import com.worldOffice.carritoCompras.service.CarritoService;

@Service
public class CarritoServiceImpl implements CarritoService{

	
	@Autowired
	ProductoDAO productoDAO;
	
	@Autowired
	CarritoDAO carritoDAO;
	
	@Autowired 
	ProductoRepository productoRepository;

	@Autowired
	ProductoConverter productoConverter;
	
	@Autowired
	CarritoConverter carritoConverter;
	
	@Autowired
	CarritoRepository carritoRepository;
	
	@Autowired
	CarritoPersonaConverter carritoPersonaConverter;
	
	@Autowired
	PersonaDAO personaDAO;
	
	@Override
	public List<ProductoDTO> obtenerproductos() {
		
		return productoConverter.convertirProducto((List<ProductoEntity>) productoDAO.findAll());
	}

	@Override
	public String persistirProducto(ProductoPersistDTO productoDTO) {
		String respuesta;
		try {
			productoDAO.save(productoConverter.convertirProductorEntity(productoDTO));
			respuesta = "Transaccion Exitosa";
		}catch(Exception e) {
			respuesta = "Error fatal: "+ e.getCause();
		}
		return respuesta;
	}

	@Override
	public List<ProductoDTO> obtenerProductosEspecificos(HashMap<String, Object> condiciones) {
		return productoConverter.convertirProducto(productoRepository.getData(condiciones));
				
	}

	@Override
	public String guardarProductoCarrito(CarritoDTO carritoDTO) {
		CarritoEntity carritoEntity = carritoConverter.convertirCarritoEntity(carritoDTO);
		if(carritoDTO.getCantidad()>carritoEntity.getProducto().getCantidadStock()) {
			return "No se puede agrear al carrito porque no hay cantidad suficiente en el stock, disponibles: "+ carritoEntity.getProducto().getCantidadStock();
		}else
			carritoDAO.save(carritoEntity);
		return "Transaccion exitosa al persistir carrito";
	}

	@Override
	public CarritoPersonaDTO consultarCarritoPersona(long idPersona) {
		HashMap<String, Object> condiciones = new HashMap<String, Object>();
		condiciones.put("personaConsecutivo", idPersona);
		List<CarritoEntity> productosPersona = carritoRepository.getData(condiciones);
		return carritoPersonaConverter.convertirCarritoPersona(productosPersona);
	}

}
