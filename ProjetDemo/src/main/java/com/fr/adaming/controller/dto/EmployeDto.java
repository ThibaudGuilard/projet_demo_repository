package com.fr.adaming.controller.dto;

import java.time.LocalDate;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fr.adaming.entity.Societe;
import com.fr.adaming.enumeration.FonctionType;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EmployeDto {
	@NotBlank
	@NotNull
	@NotEmpty
	private String nom;
	@NotBlank
	@NotNull
	@NotEmpty
	private String prenom;
	@NotBlank
	@NotNull
	@NotEmpty
	private String email;
	@NotBlank
	@NotNull
	@NotEmpty
	private Societe societe;
	@NotBlank
	@NotNull
	@NotEmpty
	private String pwd;
	@NotBlank
	@NotNull
	@NotEmpty
	private double salaire;
	@Enumerated
	@NotBlank
	@NotNull
	@NotEmpty
	private FonctionType fonction;
	@NotBlank
	@NotNull
	@NotEmpty
	private LocalDate dateRecrutement;

}
