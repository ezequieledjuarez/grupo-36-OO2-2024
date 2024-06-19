package com.unla.grupo36.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ProductDTO {
	
	@Schema(description = "Identificador de Producto", name = "id", example = "10", requiredMode = RequiredMode.AUTO)
	private int id;
	@Schema(description = "Nombre del producto", name = "name", example = "Rollo de cocina", requiredMode = RequiredMode.REQUIRED)
	private String name;
	@Schema(description = "Descripción del producto", name = "description", example = "Rollo de cocina de 200 hojas.", requiredMode = RequiredMode.REQUIRED)
	private String description;
	@Schema(description = "Precio de compra unitario del producto", name = "purchasePrice", example = "85.00", requiredMode = RequiredMode.REQUIRED)
	private Float purchasePrice;
	@Schema(description = "Precio de venta unitario del producto", name = "sellingPrice", example = "125.00", requiredMode = RequiredMode.REQUIRED)
	private Float sellingPrice;
	@Schema(description = "Booleano que indica si el producto está disponible", name = "isAvailable", example = "true", requiredMode = RequiredMode.REQUIRED)
	private boolean isAvailable;
}
