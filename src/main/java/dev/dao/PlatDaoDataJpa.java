package dev.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dev.entite.Plat;
import dev.repository.PlatRepository;

@Repository
public class PlatDaoDataJpa implements IPlatDao{

	// Injecter une instance d'EntityManager
	@Autowired PlatRepository platRepo;
	
	@Override
	public List<Plat> listerPlats() {
		return platRepo.findAll();
	}

	@Override
	public void ajouterPlat(String nomPlat, Integer prixPlat) {
		Plat plat= new Plat(nomPlat, prixPlat);
		platRepo.save(plat);
		
	}

}
