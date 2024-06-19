package com.unla.grupo36.controllers.api.v1;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unla.grupo36.services.IProductService;
import com.unla.grupo36.services.IStockService;

@RestController
@RequestMapping("/api/v1/stock")
public class StockRestController {

	private IProductService productService;
	private IStockService stockService;
	private ModelMapper modelMapper;
	
	public StockRestController() {
		super();
	}
	
	public StockRestController(IProductService ProductService, IStockService stockService) {
		super();
		this.productService = ProductService;
		this.stockService = stockService;
	}
	
}
