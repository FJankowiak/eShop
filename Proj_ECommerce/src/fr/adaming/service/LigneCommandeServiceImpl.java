package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.dao.ILigneCommandeDao;
import fr.adaming.dao.IProduitDao;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Produit;

@Stateful
public class LigneCommandeServiceImpl implements ILigneCommandeService {
	// Association UML en java
	@EJB
	private ILigneCommandeDao ligneCommandeDao;
	@EJB
	private IProduitDao prodService;

	@Override
	public int updateLC(LigneCommande lc, Long id_prod) {
		Produit produit = prodService.rechercherProduit(id_prod);

		if (produit != null) {

			lc.setProduit(produit);
			System.out.println("Je suis dans lignecommandeService");
			System.out.println(produit);

			LigneCommande lc2 = ligneCommandeDao.isExist(lc);

			if (lc2 != null) {
				// Mettre à jour plutot que d'avoir un doublon
				if (lc.getQuantite() == 0) {
					System.out.println("Suppression");
					return ligneCommandeDao.supprimerLC(lc2);
				} else {
					System.out.println("Mise à jour");
					lc.setPrix(produit.getPrix() * lc.getQuantite());

					System.out.println(lc.getPrix());

					return ligneCommandeDao.modifierLC(lc);
				}
			} else if (lc.getQuantite() != 0){
				lc.setPrix(produit.getPrix() * lc.getQuantite());
				return ligneCommandeDao.ajouterLC(lc);
			} 

		}
		return 0;
	}
	@Override
	public List<LigneCommande> getLigneCommande() {
		return ligneCommandeDao.getLigneCommande();
	}
	@Override
	public double getTotal() {
		return ligneCommandeDao.getTotal();
	}
	@Override
	public void viderLC() {
		ligneCommandeDao.viderLC();		
	}
	@Override
	public int deleteLC(LigneCommande lc) {
		return ligneCommandeDao.supprimerLC(lc);
	}

}
