package com.fr.adaming.controller.dto.converter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fr.adaming.controller.dto.ContratDto;
import com.fr.adaming.entity.Contrat;
import com.fr.adaming.enumeration.MethodologieType;

public class ContratConverter {

	public Contrat convertToClass(ContratDto dto) {
		MethodologieType methodologie = dto.getMethodologie();
		LocalDate date = dto.getDate();
		Contrat contrat = new Contrat(methodologie, date);
		return contrat;
	}

	public ContratDto convertToDto(Contrat contrat) {

		MethodologieType methodologie = contrat.getMethodologie();
		LocalDate date = contrat.getDate();
		ContratDto dto = new ContratDto();
		dto.setMethodologie(methodologie);
		dto.setDate(date);
		return dto;
	}
	
	public List<Contrat> convertListToClass(List<ContratDto> dtos) {
		List<Contrat> contrats = new ArrayList<Contrat>();
		for (ContratDto dto : dtos) {
			Contrat contrat = convertToClass(dto);
			contrats.add(contrat);
		}
		return contrats;
	}

	public List<ContratDto> convertListToDto(List<Contrat> contrats) {
		List<ContratDto> dtos = new ArrayList<ContratDto>();
		for (Contrat contrat : contrats) {
			ContratDto dto = convertToDto(contrat);
			dtos.add(dto);
		}
		return dtos;
	}
}
