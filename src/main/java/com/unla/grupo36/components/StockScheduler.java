package com.unla.grupo36.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.unla.grupo36.services.IStockService;

@Component
public class StockScheduler {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	private IStockService stockService;
	
	public StockScheduler(IStockService stockService) {
		this.stockService = stockService;
	}

	@Scheduled(cron = "*/10 * * * * *")
	public void updateStock() {
		LOGGER.debug("Se actualizarán los stocks");
		stockService.updateOrCreateStock();
	}
}
