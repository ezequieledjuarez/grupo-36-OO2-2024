package com.unla.grupo36.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6598523389874350245L;
	
	public ProductNotFoundException(String errorMessage) {
		super(errorMessage);
	}

}
