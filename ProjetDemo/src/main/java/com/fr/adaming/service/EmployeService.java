package com.fr.adaming.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.fr.adaming.dao.EmployeDao;
import com.fr.adaming.entity.Employe;

@Service
public class EmployeService {
	
	@Autowired
	private EmployeDao dao;
	
	/**Saves a given client in the database
	 * @param employe - the given entity
	 * @return client if the given client didn't exist in the database - else, returns null
	 */
	public Employe save(Employe employe) {
		
		// Vérifier si l'employé existe dans la BD (email)
//		Client c = dao.findByEmail(client.getEmail());
		
		Employe c = new Employe();
		c.setEmail(employe.getEmail());
		
		
		if(dao.exists(Example.of(c))) {
			//L'employé existe dans la BD (FAIL)
			return null;
		}else {
			//Le client n'existe pas (SUCCESS) : enregistrer le client dans la BD et retourner le client
			employe.setDateInsertion(LocalDateTime.now());
			return dao.save(employe);
		}
		
	}
	
	/** Finds all employes in database
	 * @return List of employes - in case no employes has been inserted, it returns an empty list
	 */
	public List<Employe> findAll(){
		return dao.findAll();
	}
	
	/**Updates the values of a given employe
	 * @param employe - the given entity
	 * @return true if the given employe has been modified - else, returns false
	 */
	public boolean updateEmploye(Employe employe) {
		
		// Chercher client par id
		if(dao.existsById(employe.getId())) {
			employe.setDateModification(LocalDateTime.now());
			dao.save(employe);
			return true;
		}else {
			System.out.println("DEBUG Le employe à modifier n'existe pas ");
			return false;
		}
	}
	
	/**Modifies attribute "deleted" from given employe in database
	 * @param employe
	 * @return employe - the given employe
	 */
	public Employe deleteEmploye(Employe employe) {
		// Changer la valeur de l'attribut "deleted"
		employe.setDateSuppression(LocalDateTime.now());
		employe.setDeleted(true);
		return dao.save(employe);
	}
	
}
