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
	public Produit addProduit(Produit prod,Admin admin) {
		prod.setAdmin(admin);
		
		
		return prodDao.addProduit(prod);
	}
	
	// CONSULTER TOUS LES  PRODUITS
	@Override
	public List<Produit> getlisteProduit(Admin admin) {
		
		return prodDao.getlisteProduit(admin);
	}
	
	//MODIIFER UN PRODUIT
	@Override
	public int updateProduit(Produit prod,Admin admin,Categorie cat) {
		prod.setAdmin(admin);
		
	
		return prodDao.updateProduit(prod,cat);
	}

	//SUPPRIMER UN PRODUIT
	@Override
	public int deleteProduit(Produit prod,Admin admin) {
		prod.setAdmin(admin);
		return 0;
	}

}
