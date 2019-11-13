package com.fr.adaming.controller.dto;

import java.time.LocalDate;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fr.adaming.enumeration.MethodologieType;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ContratDto {

	@NotBlank
	@NotEmpty
	@NotNull
	private Long id;
	@Enumerated
	@NotBlank
	@NotEmpty
	@NotNull
	private MethodologieType methodologie;
	@NotBlank
	@NotEmpty
	@NotNull
	private LocalDate date;
}
