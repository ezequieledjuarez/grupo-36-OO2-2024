package com.unla.grupo36.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Lot {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="product_qantity", unique=true, nullable=false)
	private int productQantity;
	@Column(name="supplier_name", unique=true, nullable=false)
	private String supplierName;
	@Column(name="lot_price", unique=true, nullable=false)
	private float lotPrice;
	@Column(name="reception_date", unique=true, nullable=false)
	private LocalDate receptionDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="product_id", nullable=true)
	private Product product;

	public Lot(int productQantity, String supplierName, float lotPrice, LocalDate receptionDate, Product product) {
		super();
		this.productQantity = productQantity;
		this.supplierName = supplierName;
		this.lotPrice = lotPrice;
		this.receptionDate = receptionDate;
		this.product = product;
	}
	
	
}
