package com.unla.grupo36.controllers.api.v1;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unla.grupo36.dtos.LotDTO;
import com.unla.grupo36.entities.Lot;
import com.unla.grupo36.services.ILotService;

@RestController
@RequestMapping("/api/v1/lots")
public class LotRestController {

	private ILotService lotService;
	private ModelMapper modelMapper;
	
	public LotRestController() {
		super();
	}
	
	public LotRestController(ILotService lotService) {
		super();
		this.lotService = lotService;
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LotDTO> postPerson(@RequestBody LotDTO lotDTO){
		
		Lot lot = modelMapper.map(lotDTO, Lot.class);
		
        return new ResponseEntity<>(
                modelMapper.map(lotService.loadLot(lot),LotDTO.class)
                , HttpStatus.CREATED);
    }

}
