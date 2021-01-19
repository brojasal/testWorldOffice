package com.worldOffice.carrito.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.worldOffice.carrito.entity.PersonaEntity;

@Repository
public interface PersonaDAO extends CrudRepository<PersonaEntity, Long>{
	
}
