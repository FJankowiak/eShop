package fr.adaming.dao;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.Categorie;
import fr.adaming.model.LigneCommande;

@Stateless
public class LigneCommandeDaoImpl implements ILigneCommandeDao {
	@PersistenceContext(name = "PU")
	private EntityManager em;

	@Override
	public int ajouterLC(LigneCommande lc) {
		em.persist(lc);

		if (lc.getId_ligne() != 0) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int supprimerLC(LigneCommande lc) {
		
		LigneCommande lcOut = em.find(LigneCommande.class, lc.getId_ligne());

		em.remove(lcOut);

		LigneCommande lcTest = em.find(LigneCommande.class, lc.getId_ligne());
		
		if(lcTest == null){
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int modifierLC(LigneCommande lc) {
		//Requete JPQL
		String req1="UPDATE LigneCommande lc SET lc.quantite=:pQuantite";
		
		//CREER UN OBJET QUERY POUR ENVOYER LA REQUETE JQL
		Query query1=em.createQuery(req1);
		
		//Passage des parametres
		query1.setParameter("pQuantite",lc.getQuantite());
		
		//Envoyer la requete et r�cup�rer le r�sultat
		return query1.executeUpdate();
	}

	@Override
	public List<LigneCommande> getLigneCommande() {
		// Requete JPQL
		String req = "SELECT lc FROM LigneCommande lc";

		// Creer le query pour envoyer la requete JPQL

		Query query = em.createQuery(req);

		// Envoyer la requete et r�cup�rer la liste 
		return query.getResultList();
	}

	@Override
	public LigneCommande isExist(LigneCommande lc) {
		// JPQL parce qu'on est dans JPA (persistence) - AS n'est pas obligatoire
		String req = "SELECT lc from LigneCommande lc WHERE lc.getProduit.getId=:pId";
		
		// Cr�er un objet de type query pour envoyer la requ�te jpql
		Query query = em.createQuery(req);
		
		// Passage des params
		query.setParameter("pId", lc.getProduit().getId());
		
		// R�cup�rer l'agent 
		return (LigneCommande) query.getSingleResult();
	}

}