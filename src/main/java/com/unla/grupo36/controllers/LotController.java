package com.unla.grupo36.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo36.dtos.LotDTO;
import com.unla.grupo36.entities.Lot;
import com.unla.grupo36.entities.Product;
import com.unla.grupo36.helpers.ViewRouteHelper;
import com.unla.grupo36.services.ILotService;
import com.unla.grupo36.services.IProductService;

@PreAuthorize("hasRole('ROLE_ADMIN')")
@Controller
@RequestMapping("/lots")
public class LotController {

	private ILotService lotService;
	private IProductService productService;
	public LotController(ILotService lotService, IProductService productService) {
		this.lotService = lotService;
		this.productService = productService;
	}

	
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.INDEX);
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCT_INDEX);
		mAV.addObject("lots", lotService.getAll());
		return modelAndView;
	}
	
	
	@GetMapping("/add")
	public ModelAndView add() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.LOT_ADD);
		mAV.addObject("lot", new LotDTO());
		mAV.addObject("products", productService.getAll());

		return mAV;
	}

	@PostMapping("/new")
	public RedirectView create(@ModelAttribute("lot") LotDTO lotDTO) {
		lotService.loadLot(new Lot(lotDTO.getProductQantity(), lotDTO.getSupplierName(), lotDTO.getLotPrice(),
				lotDTO.getReceptionDate(), new Product(lotDTO.getName(), lotDTO.getDescription(),
						lotDTO.getLotPrice() / lotDTO.getProductQantity())));
		return new RedirectView(ViewRouteHelper.PRODUCT_ROOT);
	}

}
