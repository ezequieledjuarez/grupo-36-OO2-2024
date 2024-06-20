package com.unla.grupo36.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.unla.grupo36.entities.Stock;

public interface IStockRepository extends JpaRepository<Stock, Integer> {

	@Query("SELECT s FROM Stock s JOIN FETCH s.product p WHERE p.id=:id")
	public abstract Stock findProductInStock(int id);

	@Modifying
	@Query(value=
	"UPDATE Stock s SET s.product_id=:productId where s.id=:id"
	,nativeQuery = true)
	public abstract void updateStockWithProduct(@Param("productId") int productId, @Param("id") int id);

	@Modifying
	@Query(value=
	"UPDATE Stock s set s.ordered=1 WHERE s.id = :stockId"
	,nativeQuery = true)
	public abstract void updateProductOrdered(@Param("stockId") int stockId);
}
