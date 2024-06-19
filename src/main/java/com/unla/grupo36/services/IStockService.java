package com.unla.grupo36.services;

import java.util.List;

import com.unla.grupo36.dtos.PurchaseOrderDTO;
import com.unla.grupo36.entities.Stock;

public interface IStockService {

	public void updateOrCreateStock();
	public Stock getById();
	public List<PurchaseOrderDTO> generatePurchaseOrder();
}
