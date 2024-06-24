package com.unla.grupo36.services;

import java.util.List;
import java.util.Optional;

import com.unla.grupo36.entities.Product;

public interface IProductService {

	public List<Product> getAll();

	public Optional<Product> findById(int id);

	public List<Product> getByName(String name);

	public Product insertOrUpdate(Product product);

	public List<Product> insertOrUpdateBatch(List<Product> products);

	public void insertOrUpdateBatchIfDatabaseIsEmpty(List<Product> addProducts);

	public List<Product> findByText(String text);

}
