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

import fr.adaming.model.Admin;
import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
import fr.adaming.service.IProduitService;

@ManagedBean(name = "prMB")
@RequestScoped

public class ProduitManagedBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	IProduitService produitService;

	// DECLARATION DES ATTRIBUTS DU ENVOYER A LA PAGE
	

	private Produit produit;
	private Admin admin;
	private Categorie cat;
	HttpSession maSession;

	// CONSTRUCTEUR VIDE
	public ProduitManagedBean() {
		this.produit = new Produit();
		this.admin=new Admin();

	}

	// POUR QUE CETTE METHODE S'EXECUTE APRES L'INSTANCIATION DU MB

	@PostConstruct
	public void init() {

		// RECUPERER LA SESSION 

		this.maSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	

	}

	

	// GETTERS ET SETTERS
	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	

	public Categorie getCat() {
		return cat;
	}

	public void setCat(Categorie cat) {
		this.cat = cat;
	}
	
	
	
	// METHODES

	
	
	//AFFICHER LA LISTE DES PRODUITS
	

	public Produit afficheListProd(){
		
		return produit;
	}
	
	
	//AJOUTER UN PRODUIT
	


	public String ajouterProd(){
		
		//APPEL DE LA METHODE AJOUTER
		
		Produit prodOut=produitService.addProduit(produit,admin);
		
		if(prodOut.getId()!=0){
			
			//RECUPERER LA NOUVELLE LISTE DE PRODUIT
			
			List<Produit> listeprod=produitService.getlisteProduit();
			
			//METTRE A JOUR LA LISTE
			
			 maSession.setAttribute("listeProduits", listeprod);
			 
			 
			 return "listesAdmin";
			
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("L'ajout du produit a échoué"));
			return"ajoutProd";
		}
	}
	
	
	

}
