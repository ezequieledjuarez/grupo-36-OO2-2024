package com.unla.grupo36.helpers;

import java.util.ArrayList;
import java.util.List;

import com.unla.grupo36.entities.Product;

public class AddProductsHelper {

	public static List<Product> addProducts(){
		 List<Product> products = new ArrayList<>();
	        products.add(new Product("Leche", "Leche descremada La Serenisima", 500.0f, 1200f, null, true));
	        products.add(new Product("Café", "Café Dolca dorado", 12500.0f, 21200f, null, true));
	        products.add(new Product("Yogurt", "Yogurt firme Yogurisimo", 600.0f, 1200f, null, true));
	        products.add(new Product("Fideos", "Fideos Matarazzo tipo Spaghetti", 800.0f, 1400f, null, false));
	        products.add(new Product("Dulce de Leche", "Dulce de Leche Sancor", 1500.0f, 2200f, null, true));
	        products.add(new Product("Queso Rayado", "Queso Rayado La Serenisima", 2500.0f, 4200f, null, true));
	        products.add(new Product("Mermelada", "Mermelada de ciruela Emeth", 500.0f, 1200f, null, true));
	        products.add(new Product("Yerba Mate", "Yerba Mate La Tranquera", 3500.0f, 5200f, null, true));
	        products.add(new Product("Té en saquitos", "Té en saquitos Green Hill x 50", 2500.0f, 4200f, null, true));
	        products.add(new Product("Jabón", "Jabón Dove", 800.0f, 1300f, null, true));
	        return products;
	}
}
