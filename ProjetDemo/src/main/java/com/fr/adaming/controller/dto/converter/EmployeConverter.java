package com.fr.adaming.controller.dto.converter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fr.adaming.controller.dto.EmployeDto;
import com.fr.adaming.entity.Employe;
import com.fr.adaming.entity.Societe;
import com.fr.adaming.enumeration.FonctionType;

public class EmployeConverter {

	public Employe convertToClass (EmployeDto dto) {
		String nom = dto.getNom();
		String prenom = dto.getPrenom();
		String email = dto.getEmail();
		Societe societe = dto.getSociete();
		String pwd = dto.getPwd();
		double salaire = dto.getSalaire();
		FonctionType fonction = dto.getFonction();
		LocalDate dateRecrutement = dto.getDateRecrutement();
		Employe employe = new Employe(nom, prenom, email, societe, pwd, salaire, fonction, dateRecrutement);
		return employe;
	}

	public EmployeDto convertToDto(Employe employe) {
		String nom = employe.getNom();
		String prenom = employe.getPrenom();
		String email = employe.getEmail();
		Societe societe = employe.getSociete();
		String pwd = employe.getPwd();
		double salaire = employe.getSalaire();
		FonctionType fonction = employe.getFonction();
		LocalDate dateRecrutement = employe.getDateRecrutement();
		EmployeDto dto = new EmployeDto();
		dto.setNom(nom);
		dto.setPrenom(prenom);
		dto.setEmail(email);
		dto.setSociete(societe);
		dto.setPwd(pwd);
		dto.setSalaire(salaire);
		dto.setFonction(fonction);
		dto.setDateRecrutement(dateRecrutement);
		return dto;
	}

	public List<Employe> convertListToClass(List<EmployeDto> dtos) {
		List<Employe> employes = new ArrayList<Employe>();
		for (EmployeDto dto : dtos) {
			Employe employe = convertToClass(dto);
			employes.add(employe);
		}
		return employes;
	}

	public List<EmployeDto> convertListToDto(List<Employe> employes) {
		List<EmployeDto> dtos = new ArrayList<EmployeDto>();
		for (Employe employe : employes) {
			EmployeDto dto = convertToDto(employe);
			dtos.add(dto);
		}
		return dtos;
	}

}
