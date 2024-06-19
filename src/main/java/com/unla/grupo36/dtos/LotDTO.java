package com.unla.grupo36.dtos;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class LotDTO {

	@Schema(description = "Identificador de Lote", name = "id", example = "10", requiredMode = RequiredMode.AUTO)
	private int id;
	@Schema(description = "Cantidad de producto en el lote", name = "productQantity", example = "100", requiredMode = RequiredMode.REQUIRED)
	private int productQantity;
	@Schema(description = "Nombre del proveedor", name = "supplierName", example = "Luchetti", requiredMode = RequiredMode.REQUIRED)
	private String supplierName;
	@Schema(description = "Precio total del lote", name = "lotPrice", example = "8500.00", requiredMode = RequiredMode.REQUIRED)
	private float lotPrice;
	@Schema(description = "Fecha y hora de recepción del lote", name = "receptionDate", example = "2024-06-19T19:45:37.639Z", requiredMode = RequiredMode.REQUIRED)
	private LocalDateTime receptionDate;
	@Schema(description = "Nombre del producto en el lote", name = "name", example = "Fideos", requiredMode = RequiredMode.REQUIRED)
	private String name;
	@Schema(description = "Descripción del producto en el lote", name = "description", example = "Fideos tipo spaghetti", requiredMode = RequiredMode.REQUIRED)
	private String description;
	@Schema(description = "Precio de compra unitario del producto", name = "purchasePrice", example = "85.00", requiredMode = RequiredMode.REQUIRED)
	private Float purchasePrice;
	
}
