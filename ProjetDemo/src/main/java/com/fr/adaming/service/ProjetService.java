package com.fr.adaming.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.fr.adaming.dao.ProjetDao;
import com.fr.adaming.entity.Projet;

@Service
public class ProjetService {

	@Autowired
	ProjetDao dao;

	public Projet save(Projet projet) {

		Projet c = new Projet();
		c.setId(projet.getId());

		if (dao.exists(Example.of(c))) {
			// Le projet existe dans la BD (FAIL)
			return null;
		} else {
			// Le client n'existe pas (SUCCESS) : enregistrer le projet dans la BD et
			// retourner le projet
			projet.setDateInsertion(LocalDateTime.now());
			return dao.save(projet);
		}

	}

	/**
	 * Finds all projet in database
	 * 
	 * @return List of projet - in case no projet has been inserted, it returns an
	 *         empty list
	 */
	public List<Projet> findAll() {
		return dao.findAll();
	}

	/**
	 * Updates the values of a given projet
	 * 
	 * @param projet - the given entity
	 * @return true if the given projet has been modified - else, returns false
	 */
	public boolean updateProjet(Projet projet) {

		// Chercher client par id
		if (dao.existsById(projet.getId())) {
			projet.setDateModification(LocalDateTime.now());
			dao.save(projet);
			return true;
		} else {
			System.out.println("DEBUG Le projet à modifier n'existe pas ");
			return false;
		}
	}

	/**
	 * Modifies attribute "deleted" from given projet in database
	 * 
	 * @param projet
	 * @return projet - the given projet
	 */
	public Projet deleteProjet(Projet projet) {
		// Changer la valeur de l'attribut "deleted"
		projet.setDateSuppression(LocalDateTime.now());
		projet.setDeleted(true);
		return dao.save(projet);
	}

}
