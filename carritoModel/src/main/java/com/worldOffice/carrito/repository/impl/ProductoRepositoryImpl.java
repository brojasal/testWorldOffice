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

import com.worldOffice.carrito.entity.ProductoEntity;
@Repository
public class ProductoRepositoryImpl{
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<ProductoEntity> getData(HashMap<String, Object> condiciones){
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<ProductoEntity> query= cb.createQuery(ProductoEntity.class);
		Root<ProductoEntity> root = query.from(ProductoEntity.class);
			
		List<Predicate> predicates = new ArrayList<>();
		condiciones.forEach((field,value) ->
		{
			String valor = value.toString().split(",")[0];
			switch (field)
			{
				case "id":
					predicates.add( cb.equal (root.get(field), Double.parseDouble(valor)));
					break;
				case "nombre":
					predicates.add( cb.like(root.get(field),"%"+(String)valor+"%"));
					break;
				case "marca":
					predicates.add(cb.like(root.get(field),"%"+(String)valor+"%"));
					break;
				case "precio":
					double menor = Double.parseDouble(valor.toString().split(",")[0]);
					double mayor = Double.parseDouble(valor.toString().split(",")[1]);
					predicates.add(cb.between(root.get(field), menor, mayor));				
					break;
				}
			});
			query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
			return entityManager.createQuery(query).getResultList(); 
	}
}
