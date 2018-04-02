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
import fr.adaming.service.ICategorieService;

@ManagedBean(name = "catMB")
@RequestScoped
public class CategorieManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	ICategorieService categorieService;

	// DECLARATION DES ATTRIBUTS DU MB

	private Categorie categorie;
	private Produit produit;
	private Admin admin;
	HttpSession maSession;
	List<Categorie> listeCat;

	private UploadedFile uf;

	// CONSTRUCTEUR VIDE

	public CategorieManagedBean() {
		this.categorie = new Categorie();
		this.uf = new UploadedFileWrapper();
	}

	@PostConstruct
	public void init() {

		// RECUPERER LA SESSION

		this.maSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		
	

	}

	// GETTERS ET SETTERS

	public Categorie getCategorie() {
		return categorie;
	}

	public List<Categorie> getListeCat() {
		return listeCat;
	}

	public void setListeCat(List<Categorie> listeCat) {
		this.listeCat = listeCat;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

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

	public UploadedFile getUf() {
		return uf;
	}

	public void setUf(UploadedFile uf) {
		this.uf = uf;
	}

	// METHODES

	public String ajouterCat() {

		
		this.categorie.setPhoto(this.uf.getContents());
		Categorie catOut = categorieService.addCategorie(categorie);

		if (catOut.getId() != 0) {

			// RECUP LA LISTE

			List<Categorie> liste = categorieService.getlisteCategorie();
			
			this.listeCat=liste;


			return "listesAdmin";

		} else {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("L'ajout de la categorie a échoué"));

			return "ajoutCat";
		}
	}

	public String modifierCat() {
		int verif = categorieService.updateCategorie(categorie);

		if (verif != 0) {

			List<Categorie> listeCat = categorieService.getlisteCategorie();

			maSession.setAttribute("categorieListe", listeCat);

			return "listesAdmin";
		} else {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("echec modification"));

			return "modifCat";
		}
	}

	public String supprimerCat() {

		int verif = categorieService.deleteCategorie(categorie);

		if (verif != 0) {

			List<Categorie> listecat = categorieService.getlisteCategorie();

			maSession.setAttribute("categorieListe", listecat);

			return "listesAdmin";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("echec suppression"));

			return "suppCat";

		}
	}

}
