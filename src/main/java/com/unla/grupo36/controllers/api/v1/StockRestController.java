package com.unla.grupo36.controllers.api.v1;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unla.grupo36.entities.Stock;
import com.unla.grupo36.services.IStockService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/v1/stock")
public class StockRestController {

	private IStockService stockService;
	
	public StockRestController() {
		super();
	}
	
	
	public StockRestController(IStockService stockService) {
		super();
		this.stockService = stockService;
	}
	
	@Operation(summary = "Da de alta un nuevo Stock o actualiza los stocks que no tengan asociado un producto, un producto que no tenga asociado un stock y un lote que no tenga asociado un stock.", description = "Actualiza stocks, productos y lotes")
	@PutMapping("/update")
	public void updateOrCreateStock() {
		stockService.updateOrCreateStock();
	};
	
	@Operation(summary = "Busca y devuelve un stock a través de su id", description = "Busca un stock por su id")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "Stock encontrado")
	    })
	
	@GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Stock getById(@Parameter(name = "id", description = "Stock id") @PathVariable(name="id") int id) {
		return stockService.getById(id);
	};
	
	@Operation(summary = "Genera una orden de compra para los stocks con cantidad de productos en 0 y sin orden de compra generada.", description = "Emisión de orden de compra")
	@PostMapping("/generate_purchase_order")
	public void generatePurchaseOrder(){
		 stockService.generatePurchaseOrder();
	};
}
