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

import org.primefaces.model.UploadedFile;
import org.primefaces.model.UploadedFileWrapper;

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
	private UploadedFile uf;

	// CONSTRUCTEUR VIDE
	public ProduitManagedBean() {
		this.produit = new Produit();
		this.uf=new UploadedFileWrapper();

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

	
	public UploadedFile getUf() {
		return uf;
	}

	public void setUf(UploadedFile uf) {
		this.uf = uf;
	}
	// METHODES

	// AJOUTER UN PRODUIT

	public String ajouterProd() {
		
		

		// APPEL DE LA METHODE AJOUTER
		
		
		
		Produit prodOut = produitService.addProduit(produit);
		produit.setPhoto(this.uf.getContents());

		if (prodOut.getId() != 0) {

			// RECUPERER LA NOUVELLE LISTE DE PRODUIT

			List<Produit> listeprod = produitService.getlisteProduit();

			// METTRE A JOUR LA LISTE

			maSession.setAttribute("produitListe", listeprod);

			return "listesAdmin";

		} else {

			//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("echec ajout"));

			return "ajoutProd";
		}
	}

	
	public String modifierProd(){
		int verif=produitService.updateProduit(produit);
		
		if(verif!=0){
			
			List<Produit> listeprod=produitService.getlisteProduit();
			
			maSession.setAttribute("produitListe",listeprod);
			
			return "listesAdmin";
		}else{
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("echec modification"));
			
			return "modifProd";
		}
	}
	
	
	public String supprimerProd(){
		
		int verif=produitService.deleteProduit(produit);
		
		if(verif!=0){
			
			List<Produit> listeprod=produitService.getlisteProduit();
			
			maSession.setAttribute("produitListe",listeprod);
			
			return "listesAdmin";
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("echec suppression"));
			
			return "suppProd";
			
		}
	}
}
