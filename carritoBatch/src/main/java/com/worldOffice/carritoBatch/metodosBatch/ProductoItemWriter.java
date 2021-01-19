package com.worldOffice.carritoBatch.metodosBatch;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;

import com.worldOffice.carrito.dao.ProductoDAO;
import com.worldOffice.carrito.dto.ProductoDTO;
import com.worldOffice.carritoBatch.service.CosumeCarritoComprasComponent;

public class ProductoItemWriter implements ItemWriter<ProductoDTO>{

	private static final Logger log = LoggerFactory.getLogger(ProductoItemWriter.class);
	
	@Autowired
	ProductoDAO productoDAO;
	
	@Autowired
	PlatformTransactionManager platformTransactionManager;
	
	@Autowired
	CosumeCarritoComprasComponent cons;
	
	/*
	 * He tenido que hacer la escritura de esta forma para que usen
	 * la misma base de datos, de la forma tradicional quedan en 
	 * instancias independientes de h2
	 */
	@Override
	public void write(List<? extends ProductoDTO> items) throws Exception {
		log.info("Se ha logrado llegar hasta el write");
		for (int i = 0; i< items.size(); i++) {
			if(validarDatosCompletos(items.get(i)))
				cons.persistirProducto(items.get(i));
		};
		//productoDAO.saveAll(items);
	}
	
	private boolean validarDatosCompletos(ProductoDTO productoDTO) {
		if(productoDTO.getNombre()==null || productoDTO.getNombre().equals("")
			|| productoDTO.getEstado()==null || productoDTO.getEstado().equals("")
			|| productoDTO.getMarca()==null || productoDTO.getMarca().equals("")
			|| productoDTO.getPrecio()==null || productoDTO.getPrecio().equals("") || productoDTO.getPrecio().equals("0"))
			return false;
		else
			return true;
	}

}
