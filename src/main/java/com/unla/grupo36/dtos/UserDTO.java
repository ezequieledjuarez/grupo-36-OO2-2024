package com.unla.grupo36.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class UserDTO {

	@Schema(description = "Nombre de usuario", name = "username", example = "ezejuarez", requiredMode = RequiredMode.AUTO)
	private String username;
	@Schema(description = "Contraseña del usuario", name = "password", example = "********", requiredMode = RequiredMode.AUTO)
	private String password;
}
