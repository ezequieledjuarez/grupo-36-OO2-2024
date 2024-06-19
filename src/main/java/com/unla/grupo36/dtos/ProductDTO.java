package com.unla.grupo36.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ProductDTO {
	
	private int id;
	private String name;
	private String description;
	private Float purchasePrice;
	private Float sellingPrice;
	private boolean isAvailable;
}
