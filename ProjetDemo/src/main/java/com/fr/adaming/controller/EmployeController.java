package com.fr.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fr.adaming.controller.dto.EmployeDto;
import com.fr.adaming.controller.dto.converter.EmployeConverter;
import com.fr.adaming.entity.Employe;
import com.fr.adaming.service.EmployeService;

public class EmployeController {
	
	@Autowired
	EmployeService service;
	@Autowired
	EmployeConverter converter;

	@PostMapping(path = "/create_employe")
	public String create(@RequestBody EmployeDto dto) {
		Employe employe = converter.convertToClass(dto);
		service.save(employe);
		return "Employe created";
	}

	@DeleteMapping(path = "{Employe}/delete_employe")
	public String deleteEmploye(@PathVariable EmployeDto dto) {
		Employe employe = converter.convertToClass(dto);
		service.deleteEmploye(employe);
		return "Employe deleted";
	}

	@PostMapping(path = "{Employe}/update_employe")
	public String updateEmploye(@PathVariable EmployeDto dto) {
		Employe employe = converter.convertToClass(dto);
		service.updateEmploye(employe);
		return "Employe updated";
	}

	public List<Employe> printEmploye() {
		return service.findAll();
	}

}
