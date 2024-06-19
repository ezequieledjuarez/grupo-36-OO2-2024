package com.unla.grupo36.entities;


import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name="product_qantity", unique=false, nullable=false)
	private int productQantity;
	

	@OneToMany(fetch=FetchType.LAZY, mappedBy="stock")
	private Set<Lot> lot;


    @OneToOne(cascade = CascadeType.ALL, mappedBy="stock")
    @JoinColumn(name = "product_id", referencedColumnName = "id")
	private Product product;
	
	public Stock(Integer id,int productQantity, Set<Lot> lot, Product product) {
		super();
		this.id = id;
		this.productQantity = productQantity;
		this.lot = lot;
		this.product = product;
	}


		
	
}
