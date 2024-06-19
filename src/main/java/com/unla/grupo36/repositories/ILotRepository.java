package com.unla.grupo36.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unla.grupo36.entities.Lot;

public interface ILotRepository extends JpaRepository<Lot, Integer> {

}
