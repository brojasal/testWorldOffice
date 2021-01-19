package com.worldOffice.carrito.repository;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.worldOffice.carrito.entity.ProductoEntity;

public interface ProductoRepository  extends JpaRepository<ProductoEntity, Long>{

	public List<ProductoEntity> getData(HashMap<String, Object> condiciones);
}
