package com.unla.grupo36.services.implementation;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.unla.grupo36.entities.Lot;
import com.unla.grupo36.repositories.ILotRepository;
import com.unla.grupo36.repositories.IProductRepository;
import com.unla.grupo36.services.ILotService;

@Service("lotService")
public class LotService implements ILotService{

	private ILotRepository lotRepository;
	
	private ModelMapper modelMapper = new ModelMapper();

	public LotService(ILotRepository lotRepository) {
		super();
		this.lotRepository = lotRepository;
	}
	
	@Override
	public Lot loadLot(Lot lot) {
		
		return lotRepository.save(lot);
	}

	@Override
	public List<Lot> loadLot(List<Lot> lots) {
	
		return lotRepository.saveAll(lots);
	}

	@Override
	public Optional<Lot> getLot(int id) {

		return lotRepository.findById(id);
	}


}
