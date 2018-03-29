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
	public Client isExist(Client cl) {
		String req = "SELECT cl FROM Client cl WHERE cl.email=:pMail AND cl.mdp=:pMdp";
		
		// créer la requete jpql
		Query query = em.createQuery(req);
		
		// Passage des params
		query.setParameter("pMail", cl.getEmail());
		query.setParameter("pMdp", cl.getMdp());
		
		return (Client) query.getResultList();
	}
	
}
