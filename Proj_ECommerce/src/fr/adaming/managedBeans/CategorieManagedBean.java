package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.management.ListenerNotFoundException;
import javax.servlet.http.HttpSession;

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

	// CONSTRUCTEUR VIDE

	public CategorieManagedBean() {
		this.categorie = new Categorie();
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

	// METHODES

	public String ajouterCat() {

		Categorie catOut = categorieService.addCategorie(categorie);

		if (catOut.getId() != 0) {

			// RECUP LA LISTE

			List<Categorie> listeCat = categorieService.getlisteCategorie();

			maSession.setAttribute("categorieListe", listeCat);

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

			return "listeAdmin";
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

			return "listeAdmin";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("echec suppression"));

			return "suppCat";

		}
	}
}
