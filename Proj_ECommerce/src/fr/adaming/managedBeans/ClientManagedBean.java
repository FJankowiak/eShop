package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.LigneCommande;
import fr.adaming.service.IClientService;
import fr.adaming.service.ICommandeService;
import fr.adaming.service.ILigneCommandeService;

@ManagedBean(name = "clMB")
@RequestScoped
public class ClientManagedBean implements Serializable{
	// Transformation de l'association UML en java
	@EJB
	IClientService clientService;
	@EJB
	ICommandeService commandeService;
	@EJB
	ILigneCommandeService lcService;
	
	
	// Attributs
	HttpSession maSession;
	private Client client;
	
	// Attributs h�rit�s
	private Commande commande;
	
	
	
	@PostConstruct // pour que cette m�thode s'execute apr�s l'instanciation du ManagedBean
	public void init(){
//		// Recuperer la session ouverte
		this.maSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
//		
	}

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
	public String creerClient(){
		Client clAjout = clientService.addClient(this.client);
		
		if(clAjout.getIdClient() != 0){
			
			
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("clientCommande", clAjout);
			List<LigneCommande> liste = (List<LigneCommande>) maSession.getAttribute("panier");
			System.out.println(liste);
			this.commande = commandeService.finaliserCommande(liste, clAjout);
			
			// TODO inserer la fonction PDF
//			commandeService.bilanPDF(commande, total);
			
			lcService.viderLC();
			
			return "commandeValidee";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Impossible d'ajouter le client"));

			return "ajoutClient";
		}
	}

}
