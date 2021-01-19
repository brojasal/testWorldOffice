package com.worldOffice.carrito.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.worldOffice.carrito.entity.ProductoEntity;

@Repository
public interface ProductoDAO extends CrudRepository<ProductoEntity, Long>{
	

}
