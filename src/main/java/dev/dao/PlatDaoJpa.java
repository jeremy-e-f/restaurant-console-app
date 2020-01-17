package dev.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import dev.entite.Plat;

@Repository
public class PlatDaoJpa implements IPlatDao{

	// Injecter une instance d'EntityManager
	@PersistenceContext private EntityManager em;
	
	@Override
	public List<Plat> listerPlats() {
		TypedQuery<Plat> query = em.createQuery("select pl from Plat pl", Plat.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void ajouterPlat(String nomPlat, Integer prixPlat) {
		Plat plat= new Plat(nomPlat, prixPlat);
		em.persist(plat);
		
	}

}
