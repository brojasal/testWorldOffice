package com.worldOffice.carritoBatch.metodosBatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.worldOffice.carrito.dto.ProductoDTO;

public class ProductoItemProcessor implements ItemProcessor<ProductoDTO, ProductoDTO>{
	
	private static final Logger log = LoggerFactory.getLogger(ProductoItemProcessor.class);
	@Override
	public ProductoDTO process(ProductoDTO item) throws Exception {
		
		
		/*ProductoEntity productoEntity = new ProductoEntity();
		try {
		productoEntity.setNombre(item.getNombre());
		productoEntity.setMarca(item.getMarca());
		productoEntity.setPrecio(Double.parseDouble(item.getPrecio()!= "" ? item.getPrecio():"0"));
		productoEntity.setCantidadStock(Integer.parseInt(item.getCantidadStock()!=""?item.getCantidadStock():"0"));
		productoEntity.setEstado(item.getEstado());
		productoEntity.setPorcentajeDescuento(Double.parseDouble(item.getProcentajeDescuento() != ""?item.getProcentajeDescuento():"0"));
		}catch(Exception e) {
			
		}
*/
		log.info("Se ha procesado el producto "+ item.getNombre());
		return item;
	}
	
}
