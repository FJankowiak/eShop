package fr.adaming.service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.LigneCommande;

@Local
public interface ILigneCommandeService {
	public int ajouterLC(LigneCommande lc, int id_prod);
	
	public int supprimerLC(LigneCommande lc);
	
	public int modifierLC(LigneCommande lc);
	
	public List<LigneCommande> getLigneCommande();
	

}
