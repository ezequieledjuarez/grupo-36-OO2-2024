package com.unla.grupo36.entities;


import java.util.Set;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
	@Schema(description="Identificador de Stock", name = "id", example = "1", requiredMode = RequiredMode.AUTO)
	private int id;
	
	
	@Column(name="product_qantity", unique=false, nullable=false)
	@Schema(description="Cantidad disponible del producto",name = "productQantity", example = "11", requiredMode = RequiredMode.REQUIRED)
	private int productQantity;
	

	@OneToMany(fetch=FetchType.LAZY, mappedBy="stock")
	private Set<Lot> lot;


    @OneToOne(cascade = CascadeType.ALL, mappedBy="stock")
    @JoinColumn(name = "product_id", referencedColumnName = "id")
	private Product product;
  
    @Schema(description="Booleano que indica si ya se realizó una nueva orden de compra", name = "ordered", example = "true", requiredMode = RequiredMode.REQUIRED)
	private boolean ordered;
	
	public Stock(Integer id,int productQantity, Set<Lot> lot, Product product) {
		super();
		this.id = id;
		this.productQantity = productQantity;
		this.lot = lot;
		this.product = product;
		this.ordered = true;
	}


		
	
}
