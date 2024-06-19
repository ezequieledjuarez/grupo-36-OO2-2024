package com.unla.grupo36.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BodyResponseError {

	@Schema(description = "Codigo de error", name = "code", example = "404", requiredMode = RequiredMode.REQUIRED)
	private int code;

	@Schema(description = "Codigo de error", name = "messsage", example = "El producto no fue encontrado", requiredMode = RequiredMode.REQUIRED)
	private String message;
}
