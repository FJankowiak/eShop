package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="produits")
public class Produit implements Serializable {
	
	//DECLARATION DES ATTRIBUTS
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_p")
	private Long id;
	private String designation;
	private String description;
	private double prix;
	private int quantite;
	private boolean selectionne;
	private @Lob byte[] photo;
	
	
	//TRANSFORMATION DE L'ASSOCIATION EN UML EN JAVA
	
	
	@ManyToOne
	@JoinColumn(name="cat_id", referencedColumnName="id_cat")
	private Categorie cat;
	
	
	@ManyToOne
	@JoinColumn(name="ad_id",referencedColumnName="id_ad")
	private Admin admin;
	
	
	//CONSTRUCTEURS VIDE
	



	public Produit() {
		super();
	}
	
	//CONSTRUCTEURS SANS ID
	

	public Produit(String designation, String description, double prix, int quantite, boolean selectionne, byte[] photo,
			Categorie cat, Admin admin) {
		super();
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.selectionne = selectionne;
		this.photo = photo;
		this.cat = cat;
		this.admin = admin;
	}
	
	//CONSTRUCTEURS PLEINS
	


	public Produit(Long id, String designation, String description, double prix, int quantite, boolean selectionne,
			byte[] photo, Categorie cat, Admin admin) {
		super();
		this.id = id;
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.selectionne = selectionne;
		this.photo = photo;
		this.cat = cat;
		this.admin = admin;
	}

	

	//GETTERS ET SETTERS
	


	public String getDesignation() {
		return designation;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public boolean isSelectionne() {
		return selectionne;
	}

	public void setSelectionne(boolean selectionne) {
		this.selectionne = selectionne;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public Categorie getCat() {
		return cat;
	}

	public void setCat(Categorie cat) {
		this.cat = cat;
	}
	

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	//TOSTRING
	@Override
	public String toString() {
		return "Produit [id=" + id + ", designation=" + designation + ", description=" + description + ", prix=" + prix
				+ ", quantite=" + quantite + ", selectionne=" + selectionne + ", photo=" + photo + "]";
	}



	
	

	
	
}
