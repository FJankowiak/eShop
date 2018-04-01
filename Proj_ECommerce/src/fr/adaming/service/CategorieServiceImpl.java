package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.dao.ICategorieDao;
import fr.adaming.model.Admin;
import fr.adaming.model.Categorie;

@Stateful
public class CategorieServiceImpl implements ICategorieService {

	// TRANSFORMATION ASSOCIATION UML JAVA

	@EJB
	private ICategorieDao catDao;

	@Override
	public List<Categorie> getlisteCategorie(Admin admin) {

		return catDao.getlisteCategorie(admin);
	}

	@Override
	public Categorie addCategorie(Categorie cat) {

		return catDao.addCategorie(cat);
	}

	@Override
	public int updateCategorie(Categorie cat) {

		return catDao.updateCategorie(cat);

	}

	@Override
	public int deleteCategorie(Categorie cat) {
		
		return 0;
	}

}
