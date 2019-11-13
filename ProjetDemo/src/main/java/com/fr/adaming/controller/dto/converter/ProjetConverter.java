package com.fr.adaming.controller.dto.converter;

import java.util.ArrayList;
import java.util.List;

import com.fr.adaming.controller.dto.ProjetDto;
import com.fr.adaming.entity.Employe;
import com.fr.adaming.entity.Projet;

public class ProjetConverter {
	
	public Projet convertToClass(ProjetDto dto) {
		String nomProjet = dto.getNomProjet();
		String nomEquipe = dto.getNomEquipe();
		List<Employe> employes = dto.getEmployes();
		Projet projet = new Projet(nomProjet, nomEquipe, employes);
		return projet;
	}

	public ProjetDto convertToDto(Projet projet) {

		String nomProjet = projet.getNomProjet();
		String nomEquipe = projet.getNomEquipe();
		List<Employe> employes = projet.getEmployes();
		ProjetDto dto = new ProjetDto();
		dto.setNomProjet(nomProjet);
		dto.setNomEquipe(nomEquipe);
		dto.setEmployes(employes);
		return dto;
	}
	
	public List<Projet> convertListToClass(List<ProjetDto> dtos) {
		List<Projet> projets = new ArrayList<Projet>();
		for (ProjetDto dto : dtos) {
			Projet contrat = convertToClass(dto);
			projets.add(contrat);
		}
		return projets;
	}

	public List<ProjetDto> convertListToDto(List<Projet> projets) {
		List<ProjetDto> dtos = new ArrayList<ProjetDto>();
		for (Projet projet : projets) {
			ProjetDto dto = convertToDto(projet);
			dtos.add(dto);
		}
		return dtos;
	}

}
