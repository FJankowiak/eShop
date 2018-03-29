package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "lignes_commande")
public class LigneCommande implements Serializable{
	
	// Declaration des attributs
	@Id
	@Column(name = "id_li")
	private Long id_ligne;
	private int quantite;
	private double prix;
	
	// Declaration des constructeurs
	public LigneCommande() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	// Transformer l'association UML en java
	@ManyToOne
	@JoinColumn(name = "p_id", referencedColumnName = "id_p")
	private Produit produit;
	
	@ManyToOne
	@JoinColumn(name = "co_id", referencedColumnName = "id_co")
	private Commande commande;
	
	

	// Declaration des getters et setters
	public LigneCommande(int quantite, double prix) {
		super();
		this.quantite = quantite;
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public Long getId_ligne() {
		return id_ligne;
	}

	public void setId_ligne(Long id_ligne) {
		this.id_ligne = id_ligne;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	// declaration des methodes
	@Override
	public String toString() {
		return "LigneCommande [quantite=" + quantite + ", prix=" + prix + "]";
	}
	
	
	
	
	

}
