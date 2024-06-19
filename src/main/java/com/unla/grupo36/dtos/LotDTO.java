package com.unla.grupo36.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class LotDTO {


	private int id;
	
	private int productQantity;
	private String supplierName;
	private float lotPrice;
	private LocalDateTime receptionDate;
	private String name;
	private String description;
	private Float purchasePrice;
	
}
