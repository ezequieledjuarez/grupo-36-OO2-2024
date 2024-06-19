package com.unla.grupo36.services;

import com.unla.grupo36.entities.Stock;

public interface IStockService {

	public void updateOrCreateStock();
	public Stock getById(int id);
	public void generatePurchaseOrder();
}
