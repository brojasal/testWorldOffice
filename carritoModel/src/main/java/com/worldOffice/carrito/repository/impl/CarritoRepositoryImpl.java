package com.worldOffice.carrito.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.worldOffice.carrito.entity.CarritoEntity;

@Repository
public class CarritoRepositoryImpl {
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<CarritoEntity> getData(HashMap<String, Object> condiciones){
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<CarritoEntity> query= cb.createQuery(CarritoEntity.class);
		Root<CarritoEntity> root = query.from(CarritoEntity.class);
			
		List<Predicate> predicates = new ArrayList<>();
		condiciones.forEach((field,value) ->
		{
			String valor = value.toString().split(",")[0];
			switch (field)
			{
				case "id":
					predicates.add( cb.equal (root.get(field), Double.parseDouble(valor)));
					break;
				case "personaConsecutivo":
					predicates.add( cb.equal(root.get(field),valor));
					System.out.println(query.toString()); 
					break;
				}
			});
			query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
			return entityManager.createQuery(query).getResultList();
	}
}
