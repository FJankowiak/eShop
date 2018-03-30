package fr.adaming.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.LigneCommande;

@Stateless
public class CommandeDaoImpl implements ICommandeDao {
	// Injection de dépendance, pour stocker les valeurs dans cet attribut
	@PersistenceContext(unitName = "PU") 
	private EntityManager em;
	Date lol;
	
	@Override
	public Commande finaliserCommande(List<LigneCommande> liste, Client cl) {
		// TODO Ajouter la date actuelle
		Commande commande = new Commande(); // 
		commande.setLigneCommandeListe(liste);
		commande.setClient(cl);
		
		em.persist(commande);
		
		return null;
	}
	
	
}
