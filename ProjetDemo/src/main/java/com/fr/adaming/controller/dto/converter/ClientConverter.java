package com.fr.adaming.controller.dto.converter;

import java.util.ArrayList;
import java.util.List;

import com.fr.adaming.controller.dto.ClientDto;
import com.fr.adaming.entity.Client;

public class ClientConverter {
	
	public Client convertToClass (ClientDto dto) {
		String nom = dto.getNom();
		String prenom = dto.getPrenom();
		String email = dto.getEmail();
		String domaine = dto.getDomaine();
		String nomRepresentant = dto.getNomRepresentant();
		String nomEntreprise  =dto.getNomEntreprise();
		Client client = new Client(nom, prenom, email, domaine, nomRepresentant, nomEntreprise);
		return client;
	}
	
	public ClientDto convertToDto (Client client) {
		String nom = client.getNom();
		String prenom = client.getPrenom();
		String email = client.getEmail();
		String domaine = client.getDomaine();
		String nomRepresentant = client.getNomRepresentant();
		String nomEntreprise  =client.getNomEntreprise();
		ClientDto dto = new ClientDto();
		dto.setNom(nom);
		dto.setPrenom(prenom);
		dto.setEmail(email);
		dto.setDomaine(domaine);
		dto.setNomRepresentant(nomRepresentant);
		dto.setNomEntreprise(nomEntreprise);
		return dto;
	}
	
	public List<Client> convertListToClass(List<ClientDto> dtos){
		List<Client> clients = new ArrayList<Client>();
		for (ClientDto dto : dtos) {
			Client client = convertToClass(dto);
			clients.add(client);
		}
		return clients;
	}
	
	public List<ClientDto> convertListToDto(List<Client> clients){
		List<ClientDto> dtos = new ArrayList<ClientDto>();
		for (Client client : clients) {
			ClientDto dto = convertToDto(client);
			dtos.add(dto);
		}
		return dtos;
	}

}
