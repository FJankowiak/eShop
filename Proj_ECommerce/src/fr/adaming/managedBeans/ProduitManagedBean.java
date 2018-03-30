package fr.adaming.managedBeans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.adaming.service.IProduitService;

@ManagedBean(name = "prMB")
@RequestScoped
public class ProduitManagedBean {
	@EJB
	IProduitService produitService;
	
	HttpSession maSession;
	
	@PostConstruct // pour que cette méthode s'execute après l'instanciation du ManagedBean
	public void init(){
		// Recuperer la session ouverte
		this.maSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		maSession.setAttribute("listeProduits", produitService.getlisteProduit());
//		maSession.setAttribute("listeCategories", categorieService.getAllCategories());
		
	}

	public IProduitService getProduitService() {
		return produitService;
	}

	public void setProduitService(IProduitService produitService) {
		this.produitService = produitService;
	}
	
	

}
