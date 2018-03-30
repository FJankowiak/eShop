package fr.adaming.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.Admin;


@Stateless
public class AdminDaoImpl implements IAdminDao {
	// Injection de dépendance, pour stocker les valeurs dans cet attribut
	@PersistenceContext(unitName = "PU") 
	private EntityManager em;
	

	@Override
	public Admin isExist(Admin a) {
		String req = "SELECT ad FROM Admin ad WHERE ad.mail=:pMail AND ad.mdp=:pMdp";
		
		// créer la requete jpql
		Query query = em.createQuery(req);
		
		// Passage des params
		query.setParameter("pMail", a.getMail());
		query.setParameter("pMdp", a.getMdp());
		
		return (Admin) query.getSingleResult();
	}
	
}