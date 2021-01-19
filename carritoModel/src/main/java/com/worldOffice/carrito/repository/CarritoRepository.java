package com.worldOffice.carrito.repository;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.worldOffice.carrito.entity.CarritoEntity;

public interface CarritoRepository extends JpaRepository<CarritoEntity, Long>{
	
	public List<CarritoEntity> getData(HashMap<String, Object> condiciones);
}
