package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import fr.adaming.model.Admin;
import fr.adaming.service.IAdminService;

@ManagedBean(name = "aMB")
@RequestScoped
public class AdminManagedBean implements Serializable{
	
	// Transformation de l'association UML en Java
	@EJB
	private IAdminService adminService;
	
	// Attributs
	private Admin admin;
	
	
	// Constructeur vide
	public AdminManagedBean() {
		this.admin = new Admin();
	}
	
	// Getters et setters
	public Admin getAdmin() {
		return admin;
	}
	
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	

	public String seConnecter() {
		try {
			Admin aOut = adminService.isExist(admin);
			
			System.out.println(aOut);

			// ajouter l'admin et la liste comme attribut de la session
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("adminSession", aOut);

			return "listesAdmin";
		} catch (Exception ex) {
			FacesContext.getCurrentInstance().addMessage("erreur", new FacesMessage("Authentification impossible"));
		}
		return "loginAdmin";
	}

	public String seDeconnecter(){
		// fermer la session ouverte
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		
		return "accueil";
	}
	
}
