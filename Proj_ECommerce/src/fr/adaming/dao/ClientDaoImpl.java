package fr.adaming.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.Client;
import fr.adaming.model.Client;


@Stateless
public class ClientDaoImpl implements IClientDao {
	// Injection de dépendance, pour stocker les valeurs dans cet attribut
	@PersistenceContext(unitName = "PU") 
	private EntityManager em;

	@Override
	public Client addClient(Client cl) {
		em.persist(cl);
		
		return cl;
	}
}
