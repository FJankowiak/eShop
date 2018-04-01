package fr.adaming.managedBeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.adaming.model.LigneCommande;
import fr.adaming.model.Produit;
import fr.adaming.service.ILigneCommandeService;
import fr.adaming.service.IProduitService;

public class LigneCommandeManagedBean implements Serializable {
	@EJB 
	ILigneCommandeService lcService;
	@EJB
	IProduitService prodService;
	
	//Attributs
	private LigneCommande lCommande;
	private Produit produit;
	HttpSession maSession;
	private int id_prod;
	
	public LigneCommandeManagedBean() {
		this.lCommande = new LigneCommande();
	}
	
	// POUR QUE CETTE METHODE S'EXECUTE APRES L'INSTANCIATION DU MB
	
	// Getters et setters
	@PostConstruct
	public void init() {
		// RECUPERER LA SESSION 
		this.maSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	}

	public LigneCommande getlCommande() {
		return lCommande;
	}

	public void setlCommande(LigneCommande lCommande) {
		this.lCommande = lCommande;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	
	public int getId_prod() {
		return id_prod;
	}

	public void setId_prod(int id_prod) {
		this.id_prod = id_prod;
	}

	// Méthodes
	public String ajouterLC(){
		int verif = lcService.ajouterLC(lCommande, id_prod);
		
		if(verif != 0){
			// TODO Ramener à la page de selection des produits quel que soit le cas
			
			
			return "Panier";
		} else {
			return "ajoutPanierTemp";
		}
		
		
	}
	
	
	public String supprimerLC(){
		return null;
		
	}
	
	
	public String modifierLC(){
		return null;
		
	}
	
	
	
}
