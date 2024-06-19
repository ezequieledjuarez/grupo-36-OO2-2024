package com.unla.grupo36.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class PurchaseOrderDTO {

	@Schema(description = "Identificador de Orden de compra", name = "id", example = "8", requiredMode = RequiredMode.AUTO)
	private int id;
	private ProductDTO product;
	@Schema(description = "Cantidad de producto solicitado", name = "qantity", example = "100", requiredMode = RequiredMode.AUTO)
	private int qantity;
}
