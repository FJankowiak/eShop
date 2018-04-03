package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.codec.binary.Base64;

import fr.adaming.model.Admin;
import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

@Stateless
public class ProduitDaoImpl implements IProduitDao {

	@PersistenceContext(name = "PU")
	private EntityManager em;

	@Override
	public List<Produit> getlisteProduit() {

		// REQUETE JPQL

		String req = "SELECT prod FROM Produit  AS prod";

		// CREER UN OBJET QUERY POUR ENVOYER LA REQUETE JPQL

		Query query = em.createQuery(req);

		List<Produit> listeOut= query.getResultList();
		
		for(Produit prod : listeOut){
			prod.setImage("data:image/png;base64" + Base64.encodeBase64String(prod.getPhoto()));
		}
		
		return listeOut;
	}

	// AJOUTER UN PRODUIT
	@Override
	public Produit addProduit(Produit prod) {
		
		


		em.persist(prod);
		return prod;

	}

	// MODIFIER UN PRODUIT

	@Override
	public int updateProduit(Produit prod) {
		// REQUETE JPQL
		String req1 = "SELECT Produit prod SET prod.designation=:pDesignation, prod.description=:pDescription, prod.prix=:pPrix,prod.quantite=:pQuantite, prod.selectionne=:pSelectionne, prod.photo=:pPhoto "
				+ "WHERE prod.id=:pProdId ";

		// CREER UN OBJET QUERY POUR ENVOYER LA REQUETE JPQL

		Query query1 = em.createQuery(req1);

		// PASSAGE DES PARAMS

		query1.setParameter("pDesignation", prod.getDesignation());
		query1.setParameter("pDescription", prod.getDesignation());
		query1.setParameter("pPrix", prod.getPrix());
		query1.setParameter("pSelectionne", prod.isSelectionne());
		query1.setParameter("pPhoto", prod.getPhoto());
		query1.setParameter("pProdId", prod.getId());

		return query1.executeUpdate();
	}

	@Override
	public int deleteProduit(Produit prod) {
		// creation de la requete :
		String req3 = "DELETE FROM Produit WHERE prod.id=:pProdId";

		// creation du query :
		Query query3 = em.createQuery(req3);

		// passage des parametres :
		query3.setParameter("pProdId", prod.getId());

		// envoyer la requete et recuperer le resultat :
		return (int) query3.executeUpdate();

	}

	@Override
	public Produit rechercherProduit(Long id) {
		Produit prod = em.find(Produit.class, id);

		return prod;

	}

}
