package fr.adaming.dao;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

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

	@Override
	public void bilanPDF(Commande co, double total) {
//			
//			Document document = new Document(PageSize.A4, 75, 75,75, 75);
//			
//			PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\int0348\\Desktop\\Formation\\PdfCommande" + commande.getIdCommande() + ".pdf"));
//			document.open();
//			
//			Paragraph titre = new Paragraph("Facure de la commande " + commande.getIdCommande(), FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, Font.UNDERLINE, new CMYKColor(54,255,201,0)));
//			titre.setSpacingAfter(20);
//			document.add(titre);
//			
//			Paragraph sousTitre1=new Paragraph("Client : "+ commande.getClient().getNomClient() + 
//					" \n" + commande.getClient().getAdresse() + "\n" + commande.getClient().getTel()  "\n" + commande.getClient().getEmail(), 
//					FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE,15));
//			sousTitre1.setSpacingAfter(10);
//			document.add(sousTitre1);
//
//			Paragraph indic1=new Paragraph("Commande effectuée le " + commande.getDateCommande(), FontFactory.getFont(FontFactory.HELVETICA));
//			indic1.setSpacingAfter(5);
//			document.add(indic1);
//			
//			PdfPTable poAv= new PdfPTable(5);
//			poAv.setSpacingAfter(10);
//			poAv.addCell("Produit");
//			poAv.addCell("Prix à l'unité");
//			poAv.addCell("Quantité");
//			poAv.addCell("Prix");
//			co.getLigneCommandeListe().forEach(LigneCommande ligne){
//				Produit produit = ligne.getProduit();
//
//				poAv.addCell(String.valueOf(produit.getDesignation()));
//				poAv.addCell(String.valueOf(produit.getPrix()));
//				poAv.addCell(String.valueOf(ligne.getQuantite()));
//				poAv.addCell(String.valueOf(ligne.getPrix()));
//			}
////			poAv.addCell(co.get);
////			poAv.addCell(String.valueOf(co.getSolde()));
////			poAv.addCell(String.valueOf(co.getDecouvert()));
//			document.add(poAv);
//			
//			Paragraph indic2=new Paragraph("Total : " + total + "€",FontFactory.getFont(FontFactory.HELVETICA));
//			indic2.setSpacingAfter(5);
//			document.add(indic2);
//			
//			Paragraph indic2=new Paragraph("Nous vous remercions de votre confiance et vous souhaitons une bonne journée.",FontFactory.getFont(FontFactory.HELVETICA));
//			indic2.setSpacingAfter(5);
//			
//			
//			document.close();
//					
	}

}
