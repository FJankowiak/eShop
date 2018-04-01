package fr.adaming.service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Admin;
import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

@Local
public interface IProduitService {
	

	// AJOUTER UN PRODUIT

	public Produit addProduit(Produit prod,Admin admin);
	
	// CONSULTER TOUS LES  PRODUITS
	
	List<Produit> getlisteProduit(Admin admin);
	
	
	
	//MODIIFER UN PRODUIT
	
	public int updateProduit(Produit prod,Admin admin,Categorie cat);
	
	
	//SUPPRIMER UN PRODUIT
	
	public int deleteProduit(Produit prod,Admin admin);


}
