package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.codec.binary.Base64;

import fr.adaming.model.Admin;
import fr.adaming.model.Categorie;

@Stateless
public class CategorieDaoImpl implements ICategorieDao {

	@PersistenceContext(name = "PU")
	private EntityManager em;

	// RECUPERER LA LISTE DES CATEGORIE

	@Override
	public List<Categorie> getlisteCategorie() {

		// REQUETE JPQL

		String req = "SELECT cat FROM Categorie  AS cat";

		// CREER UN OBJET QUERY POUR ENVOYER LA REQUETE JPQL

		Query query = em.createQuery(req);

		// ENVOYER LA REQUETE ET RECUPERER LE RESULTAT DE LA LISTE
		return query.getResultList();
	}

	// AJOUTER UNE CATEGORIE
	
	@Override
	public Categorie addCategorie(Categorie cat) {

		cat.setImage("data:image/png;base64" + Base64.encodeBase64String(cat.getPhoto()));

		em.persist(cat);
		
		return cat;
	}

	// MODIFIE UNE CATEGORIE
	@Override
	public int updateCategorie(Categorie cat) {

		// REQUETE JPQL

		String req1 = "UPDATE Categorie cat SET cat.nomCategorie=:pNomCategorie, cat.photo=:pPhoto,  cat.description=:pDescription WHERE cat.id=:pCatId";

		// CREER UN OBJET QUERY POUR ENVOYER LA REQUETE JQL

		Query query1 = em.createQuery(req1);

		// PASSAGE DES PARAMS

		query1.setParameter("pNomCategorie", cat.getNomCategorie());
		query1.setParameter("pPhoto", cat.getPhoto());
		query1.setParameter("pDescription", cat.getDescription());
		query1.setParameter("pCatId", cat.getId());

		// ENVOYER LA REQUETE ET LA RECUPERER

		return query1.executeUpdate();
	}

	// SUPPRIMER UNE CATEGORIE

	@Override
	public int deleteCategorie(Categorie cat) {
		// creation de la requete :
		String req3 = "DELETE FROM Categorie WHERE cat.id=:pIdCat";

		// creation du query :
		Query query3 = em.createQuery(req3);

		// passage des parametres :
		query3.setParameter("pIdCat", cat.getId());

		// envoyer la requete et recuperer le resultat :
		return (int) query3.executeUpdate();
	}

}
