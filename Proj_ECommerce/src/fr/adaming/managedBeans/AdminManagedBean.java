package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import fr.adaming.model.Admin;
import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
import fr.adaming.service.IAdminService;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IProduitService;

@ManagedBean(name = "aMB")
@RequestScoped
public class AdminManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Transformation de l'association UML en Java
	@EJB
	private IAdminService adminService;
	@EJB
	private ICategorieService categorieService;
	@EJB
	private IProduitService produitService;

	// Attributs
	private Admin admin;
	private List<Categorie> listeCategorie;
	private List<Produit> listeProduits;

	// Constructeur vide
	public AdminManagedBean() {
		this.admin = new Admin();

	}

	// Getters et setters

	public Admin getAdmin() {
		return admin;
	}

	public List<Categorie> getListeCategorie() {
		return listeCategorie;
	}

	public void setListeCategorie(List<Categorie> listeCategorie) {
		this.listeCategorie = listeCategorie;
	}

	public List<Produit> getListeProduits() {
		return listeProduits;
	}

	public void setListeProduits(List<Produit> listeProduits) {
		this.listeProduits = listeProduits;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String seConnecter() {

		Admin aOut = adminService.isExist(admin);

		if (aOut != null) {

			this.listeProduits = produitService.getlisteProduit();
			this.listeCategorie = categorieService.getlisteCategorie();
			
			System.out.println(listeProduits);

			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("produitListe", listeProduits);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("categorieListe",
					listeCategorie);

			// ajouter l'admin et la liste comme attribut de la session
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("adminSession", aOut);

			return "listesAdmin";

		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Authentification impossible"));

			return "accueil";
		}

	}

	public String seDeconnecter() {
		// fermer la session ouverte
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

		return "accueil";
	}

}
