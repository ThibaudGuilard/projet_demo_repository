package com.fr.adaming.controller.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fr.adaming.entity.Societe;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ClientDto {

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
	private String domaine;
	@NotBlank
	@NotNull
	@NotEmpty
	private String nomRepresentant;
	@NotBlank
	@NotNull
	@NotEmpty
	private String nomEntreprise;
	

}
