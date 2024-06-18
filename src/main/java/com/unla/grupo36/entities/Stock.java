package com.unla.grupo36.entities;


import java.util.Set;

import com.unla.grupo36.entities.Lot;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
	
	
	@Column(name="product_qantity", unique=true, nullable=false)
	private int productQantity;
	

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="lot_id", nullable=true)
	private Set<Lot> lot;


	public Stock(int productQantity, Set<Lot> lot) {
		super();
		this.productQantity = productQantity;
		this.lot = lot;
	}


		
	
}
