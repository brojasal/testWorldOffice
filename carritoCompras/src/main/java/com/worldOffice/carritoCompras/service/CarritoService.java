package com.worldOffice.carritoCompras.service;

import java.util.HashMap;
import java.util.List;

import com.worldOffice.carrito.dto.CarritoDTO;
import com.worldOffice.carrito.dto.CarritoPersonaDTO;
import com.worldOffice.carrito.dto.ProductoDTO;
import com.worldOffice.carrito.dto.ProductoPersistDTO;

public interface CarritoService {
	
	public List<ProductoDTO> obtenerproductos();
	
	public String persistirProducto(ProductoPersistDTO productoDTO);
	
	public List<ProductoDTO> obtenerProductosEspecificos(HashMap<String, Object> condiciones);
	
	public String guardarProductoCarrito(CarritoDTO carritoDTO);
	
	public CarritoPersonaDTO consultarCarritoPersona(long idPersona);
}
