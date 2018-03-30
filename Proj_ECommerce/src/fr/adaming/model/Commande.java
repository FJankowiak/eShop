package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "commandes")
public class Commande implements Serializable {
	
	// Declaration des attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_co")
	private Long idCommande;
	private Date dateCommande;
	
	// Transformer l'association UML en java
	@ManyToOne
	@JoinColumn(name = "cl_id", referencedColumnName = "id_cl")
	private Client client;
	
	@OneToMany(mappedBy="commande")
	private List<LigneCommande> ligneCommandeListe; 

	
	// Declaration des constructeurs
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Commande(Date dateCommande) {
		super();
		this.dateCommande = dateCommande;
	}
	
	public Commande(Long idCommande, Date dateCommande) {
		super();
		this.idCommande = idCommande;
		this.dateCommande = dateCommande;
	}

	
	
	// Declaration des getters et setters
	public Long getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public List<LigneCommande> getLigneCommandeListe() {
		return ligneCommandeListe;
	}

	public void setLigneCommandeListe(List<LigneCommande> ligneCommandeListe) {
		this.ligneCommandeListe = ligneCommandeListe;
	}

	// declaration des methodes
	@Override
	public String toString() {
		return "Commande [idCommande=" + idCommande + ", dateCommande=" + dateCommande + "]";
	}
	
	
	
}
