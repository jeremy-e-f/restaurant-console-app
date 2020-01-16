package dev.service;

import dev.dao.IPlatDao;
import dev.entite.Plat;
import dev.exception.PlatException;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PlatServiceVersion2 implements IPlatService {
	
    private IPlatDao dao;

    public PlatServiceVersion2(@Qualifier("platDaoMemoire") IPlatDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Plat> listerPlats() {
        return dao.listerPlats();
    }

    @Override
    public void ajouterPlat(String nomPlat, Integer prixPlat) {

        // règle métier

        if (nomPlat.length() <= 5) {
            throw new PlatException("un plat doit avoir un nom de plus de 5 caractères");
        }

        if (prixPlat <= 10000) {
            throw new PlatException("le prix d'un plat doit être supérieur à 10 €");
        }

        // persistance uniquement si les règles métiers sont respectées
        dao.ajouterPlat(nomPlat, prixPlat);
    }
}
