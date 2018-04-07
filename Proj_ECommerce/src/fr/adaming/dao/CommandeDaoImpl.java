package fr.adaming.dao;

//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Font;
//import com.itextpdf.text.FontFactory;
//import com.itextpdf.text.PageSize;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.CMYKColor;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Produit;

@Stateless
public class CommandeDaoImpl implements ICommandeDao {
	// Injection de dépendance, pour stocker les valeurs dans cet attribut
	@PersistenceContext(unitName = "PU")
	private EntityManager em;

	Date dt = new Date();

	java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");

	String currentTime = sdf.format(dt);

	@Override
	public Commande finaliserCommande(List<LigneCommande> liste, Client cl) {
		Commande commande = new Commande();
		commande.setDateCommande(dt);
		commande.setLigneCommandeListe(liste);
		commande.setClient(cl);

		em.persist(commande);

		return commande;
	}

}
