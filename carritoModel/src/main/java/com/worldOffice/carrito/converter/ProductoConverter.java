package com.worldOffice.carrito.converter;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.worldOffice.carrito.dto.ProductoDTO;
import com.worldOffice.carrito.dto.ProductoPersistDTO;
import com.worldOffice.carrito.entity.ProductoEntity;

@Component
public class ProductoConverter {
	
	private static final Logger log = LoggerFactory.getLogger(ProductoConverter.class);
	
	public List<ProductoDTO> convertirProducto(List<ProductoEntity> productos) {
		List<ProductoDTO> dtos = new ArrayList<ProductoDTO>();
		for(ProductoEntity producto : productos) {
			dtos.add(new ProductoDTO(producto.getNombre(), "", 
					"0", "0", "", "0"));
		}
		
		return dtos;
	}
	
	public ProductoEntity convertirProductorEntity(ProductoPersistDTO persistDTO) {
		ProductoEntity productoEntity = new ProductoEntity();
		try {
		productoEntity.setNombre(persistDTO.getNombre());
		productoEntity.setMarca(persistDTO.getMarca());
		productoEntity.setPrecio(Double.parseDouble(persistDTO.getPrecio()!= "" ? persistDTO.getPrecio():"0"));
		productoEntity.setCantidadStock(Integer.parseInt(persistDTO.getCantidadStock()!=""?persistDTO.getCantidadStock():"0"));
		productoEntity.setEstado(persistDTO.getEstado());
		productoEntity.setPorcentajeDescuento(Double.parseDouble(persistDTO.getProcentajeDescuento() != ""?persistDTO.getProcentajeDescuento():"0"));
		}catch(Exception e) {
			
		}
		log.info("Se ha transformado de producto a entity "+ productoEntity.getNombre());
		return productoEntity;
	}
}
