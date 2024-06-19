package com.unla.grupo36.controllers.api.v1;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unla.grupo36.dtos.ProductDTO;
import com.unla.grupo36.entities.Product;
import com.unla.grupo36.exceptions.ProductNotFoundException;
import com.unla.grupo36.services.IProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductRestController {

	private IProductService productService;
	private ModelMapper modelMapper;
	
	public ProductRestController() {
		super();
	}
	
	public ProductRestController(IProductService ProductService) {
		super();
		this.productService = ProductService;
	}
	
	@GetMapping(value="/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductDTO>> getAll(){
		return new ResponseEntity<>(
				productService.getAll()
					.stream().map(
						product -> modelMapper.map(product, ProductDTO.class))
							.collect(Collectors.toList()),
				HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductDTO> getById(@PathVariable(name="id") int id) throws ProductNotFoundException{
		
		Optional<Product> optionalProduct = Optional.ofNullable
												(productService.findById(id)
												.orElseThrow(() -> new ProductNotFoundException("No se encontró el producto con id: " + id)));
		
		return new ResponseEntity<>(modelMapper.map(optionalProduct.get(), ProductDTO.class),
				HttpStatus.OK) ;
	};
	
	@GetMapping(value="name", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductDTO>> getByName(@RequestParam(value="name") String name) throws ProductNotFoundException{
		List<Product> listProduct = productService.getByName(name);
		
		if(listProduct.isEmpty())
			throw new ProductNotFoundException("No se encontraron productos con el nombre: " +  name);
		else 
			return new ResponseEntity<>(
					listProduct
						.stream().map(
								product -> modelMapper.map(product, ProductDTO.class))
									.collect(Collectors.toList()), 
					HttpStatus.OK);
	}
	
	@PostMapping(value="/add", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductDTO> insertOrUpdate(@RequestBody ProductDTO productDTO){
		
		Product product = productService.insertOrUpdate
		(modelMapper.map(productDTO, Product.class));
		
		return new ResponseEntity<>(
				modelMapper.map
					(product, ProductDTO.class)
				, HttpStatus.OK);
		
	}
	
	@PostMapping(value="/add_all", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductDTO>> insertOrUpdateBatch(@RequestBody List<ProductDTO> productsDTO){
		
		List<Product> products = productService.insertOrUpdateBatch(productsDTO
				.stream().map(
						product -> modelMapper.map(product, Product.class))
							.collect(Collectors.toList()));
				
		return new ResponseEntity<>(
				products
					.stream().map(
						product -> modelMapper.map(product, ProductDTO.class))
							.collect(Collectors.toList()),
				HttpStatus.OK);
		
	}
}
