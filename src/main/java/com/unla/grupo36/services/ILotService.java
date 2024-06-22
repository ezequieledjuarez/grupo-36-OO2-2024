package com.unla.grupo36.services;

import java.util.List;
import java.util.Optional;

import com.unla.grupo36.entities.Lot;

public interface ILotService {

	public Lot loadLot(Lot lot);

	public List<Lot> loadLot(List<Lot> lots);
	
	public List<Lot> getAll();

	public Optional<Lot> getLot(int id);
}
