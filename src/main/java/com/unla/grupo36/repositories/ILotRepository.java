package com.unla.grupo36.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.unla.grupo36.entities.Lot;

public interface ILotRepository extends JpaRepository<Lot, Integer> {

	
	@Query("SELECT l FROM Lot l where l.stock is null")
	public abstract List<Lot> findProductWithoutStock();

	@Modifying
	@Query(value=
	"UPDATE Lot l set l.stock_id = :stockId where l.id = :id"
	,nativeQuery = true)
	public abstract void updateLotWithStock(@Param("stockId") int stockId, @Param("id") int id);

}
