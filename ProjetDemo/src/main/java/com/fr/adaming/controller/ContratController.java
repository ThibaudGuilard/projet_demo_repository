package com.fr.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fr.adaming.controller.dto.ContratDto;
import com.fr.adaming.controller.dto.converter.ContratConverter;
import com.fr.adaming.entity.Contrat;
import com.fr.adaming.service.ContratService;

@RequestMapping(path = "/controller/contrat")
public class ContratController {
	
	@Autowired
	ContratService service;
	@Autowired
	ContratConverter converter;

	@PostMapping(path = "/create_contrat")
	public String create(@RequestBody ContratDto dto) {
		Contrat contrat = converter.convertToClass(dto);
		service.save(contrat);
		return "Contrat created";
	}

	@DeleteMapping(path = "{Contrat}/delete_contrat")
	public String deleteContrat(@PathVariable ContratDto dto) {
		Contrat contrat = converter.convertToClass(dto);
		service.deleteContrat(contrat);
		return "Contrat deleted";
	}

	@PostMapping(path = "{Contrat}/update_contrat")
	public String updateClient(@PathVariable ContratDto dto) {
		Contrat contrat = converter.convertToClass(dto);
		service.updateContrat(contrat);
		return "Contrat updated";
	}

	public List<Contrat> printContrat() {
		return service.findAll();
	}

}
