package fr.adaming.service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Admin;
import fr.adaming.model.Categorie;


@Local
public interface ICategorieService {
	
	public List<Categorie> getlisteCategorie();
	
	public Categorie addCategorie(Categorie cat);
	
	public int updateCategorie(Categorie cat);
	
	public int deleteCategorie(Categorie cat);

}
