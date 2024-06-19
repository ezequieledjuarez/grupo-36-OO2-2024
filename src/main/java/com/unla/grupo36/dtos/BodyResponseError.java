package com.unla.grupo36.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class BodyResponseError {

	private int code;

	
	private String message;
}
