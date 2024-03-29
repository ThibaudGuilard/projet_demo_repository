package com.fr.adaming.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fr.adaming.entity.Employe;

@Repository
public interface EmployeDao extends JpaRepository<Employe, Long> {

	public Employe findByEmail(String email);
}
