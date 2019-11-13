package com.fr.adaming.controller.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fr.adaming.entity.Employe;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProjetDto {
	private String nomProjet;
	private String nomEquipe;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "projet_employe", joinColumns = @JoinColumn(name = "id_projet" ), inverseJoinColumns = @JoinColumn(name = "id_employe"))
	private List<Employe> employes;

}
