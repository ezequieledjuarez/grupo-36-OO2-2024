package com.unla.grupo36.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.unla.grupo36.entities.Product;

public interface IProductRepository extends JpaRepository<Product, Integer>{

	
	@Query(value = "select * from Product p where p.name like %:name%", nativeQuery = true)

	public abstract List<Product> findByProductName(@Param("name")String name);
	
	@Query("SELECT p FROM Product p where p.stock is null")
	public abstract List<Product> findProductWithoutStock();

	@Modifying
	@Query(value=
	"UPDATE Product p set p.stock_id = :id where p.id = :productId"
	,nativeQuery = true)
	public abstract void updateProductWithStock(@Param("productId") int productId, @Param("id") int id);

}
