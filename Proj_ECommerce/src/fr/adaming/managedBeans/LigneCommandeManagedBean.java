package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.adaming.model.Categorie;
import fr.adaming.model.Client;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Produit;
import fr.adaming.service.ILigneCommandeService;
import fr.adaming.service.IProduitService;


@ManagedBean(name = "lcMB")
@RequestScoped
public class LigneCommandeManagedBean implements Serializable {
	@EJB 
	ILigneCommandeService lcService;
	@EJB
	IProduitService prodService;
//	@ManagedProperty(value="#{produit}")
	private Produit produit;
	
	
	//Attributs
	private LigneCommande lCommande;
//	private Produit produit;
	HttpSession maSession;
	private Long id_prod;
	private int id;
	
	public LigneCommandeManagedBean() {
		this.lCommande = new LigneCommande();
	}
	
	// POUR QUE CETTE METHODE S'EXECUTE APRES L'INSTANCIATION DU MB
	
	// Getters et setters
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
	
	public Long getId_prod() {
		return id_prod;
	}

	public void setId_prod(Long id_prod) {
		this.id_prod = id_prod;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// Méthodes
	@PostConstruct
	public void init() {
		// RECUPERER LA SESSION
		this.maSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		List<LigneCommande> lcListe = lcService.getLigneCommande();
		
		double total = lcService.getTotal();
		System.out.println(total);
				
		maSession.setAttribute("totalCommande", total);
		
		System.out.println(lcListe);
//		maSession.setAttribute("panier", lcListe);

		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("panier", lcListe);

	}
	

	
	public String updateLC(){
		System.out.println("Id " + id_prod + " quantité 0 " + lCommande.getQuantite());
		
		
		int verif = lcService.updateLC(lCommande, id_prod);
		
		if(verif != 0){
			List<LigneCommande> liste = lcService.getLigneCommande();
			this.maSession.setAttribute("panier", liste);
			
			return "panier";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erreur au cours de la modification du panier"));
			return "modifPanier";
		}
		
		
	}
	
//	
	public String supprimerLC(){
		lCommande.setQuantite(0);
		
		System.out.println(lCommande + " " + id_prod);
		
		
		int verif = lcService.updateLC(lCommande, id_prod);
		
		if(verif == 0){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erreur au cours de la modification du panier"));
		} else {
			List<LigneCommande> liste = lcService.getLigneCommande();
			this.maSession.setAttribute("panier", liste);
		}
		return "panier";

//		System.out.println("Modifier : le produit est là ?");
//		System.out.println(this.produit);
//		
//		
//		int verif = 0;
//		//int verif = lcService.modifierLC(lCommande, id_prod);
//		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Iciiiii à Naganoooooo"));
//
//		return null;		
	}
	
	
	
}
