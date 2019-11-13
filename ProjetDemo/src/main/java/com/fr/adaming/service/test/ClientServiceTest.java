package com.fr.adaming.service.test;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fr.adaming.dao.ClientDao;
import com.fr.adaming.entity.Client;
import com.fr.adaming.service.ClientService;

@Component
public class ClientServiceTest {

	@Autowired
	private ClientService service;

	@Autowired
	private ClientDao dao;

	private Client clientNestle = new Client("nom", "prenom", "emailChocapic", "domaine", "nomRepresentant",
			"nomEntreprise");

	public void testSaveSimpleClient_shouldPrintSuccess() {

		Client client = new Client("nom", "prenom", "email", "domaine", "nomRepresentant", "nomEntreprise");

		Client clientApresInsertion = service.save(client);

		// Vérifier le résultat
		if (clientApresInsertion != null) {
			// SUCCESS
			System.out.println("TEST [SUCCESS] save Client");
		} else {
			// FAIL
			System.out.println("TEST [   FAIL] save Client");
		}

	}

	public void testSaveExistingClient_shouldReturnNull() {
		// Prépare les inputs
		Client existingClient = dao.findById(1L).get();

		// invoque la méthode
		Client c = service.save(existingClient);

		// vérifier le résultat
		if (c == null) {
			System.out.println("TEST [SUCCESS] saving existing Client");
		} else {
			System.out.println("TEST [FAIL] saving existing Client");
		}

	}

	public void testUpdate_modificationValide() {

		Client client = new Client(55L, "nom", "prenom", "email2", "domaine", "nomRepresentant", "nomEntreprise");
		client = service.save(client);

		client.setNom("nom2");

		// Client client2 = new Client(55L,"nom2", "prenom2", "email2", "domaine2",
		// "nomRepresentant2", "nomEntreprise2");

		if (service.updateClient(client)) {
			System.out.println("TEST [MOFICATION] SUCCESS");
		} else {
			System.out.println("TEST [MOFICATION] FAIL");
		}

	}

	public void testUpdate_modifierClientQuiNexistePas() {

		Client client = new Client();

		client.setId(56712345689562L);

		if (!service.updateClient(client)) {
			System.out.println("TEST [MOFICATION] SUCCESS");
		} else {
			System.out.println("TEST [MOFICATION] FAIL");
		}

	}

	public void testDelete_ifClientExist() {
		service.save(clientNestle);

		clientNestle = service.deleteClient(clientNestle);
		
		Client clientSupprime = dao.findById(clientNestle.getId()).get();

		if (clientSupprime.isDeleted()) {
			System.out.println("TEST [SUPPRESSION] SUCCESS");
		} else {
			System.out.println("TEST [SUPPRESSION] FAIL");
		}

	}

	public void testDelete_ifClientNotExist() {

		service.deleteClient(new Client(54545454545454L, "", "", "@@@@", "", "", ""));

		Client clientSupprime = dao.findById(54545454545454L).get();

		if (clientSupprime.isDeleted()) {
			System.out.println("TEST [SUPPRESSION] SUCCESS");
		} else {
			System.out.println("TEST [SUPPRESSION] FAIL");
		}

	}

	@PostConstruct
	public void init() {
		testSaveSimpleClient_shouldPrintSuccess();
		testSaveExistingClient_shouldReturnNull();
		testUpdate_modificationValide();
		testUpdate_modifierClientQuiNexistePas();
		testDelete_ifClientExist();
	}

}
