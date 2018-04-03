package fr.adaming.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Lob;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="categories")
public class Categorie implements Serializable {
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//DECLARATION DES ATTRIBUTS
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cat")
	private  Long id;
	private String nomCategorie;
	@Lob
	private  byte[] photo;
	private String description;
	@Transient
	private String image;
	
	
	//TRANSFORMATION DE L'ASSOCIATION UML EN JAVA
	 




	@OneToMany(mappedBy="cat")
	private List<Produit> listeProduit;
	




	//CONSTRUCTEURS  VIDE
	public Categorie() {
		super();
	}



	
	//CONSTRUCTEURS SANS ID
	public Categorie(String nomCategorie, byte[] photo, String description) {
		super();
		this.nomCategorie = nomCategorie;
		this.photo = photo;
		this.description = description;
	}
	
	




	//CONSTRUCTEURS AVEC ID
	public Categorie(Long id, String nomCategorie, byte[] photo, String description) {
		super();
		this.id = id;
		this.nomCategorie = nomCategorie;
		this.photo = photo;
		this.description = description;
	}


	//GETTERS ET SETTERS
	
	public String getImage() {
		return image;
	}




	public void setImage(String image) {
		this.image = image;
	}
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNomCategorie() {
		return nomCategorie;
	}



	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}



	public byte[] getPhoto() {
		return photo;
	}



	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}

	
	public List<Produit> getListeProduit() {
		return listeProduit;
	}




	public void setListeProduit(List<Produit> listeProduit) {
		this.listeProduit = listeProduit;
	}




	@Override
	public String toString() {
		return "Categorie [id=" + id + ", nomCategorie=" + nomCategorie + ", photo=" + Arrays.toString(photo)
				+ ", description=" + description + ", image=" + image + ", listeProduit=" + listeProduit + "]";
	}







}
