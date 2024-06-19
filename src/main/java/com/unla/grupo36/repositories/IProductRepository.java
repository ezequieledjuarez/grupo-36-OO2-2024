package com.unla.grupo36.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.unla.grupo36.entities.Product;

public interface IProductRepository extends JpaRepository<Product, Integer>{

	@Query("SELECT p FROM Product p WHERE p.name LIKE(:name)")
	public abstract List<Product> findByProductName(String name);
}
