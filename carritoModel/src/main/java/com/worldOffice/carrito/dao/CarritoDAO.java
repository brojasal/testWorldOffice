package com.worldOffice.carrito.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.worldOffice.carrito.entity.CarritoEntity;

@Repository
public interface CarritoDAO extends CrudRepository<CarritoEntity, Long>{

}
