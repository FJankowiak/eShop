package fr.adaming.dao;

import java.text.DecimalFormat;
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

	DecimalFormat df = new DecimalFormat("#.###");

	@Override
	public int ajouterLC(LigneCommande lc) {
		lc.setPrix(Double.valueOf(df.format(lc.getPrix())));

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
		double prix = Double.valueOf(df.format(lc.getPrix()));

		// Requete JPQL
		String req1 = "UPDATE LigneCommande lc SET lc.quantite=:pQuantite, lc.prix=:pPrix WHERE lc.produit.id=:pId";

		// CREER UN OBJET QUERY POUR ENVOYER LA REQUETE JQL
		Query query1 = em.createQuery(req1);

		System.out.println("id " + id_prod + "quantit� " + qt);

		// Passage des parametres
		query1.setParameter("pQuantite", qt);
		query1.setParameter("pId", id_prod);
		query1.setParameter("pPrix", prix);

		System.out.println();

		// Envoyer la requete et r�cup�rer le r�sultat
		int verif = query1.executeUpdate();

		return verif;
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
		// JPQL parce qu'on est dans JPA (persistence) - AS n'est pas
		// obligatoire
		Long id_pr = lc.getProduit().getId();

		System.out.println(id_pr);

		String req = "SELECT lc from LigneCommande lc WHERE lc.produit.id=:pId";
		System.out.println(req);

		// Cr�er un objet de type query pour envoyer la requ�te jpql
		Query query = em.createQuery(req);

		System.out.println(lc);
		// Passage des params
		query.setParameter("pId", id_pr);
		System.out.println("Pas ici");

		try {
			LigneCommande lcOut = (LigneCommande) query.getSingleResult();

			return lcOut;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public double getTotal() {
		String req = "SELECT SUM(prix) FROM lignes_commande";

//		Query query = em.createQuery(req);
		double somme = 31.62; //(double) query.getSingleResult();

//		somme = Double.valueOf(df.format(somme));

		return somme;
	}

	@Override
	public void viderLC() {
		Query query = em.createQuery("DELETE FROM LigneCommande");

		query.executeUpdate();

	}

}
