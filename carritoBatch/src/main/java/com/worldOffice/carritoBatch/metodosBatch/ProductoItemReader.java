package com.worldOffice.carritoBatch.metodosBatch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.worldOffice.carrito.dto.ProductoDTO;

public class ProductoItemReader implements ItemReader<ProductoDTO>{

	Iterator<ProductoDTO> productoDTOs;
	private static final Logger log = LoggerFactory.getLogger(ProductoItemWriter.class);
	@BeforeStep
    public void before(StepExecution stepExecution) {
    	
    	List<ProductoDTO> productoDTO = new ArrayList<ProductoDTO>();
    	 
    	Path path = Paths.get("D:\\ProyectosBenjamin\\Test\\carritoBatch\\src\\main\\resources\\InputFiles\\Productos.csv");
    	try {
			Stream<String> stream = Files.lines(path);
			stream.skip(1)
			.forEach((p)->{
				try {
					log.info(p);
					List<String> item = new ArrayList<>(Arrays.asList(p.split(",")));
					ProductoDTO dto = new ProductoDTO(item.get(0),
							item.get(1),
							item.get(2),
							item.get(3),
							item.get(4),
							item.get(5));
					productoDTO.add(dto);
				}catch(Exception e) {
					
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
    	productoDTOs = productoDTO.iterator();
    }
	
	@Override
	public ProductoDTO read()
			throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		if(productoDTOs !=null && productoDTOs.hasNext()) {
			return productoDTOs.next();
		}else		
			return null;
	}

}
