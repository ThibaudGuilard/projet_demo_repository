package com.fr.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fr.adaming.controller.dto.ProjetDto;
import com.fr.adaming.controller.dto.converter.ProjetConverter;
import com.fr.adaming.entity.Projet;
import com.fr.adaming.service.ProjetService;

@RequestMapping(path = "/controller/projet")
public class ProjetController {

	@Autowired
	ProjetService service;
	@Autowired
	ProjetConverter converter;

	@PostMapping(path = "/create_projet")
	public String create(@RequestBody ProjetDto dto) {
		Projet projet = converter.convertToClass(dto);
		service.save(projet);
		return "Projet created";
	}

	@DeleteMapping(path = "{Projet}/delete_projet")
	public String deleteProjet(@PathVariable ProjetDto dto) {
		Projet projet = converter.convertToClass(dto);
		service.deleteProjet(projet);
		return "Projet deleted";
	}

	@PostMapping(path = "{Projet}/update_projet")
	public String updateProjet(@PathVariable ProjetDto dto) {
		Projet projet = converter.convertToClass(dto);
		service.updateProjet(projet);
		return "Projet updated";
	}

	public List<Projet> printProjet() {
		return service.findAll();
	}

}
