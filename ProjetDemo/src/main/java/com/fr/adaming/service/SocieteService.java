package com.fr.adaming.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.fr.adaming.entity.Societe;

@Service
public class SocieteService {
	
	@Autowired
	SocieteDao dao;

	public Societe save(Societe contrat) {

		Societe c = new Societe();
		c.setId(contrat.getId());

		if (dao.exists(Example.of(c))) {
			// L'employé existe dans la BD (FAIL)
			return null;
		} else {
			// Le contrat n'existe pas (SUCCESS) : enregistrer le contrat dans la BD et
			// retourner le contrat
			contrat.setDateInsertion(LocalDateTime.now());
			return dao.save(contrat);
		}

	}

	/**
	 * Finds all contrat in database
	 * 
	 * @return List of contrat - in case no contrat has been inserted, it returns an
	 *         empty list
	 */
	public List<Societe> findAll() {
		return dao.findAll();
	}

	/**
	 * Updates the values of a given contrat
	 * 
	 * @param contrat - the given entity
	 * @return true if the given contrat has been modified - else, returns false
	 */
	public boolean updateSociete(Societe contrat) {

		// Chercher contrat par id
		if (dao.existsById(contrat.getId())) {
			contrat.setDateModification(LocalDateTime.now());
			dao.save(contrat);
			return true;
		} else {
			System.out.println("DEBUG Le contrat à modifier n'existe pas ");
			return false;
		}
	}

	/**
	 * Modifies attribute "deleted" from given contrat in database
	 * 
	 * @param contrat
	 * @return contrat - the given contrat
	 */
	public Societe deleteSociete(Societe contrat) {
		// Changer la valeur de l'attribut "deleted"
		contrat.setDateSuppression(LocalDateTime.now());
		contrat.setDeleted(true);
		return dao.save(contrat);
	}

}
