package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class Client implements Serializable {
	// Declaration des attributs
	@Id
	@Column(name ="id_cl")
	private Long idClient;
	private String nomClient;
	private String adresse;
	private String email;
	private String tel;
	private String mdp;



	// Transformer l'association UML en java
	@OneToMany(mappedBy="client")
	private List<Commande> listeCommandes;
	
	
	
	// Declaration des constructeurs
	public Client() {
		super();
	}
	


	public Client(String nomClient, String adresse, String email, String tel, String mdp) {
		super();
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
		this.mdp = mdp;
	}


	public Client(Long idClient, String nomClient, String adresse, String email, String tel, String mdp) {
		super();
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
		this.mdp = mdp;
	}


	// Declaration des getters et setters
	public Long getIdClient() {
		return idClient;
	}


	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}


	public String getNomClient() {
		return nomClient;
	}


	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getMdp() {
		return mdp;
	}

	
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}


	public List<Commande> getListeCommandes() {
		return listeCommandes;
	}

	public void setListeCommandes(List<Commande> listeCommandes) {
		this.listeCommandes = listeCommandes;
	}


	// declaration des methodes
	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nomClient=" + nomClient + ", adresse=" + adresse + ", email=" + email
				+ ", tel=" + tel + ", mdp=" + mdp + ", listeCommandes=" + listeCommandes + "]";
	}



	

	
	
	
	 
}
