package fr.adaming.service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Admin;
import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

@Local
public interface IAdminService {
	public Admin isExist(Admin a);
}
