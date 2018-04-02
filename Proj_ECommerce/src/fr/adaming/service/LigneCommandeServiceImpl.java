package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.dao.ILigneCommandeDao;
import fr.adaming.dao.IProduitDao;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Produit;

@Stateful
public class LigneCommandeServiceImpl implements ILigneCommandeService{
	// Association UML en java
	@EJB
	private ILigneCommandeDao ligneCommandeDao;
	@EJB
	private IProduitDao prodService;


	@Override
	public int ajouterLC(LigneCommande lc, Long id_prod) {
		Produit produit = prodService.rechercherProduit(id_prod);
		
		if(produit != null){
			lc.setProduit(produit);
			System.out.println("Je suis dans lignecommandeService");
			System.out.println(produit);
			
			lc.setPrix(produit.getPrix() * lc.getQuantite());
			
			System.out.println(lc);
			
			LigneCommande lc2 = ligneCommandeDao.isExist(lc);
			
			if(lc2 == null){
				return ligneCommandeDao.ajouterLC(lc);
			} else {
				// mettre à joue plutôt que d'avoir un doublon
				return this.modifierLC(lc);
			}
		}
		return 0;
	}

	@Override
	public int supprimerLC(LigneCommande lc) {
		return ligneCommandeDao.supprimerLC(lc);
	}

	@Override
	public int modifierLC(LigneCommande lc) {
		return ligneCommandeDao.modifierLC(lc);
	}

	@Override
	public List<LigneCommande> getLigneCommande() {
		return ligneCommandeDao.getLigneCommande();
	}

}
