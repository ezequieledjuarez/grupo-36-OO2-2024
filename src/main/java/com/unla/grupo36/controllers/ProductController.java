package com.unla.grupo36.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo36.dtos.ProductDTO;
import com.unla.grupo36.entities.Product;
import com.unla.grupo36.helpers.ViewRouteHelper;
import com.unla.grupo36.services.IProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	private IProductService productService;

	private ModelMapper modelMapper = new ModelMapper();

	public ProductController(IProductService productService) {
		this.productService = productService;
	}

	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCT_INDEX);
		mAV.addObject("products", productService.getAll());
		return mAV;
	}

	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCTS_ADD);
		mAV.addObject("product", new ProductDTO());
		return mAV;
	}

	@PostMapping("/add")
	public RedirectView create(@ModelAttribute("product") ProductDTO productDTO) {
		productService.insertOrUpdate(new Product(
										productDTO.getName(), 
										productDTO.getDescription(), 
										productDTO.getPurchasePrice(), 
										productDTO.getSellingPrice(), 
										productDTO.getId(),
										productDTO.isAvailable()));
		return new RedirectView(ViewRouteHelper.PRODUCT_ROOT);
	}

	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") int id) throws Exception {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCT_VIEW);
		ProductDTO productDTO = modelMapper.map(productService.findById(id).get(), ProductDTO.class);
		mAV.addObject("product", productDTO);
		return mAV;
	}

	@GetMapping("/edit/{id}")
	public ModelAndView getPartial(@PathVariable("id") int id) throws Exception {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCT_EDIT);
		ProductDTO productDTO  = modelMapper.map(productService.findById(id).get(), ProductDTO.class);
		mAV.addObject("product", productDTO);
		return mAV;
	}

//	@GetMapping("/by_name/{name}")
//	public ModelAndView getByName(@PathVariable("name") String name) throws Exception {
//		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERSON_UPDATE);
//		PersonDTO personDTO = modelMapper.map(personService.findByName(name), PersonDTO.class);
//		mAV.addObject("person", personDTO);
//		return mAV;
//	}
//
//	@GetMapping("/by_degree/{degree_name}")
//	public ModelAndView getByDegreeName(@PathVariable("degree_name") String degreeName) {
//		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERSON_INDEX);
//		mAV.addObject("persons", personService.findByDegreeName(degreeName));
//		return mAV;
//	}
//
//	@PostMapping("/update")
//	public RedirectView update(@ModelAttribute("person") PersonDTO personDTO) throws Exception {
//		Person personToUpdate = modelMapper.map(personService.findById(personDTO.getId()).get(), Person.class);
//		if(personToUpdate != null ) {
//			personToUpdate.setName(personDTO.getName());
//			personService.insertOrUpdate(personToUpdate);
//		}
//		return new RedirectView(ViewRouteHelper.PERSON_ROOT);
//	}
//
//	@PostMapping("/delete/{id}")
//	public RedirectView delete(@PathVariable("id") int id) {
//		personService.remove(id);
//		return new RedirectView(ViewRouteHelper.PERSON_ROOT);
//	}
}
