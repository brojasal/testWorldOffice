package com.worldOffice.carritoBatch.metodosBatch.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemReadListener;

import com.worldOffice.carrito.dto.ProductoDTO;

public class ProductoItemReaderListener implements ItemReadListener<ProductoDTO>{

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductoItemReaderListener.class);
	@Override
	public void beforeRead() {
		LOGGER.info("beforeRead");
		
	}

	@Override
	public void afterRead(ProductoDTO item) {
		LOGGER.info("********* afterRead: " + item.toString());
		
	}

	@Override
	public void onReadError(Exception ex) {
		LOGGER.info("onReadError");
		
	}

}
