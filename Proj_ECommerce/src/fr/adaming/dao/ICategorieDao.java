package fr.adaming.dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Admin;
import fr.adaming.model.Categorie;

@Local
public interface ICategorieDao {
	
	
	// CONSULTER TOUS LES CATEGORIES
	public List<Categorie> getlisteCategorie();
	
	// AJOUTER UNE CATEGORIE
	
	public Categorie addCategorie(Categorie cat);
	
	// MODIFIER UNE CATEGORIE
	
	public int updateCategorie(Categorie cat);
	
	// SUPPRIMER UNE CATEGORIE
	
	public int deleteCategorie(Categorie cat);

}
