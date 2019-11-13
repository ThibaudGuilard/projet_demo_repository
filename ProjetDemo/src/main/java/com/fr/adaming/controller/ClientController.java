package com.fr.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fr.adaming.controller.dto.ClientDto;
import com.fr.adaming.controller.dto.converter.ClientConverter;
import com.fr.adaming.entity.Client;
import com.fr.adaming.service.ClientService;

@RequestMapping(path = "/controller/client")
public class ClientController {
	
	@Autowired
	ClientService service;
	@Autowired
	ClientConverter converter;
	
	@GetMapping(path = "/create_client")
	public String create(@RequestBody ClientDto dto) {
		Client client = converter.convertToClass(dto);
		service.save(client);
		return "client created";
	}
	
	@DeleteMapping(path = "{Client}/delete_client")
	public String deleteClient(@PathVariable ClientDto dto) {
		Client client = converter.convertToClass(dto);
		service.deleteClient(client);
		return "Client deleted";
	}
	
	@GetMapping(path = "{Client}/update_client")
	public String updateClient(@PathVariable ClientDto dto) {
		Client client = converter.convertToClass(dto);
		service.updateClient(client);
		return "Client updated";
	}
	
	public List<Client> printClient() {
		return service.findAll();
	}

}
