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
	
	Date dt = new Date();

	java.text.SimpleDateFormat sdf = 
	     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");

	String currentTime = sdf.format(dt);
	
	
	@Override
	public Commande finaliserCommande(List<LigneCommande> liste, Client cl) {
		Commande commande = new Commande(); 
		commande.setDateCommande(dt); 
		commande.setLigneCommandeListe(liste);
		commande.setClient(cl);
		
		em.persist(commande);
		
		return commande;
	}
	
	
}
