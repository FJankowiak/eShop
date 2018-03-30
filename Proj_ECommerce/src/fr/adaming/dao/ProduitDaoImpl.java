package fr.adaming.dao;

import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.Produit;


@Stateless
public class ProduitDaoImpl implements IProduitDao{
	
	
	@PersistenceContext(name="PU")
	private EntityManager em;
	
	//AJOUTER UN PRODUIT
	@Override
	public Produit addProduit(Produit prod) {
	
		em.persist(prod);
		
		return prod;
	}

	@Override
	public List<Produit> getlisteProduit() {
		
		//REQUETE JPQL
		
		String req="SELECT Produit prod FROM produits prod";
		
		//CREER UN OBJET QUERY POUR ENVOYER LA REQUETE JPQL
		
		Query query=em.createQuery(req);
		
		//ENVOYER LA REQUETE ET RECUPERER LE RESULTAT DE LA LISTE
		
		return query.getResultList();
	}
	
	
	// MODIFIER UN PRODUIT

	@Override
	public int updateProduit(Produit prod) {
		//REQUETE JPQL 
		String req1="SELECT Produit prod SET prod.designation=:pDesignation, prod.description=:pDescription, prod.prix=:pPrix,prod.quantite=:pQuantite, prod.selectionne=:pSelectionne, prod.photo=:pPhoto WHERE prod.id=:pProdId ";
		
		//CREER UN OBJET QUERY POUR ENVOYER LA REQUETE JPQL
		
		Query query1=em.createQuery(req1);
		
		//PASSAGE DES PARAMS
		
		query1.setParameter("pDesignation", prod.getDesignation());
		query1.setParameter("pDescription",prod.getDesignation());
		query1.setParameter("pPrix",prod.getPrix());
		query1.setParameter("pSelectionne",prod.isSelectionne());
		query1.setParameter("pPhoto",prod.getPhoto());
		query1.setParameter("pProdId", prod.getId());
		
		return query1.executeUpdate() ;
	}

	@Override
	public int deleteProduit(Produit prod) {
		Produit pdOut=em.find(Produit.class, prod.getId());
		
		em.remove(pdOut);
		
		em.find(Produit.class,prod.getId());

		return 0;
	}
	
	

}
