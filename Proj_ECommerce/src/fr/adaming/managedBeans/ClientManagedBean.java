package fr.adaming.managedBeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.service.IClientService;
import fr.adaming.service.ICommandeService;

@ManagedBean(name = "clMB")
@RequestScoped
public class ClientManagedBean implements Serializable{
	// Transformation de l'association UML en java
	@EJB
	IClientService clientService;
//	@EJB
//	ICommandeService commandeService;
	
	
	// Attributs
	HttpSession maSession;
	private Client client;
	
	// Attributs h�rit�s
	private Commande commande;
	
	
	
//	@PostConstruct // pour que cette m�thode s'execute apr�s l'instanciation du ManagedBean
//	public void init(){
//		// Recuperer la session ouverte
//		this.maSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
////		maSession.setAttribute("listeProduits", produitService.getAllProduits());
////		maSession.setAttribute("listeCategories", categorieService.getAllCategories());
//		
//	}

	public ClientManagedBean() {
		this.client = new Client();
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	
	// M�thodes
	public void creerClient(){
		
	}

}
