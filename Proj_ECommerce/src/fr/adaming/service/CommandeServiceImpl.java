package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.dao.ICommandeDao;
import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.LigneCommande;

@Stateful
public class CommandeServiceImpl implements ICommandeService {
	// Association UML en java
	@EJB
	private ICommandeDao commandeDao;

	@Override
	public Commande finaliserCommande(List<LigneCommande> liste, Client cl) {
		return commandeDao.finaliserCommande(liste, cl);
	}

}
