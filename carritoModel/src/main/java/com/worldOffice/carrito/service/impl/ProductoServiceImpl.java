package com.worldOffice.carrito.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worldOffice.carrito.dao.ProductoDAO;
import com.worldOffice.carrito.entity.ProductoEntity;
import com.worldOffice.carrito.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	ProductoDAO productoDAO;
	
	@Override
	public List<ProductoEntity> getProducto() {
		return (List<ProductoEntity>) productoDAO.findAll();
	}

}
