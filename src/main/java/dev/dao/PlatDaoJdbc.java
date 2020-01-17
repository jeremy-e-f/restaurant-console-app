package dev.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dev.entite.Plat;

@Repository
public class PlatDaoJdbc implements IPlatDao{
	
	// Outil JdbcTemplate fourni par Spring JDBC
	private JdbcTemplate jdbcTemplate;
	
	public PlatDaoJdbc(DataSource datasource){
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Override
	public List<Plat> listerPlats() {
		String sql = "SELECT * FROM plat";
		List<Plat> listePlats= this.jdbcTemplate.query(sql, new PlatMapper());
		return listePlats;
	}

	@Override
	public void ajouterPlat(String nomPlat, Integer prixPlat) {
		String sql = "INSERT INTO Plat (nom, prixEnCentimesEuros) VALUES(?,?)";
		this.jdbcTemplate.update(sql, nomPlat, prixPlat);
	}

}
