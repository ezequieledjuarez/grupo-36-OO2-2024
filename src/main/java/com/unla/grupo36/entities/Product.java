package com.unla.grupo36.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private String description;
	@Column(name="purchase_price", unique=false, nullable=false)
	private float pruchasePrice;
	@Column(name="selling_price", unique=false, nullable=false)
	private float sellingPrice;
	
	public Product(String name, String description, float pruchasePrice, float sellingPrice) {
		super();
		this.name = name;
		this.description = description;
		this.pruchasePrice = pruchasePrice;
		this.sellingPrice = sellingPrice;
	}
	
	
}
