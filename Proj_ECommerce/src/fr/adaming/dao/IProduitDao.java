package fr.adaming.dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Admin;
import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

@Local
public interface IProduitDao {

	// AJOUTER UN PRODUIT

	public Produit addProduit(Produit prod);
	
	// CONSULTER TOUS LES  PRODUITS
	
	List<Produit> getlisteProduit(Admin admin);
	
	
	
	//MODIIFER UN PRODUIT
	
	public int updateProduit(Produit prod, Categorie cat);
	
	
	//SUPPRIMER UN PRODUIT
	
	public int deleteProduit(Produit prod);

	public int rechercherProduit(Produit id_prod);
}

//rechercher produit




