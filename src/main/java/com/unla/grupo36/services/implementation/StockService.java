package com.unla.grupo36.services.implementation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unla.grupo36.dtos.PurchaseOrderDTO;
import com.unla.grupo36.entities.Lot;
import com.unla.grupo36.entities.Stock;
import com.unla.grupo36.repositories.ILotRepository;
import com.unla.grupo36.repositories.IProductRepository;
import com.unla.grupo36.repositories.IStockRepository;
import com.unla.grupo36.services.IStockService;

@Service("stockService")
public class StockService implements IStockService {

	private IProductRepository productRepository;

	private ILotRepository lotRepository;

	private IStockRepository stockRepository;

	public StockService(IProductRepository productRepository, ILotRepository lotRepository,
			IStockRepository stockRepository) {
		super();
		this.productRepository = productRepository;
		this.lotRepository = lotRepository;
		this.stockRepository = stockRepository;
	}

	@Override
	@Transactional
	public void updateOrCreateStock() {
		List<Lot> products = lotRepository.findProductWithoutStock();

		for (Lot lot : products) {
			Set<Lot> lotSet = new HashSet<Lot>();
			lotSet.add(lot);
			int stockId = findStock(lot.getProduct().getId());
			Stock stock = stockRepository.save(new Stock(stockId, lot.getProductQantity(), lotSet, lot.getProduct()));
			stockRepository.updateStockWithProduct(stock.getProduct().getId(), stock.getId());
			productRepository.updateProductWithStock(stock.getProduct().getId(), stock.getId());
			lotRepository.updateLotWithStock(stock.getId(), lot.getId());
		}

	}

	private int findStock(int id) {
		int idProduct = 0;
		Stock stock = stockRepository.findProductInStock(id);

		if (stock != null)
			idProduct = stock.getId();

		return idProduct;

	}

	@Override
	public Stock getById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PurchaseOrderDTO> generatePurchaseOrder() {
		// TODO Auto-generated method stub
		return null;
	}

}
