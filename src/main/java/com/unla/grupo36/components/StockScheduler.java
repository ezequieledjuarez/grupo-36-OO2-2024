package com.unla.grupo36.components;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.unla.grupo36.dtos.UserDTO;
import com.unla.grupo36.entities.Product;
import com.unla.grupo36.helpers.AddProductsHelper;
import com.unla.grupo36.helpers.BCryptPasswordEncoderHelper;
import com.unla.grupo36.services.IProductService;
import com.unla.grupo36.services.IStockService;
import com.unla.grupo36.services.IUserService;

import jakarta.annotation.PostConstruct;

@Component
public class StockScheduler {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	private IStockService stockService;
	private IUserService userService;
	private IProductService productService;
	public StockScheduler(IStockService stockService, IUserService userService,IProductService productService) {
		this.stockService = stockService;
		this.userService = userService;
		this.productService = productService;
	}

	@Scheduled(cron = "*/10 * * * * *")
	public void updateStock() {
		LOGGER.debug("Se actualizarán los lotes que no tengan asignado un Stock");
		stockService.updateOrCreateStock();
	}
	
	@Scheduled(cron = "*/10 * * * * *")
	public void generatePurchaseOrder() {
		LOGGER.debug("Se generará una orden de compra para los productos sin stock");
		stockService.generatePurchaseOrder();
	}
	
	 @PostConstruct
	    public void executeOnStartup() {
	        LOGGER.debug("Se creará un usuario con rol admin si no existe ninguno en la base de datos");
	        userService.insertIfDatabaseIsEmpty(new UserDTO("root", BCryptPasswordEncoderHelper.encodePassword("root")));
	        LOGGER.debug("Se cargarán productos a la base de datos si no existe ninguno");
	       

			productService.insertOrUpdateBatch(AddProductsHelper.addProducts());
	    }
}
