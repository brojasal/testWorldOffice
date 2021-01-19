package com.worldOffice.carritoBatch.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.worldOffice.carrito.dto.ProductoDTO;

@Component
public class CosumeCarritoComprasComponent {
	
	

	private HttpHeaders getHttpHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return headers;
	}
	
	public String persistirProducto(ProductoDTO productoDTO) {
	
	RestTemplate restTemplate = new RestTemplate();
	HttpEntity<?> entity = new HttpEntity<>(productoDTO, getHttpHeaders());
	HttpEntity<Boolean> response = restTemplate.exchange("http://localhost:8081/carritoCompras/crearProducto", HttpMethod.POST,
			entity, Boolean.class);
	return null;
	}
}
