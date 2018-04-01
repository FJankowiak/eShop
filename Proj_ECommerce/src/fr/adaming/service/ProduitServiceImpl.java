package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.dao.IProduitDao;
import fr.adaming.model.Admin;
import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
@Stateful
public class ProduitServiceImpl implements IProduitService {

	
	//TRANSFORMATION ASSOCIATION UML JAVA
	
	@EJB
	private IProduitDao prodDao;
	
	
	@Override
	public Produit addProduit(Produit prod) {
		
		
		
		return prodDao.addProduit(prod);
	}
	
	// CONSULTER TOUS LES  PRODUITS
	@Override
	public List<Produit> getlisteProduit() {
		
		return prodDao.getlisteProduit();
	}
	
	//MODIIFER UN PRODUIT
	@Override
	public int updateProduit(Produit prod,Categorie cat) {
	
		
	
		return prodDao.updateProduit(prod,cat);
	}

	//SUPPRIMER UN PRODUIT
	@Override
	public int deleteProduit(Produit prod) {
		
		return 0;
	}

	@Override
	public Produit rechercherProduit(Long id_prod) {
		return prodDao.rechercherProduit(id_prod);
	}

}
