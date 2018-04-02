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

		if (lcTest == null) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int modifierLC(LigneCommande lc) {
		Long id_prod = lc.getProduit().getId();
		int qt = lc.getQuantite();

		// Requete JPQL
		String req1 = "UPDATE LigneCommande lc SET lc.quantite=:pQuantite WHERE lc.produit.id=:pId";

		// CREER UN OBJET QUERY POUR ENVOYER LA REQUETE JQL
		Query query1 = em.createQuery(req1);

		System.out.println("id " + id_prod + "quantité " + qt);

		// Passage des parametres
		query1.setParameter("pQuantite", qt);
		query1.setParameter("pId", id_prod);

		System.out.println();

		// Envoyer la requete et récupérer le résultat
		int verif = query1.executeUpdate();

		return verif;
	}

	@Override
	public List<LigneCommande> getLigneCommande() {
		// Requete JPQL
		String req = "SELECT lc FROM LigneCommande lc";

		// Creer le query pour envoyer la requete JPQL

		Query query = em.createQuery(req);

		// Envoyer la requete et récupérer la liste
		return query.getResultList();
	}

	@Override
	public LigneCommande isExist(LigneCommande lc) {
		// JPQL parce qu'on est dans JPA (persistence) - AS n'est pas
		// obligatoire
		int id_pr = (int) (long) lc.getProduit().getId();

		System.out.println(id_pr);

		String req = "SELECT lc from LigneCommande lc WHERE lc.produit.id=:pId";
		System.out.println(req);

		// Créer un objet de type query pour envoyer la requête jpql
		Query query = em.createQuery(req);

		System.out.println(lc);
		// Passage des params
		query.setParameter("pId", id_pr);

		try {
			LigneCommande lcOut = (LigneCommande) query.getSingleResult();

			return lcOut;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
