package com.unla.grupo36.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.unla.grupo36.entities.Product;
import com.unla.grupo36.repositories.IProductRepository;
import com.unla.grupo36.services.IProductService;

@Service("productService")
public class ProductService implements IProductService {

	private IProductRepository productRepository;
	
	public ProductService(IProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> getAll() {

		return productRepository.findAll();
	}

	@Override
	public Optional<Product> findById(int id) {
		
		return productRepository.findById(id);
	}

	@Override
	public List<Product> getByName(String name) {
		
		return productRepository.findByProductName(name);
	}

	@Override
	public Product insertOrUpdate(Product product) {
		
		return productRepository.save(product);
	}

	@Override
	public List<Product> insertOrUpdateBatch(List<Product> products) {
		return productRepository.saveAll(products);
	}

}
