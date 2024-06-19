package com.unla.grupo36.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
	private Float purchasePrice;
	@Column(name="selling_price", unique=false, nullable=false)
	private Float sellingPrice;
	private Boolean isAvailable;
	
	@OneToOne
	@JoinColumn(name = "stock_id", referencedColumnName = "id")
    private Stock stock;
	
	public Product(String name, String description, float purchasePrice, Float sellingPrice, Integer id, Boolean isAvailable) {
		super();
		this.id = null == id ? 0 : id;
		this.name = name;
		this.description = description;
		this.purchasePrice = purchasePrice;
		this.sellingPrice = null == sellingPrice ? purchasePrice * 1.40f : sellingPrice;
		this.isAvailable = null == isAvailable ? true: false;
	}
	
	
}
