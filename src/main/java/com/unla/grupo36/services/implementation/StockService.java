package com.unla.grupo36.services.implementation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
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

		LOGGER.debug("Se actualizarán {} lotes", products.size());
		
		for (Lot lot : products) {
			Set<Lot> lotSet = new HashSet<Lot>();
			lotSet.add(lot);
			int stockId = findStock(lot.getProduct().getId());
			Stock stock = stockRepository.save(new Stock(stockId, lot.getProductQantity(), lotSet, lot.getProduct()));
			
			LOGGER.debug("Se asignará el Stock {} al Producto {}", stock.getId(), lot.getProduct().getName());
			productRepository.updateProductWithStock(stock.getProduct().getId(), stock.getId());
			
			LOGGER.debug("Se asignará el Stock {} al Lote {}", stock.getId(), lot.getId());
			lotRepository.updateLotWithStock(stock.getId(), lot.getId());
			
		}
		
		LOGGER.debug("Se actualizaron correctamente los lotes y productos, con sus stocks correspondientes");

	}

	private int findStock(int id) {
		int idProduct = 0;
		Stock stock = stockRepository.findProductInStock(id);

		if (stock != null)
			idProduct = stock.getId();

		return idProduct;

	}

	@Override
	public Stock getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void generatePurchaseOrder() {
		List<Stock> stocks = stockRepository.findAll();
		
		
		for (Stock stock : stocks) {
			if(stock.getProductQantity() == 0 && Boolean.FALSE.equals(stock.isOrdered())) {
				Lot lot = lotRepository.findByStockId(stock.getId());
				LOGGER.debug("Se generará una orden de compra para el producto {}", stock.getProduct().getName());
				LOGGER.debug("Se solicita a {} la reposición de 100 unidades del producto {}", lot.getSupplierName(), stock.getProduct().getName());
				
				stockRepository.updateProductOrdered(stock.getId());
			}
		}
	}

}
