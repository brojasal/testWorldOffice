package com.worldOffice.carrito.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.worldOffice.carrito.dto.CarritoPersonaDTO;
import com.worldOffice.carrito.dto.ProductoPersonaDTO;
import com.worldOffice.carrito.entity.CarritoEntity;

@Component
public class CarritoPersonaConverter {
	
	public CarritoPersonaDTO convertirCarritoPersona(List<CarritoEntity> productosCarrito) {
		CarritoPersonaDTO carritoPersonaDTO = new CarritoPersonaDTO();
		List<ProductoPersonaDTO> productoPersonaDTOs = new ArrayList<ProductoPersonaDTO>();
		for (CarritoEntity entidad : productosCarrito) {
			ProductoPersonaDTO dto = new ProductoPersonaDTO();
			dto.setNombreProducto(entidad.getProducto().getNombre());
			dto.setCantidad(entidad.getCantidad());
			productoPersonaDTOs.add(dto);
		}
		carritoPersonaDTO.setProductoPersonaDTOs(productoPersonaDTOs);
		return carritoPersonaDTO;
	}
}
