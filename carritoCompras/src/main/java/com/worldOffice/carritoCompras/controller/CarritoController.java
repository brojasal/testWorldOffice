package com.worldOffice.carritoCompras.controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.worldOffice.carrito.dto.CarritoDTO;
import com.worldOffice.carrito.dto.CarritoPersonaDTO;
import com.worldOffice.carrito.dto.ProductoDTO;
import com.worldOffice.carrito.dto.ProductoPersistDTO;
import com.worldOffice.carritoCompras.service.CarritoService;

@RestController
@RequestMapping  ("carritoCompras")
public class CarritoController {
	
	@Autowired
	CarritoService carritoService;
	
	
	private static final Logger log = LoggerFactory.getLogger(CarritoController.class);
	
	@GetMapping (value = "getAllProductos")
	public List<ProductoDTO> consultarProductos(){
		log.info("**** Peticion a getAllProductos ****");
		return carritoService.obtenerproductos();
	}
	
	@PostMapping (value = "crearProducto")
	public String crearProducto(@RequestBody ProductoPersistDTO producto) {
		carritoService.persistirProducto(producto);
		log.info("******Recibio peticion de guardar " + producto.getNombre());
		return "";
	}
	
	@PostMapping (value = "consultarProducto")
	public List<ProductoDTO> consultarProducto(@Param(value = "infoConsulta")  String infoConsulta) {
		HashMap<String, Object> condiciones = new HashMap<>();
		condiciones.put(infoConsulta.split(",")[0], infoConsulta.split(",")[1]);		
		log.info("******Recibio peticion de consultarProducto ");
		return carritoService.obtenerProductosEspecificos(condiciones);
	}
	
	@PostMapping (value = "agregarProductoCarrito")
	public String agregarProductoCarrito(@RequestBody CarritoDTO carritoDTO) {
		String respuesta = carritoService.guardarProductoCarrito(carritoDTO);
		log.info("******Recibio peticion de guardar producto en el carrito");
		return respuesta;
	}
	
	@PostMapping (value = "consultarCarritoCliente")
	public CarritoPersonaDTO consultarCarritoPesona(@Param(value = "infoConsulta")  String infoConsulta) {
		CarritoPersonaDTO respuesta = carritoService.consultarCarritoPersona(Long.parseLong(infoConsulta));
		return respuesta;
	}
}
