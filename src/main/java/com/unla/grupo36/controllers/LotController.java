package com.unla.grupo36.controllers;

import org.modelmapper.ModelMapper;
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

@Controller
@RequestMapping("/lots")
public class LotController {

	private ILotService lotService;
	
	private ModelMapper modelMapper = new ModelMapper();

	public LotController(ILotService lotService) {
		this.lotService = lotService;
	}
	
	@GetMapping("/add")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.LOT_ADD);
		mAV.addObject("lot", new LotDTO());
		return mAV;
	}

	@PostMapping("/new")
	public RedirectView create(@ModelAttribute("lot") LotDTO lotDTO) {
		lotService.loadLot(new Lot(
							lotDTO.getProductQantity(),
							lotDTO.getSupplierName(),
							lotDTO.getLotPrice(), 
							lotDTO.getReceptionDate(), 
						 		new Product(
						 			lotDTO.getName(), 
						 			lotDTO.getDescription(), 
						 			lotDTO.getLotPrice() / lotDTO.getProductQantity())));
		return new RedirectView(ViewRouteHelper.PRODUCT_ROOT);
	}

}
