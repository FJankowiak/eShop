//Tutoriel pour faire ça
//https://www.ibm.com/developerworks/library/os-javapdf/index.html


package fr.adaming.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import fr.adaming.model.CompteCourant;
import fr.adaming.model.CompteEpargne;

public class PdfService {
	
	public static void bilanComptesCourant(CompteCourant cc1, CompteCourant cc2, double somme) throws FileNotFoundException, DocumentException {
		
		Document document = new Document(PageSize.A4, 75, 75,75, 75);
		
		PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\int0348\\Desktop\\Formation\\PdfVirementCc.pdf"));
		document.open();
		
		Paragraph titre = new Paragraph("Bilan du virement", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, Font.UNDERLINE, new CMYKColor(54,255,201,0)));
		titre.setSpacingAfter(20);
		document.add(titre);
		
		Paragraph sousTitre1=new Paragraph("Somme virée : "+String.valueOf(somme)+" euros.", FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE,15));
		sousTitre1.setSpacingAfter(10);
		document.add(sousTitre1);

		Paragraph indic1=new Paragraph("Compte débité : ", FontFactory.getFont(FontFactory.HELVETICA));
		indic1.setSpacingAfter(5);
		document.add(indic1);
		PdfPTable cC1Av= new PdfPTable(5);
		cC1Av.setSpacingAfter(10);
		cC1Av.addCell("ID");
		cC1Av.addCell("Numero de compte");
		cC1Av.addCell("Solde");
		cC1Av.addCell("Découvert autorisé");
		cC1Av.addCell("ID Client");
		cC1Av.addCell(String.valueOf(cc1.getId()));
		cC1Av.addCell(cc1.getNumero());
		cC1Av.addCell(String.valueOf(cc1.getSolde()));
		cC1Av.addCell(String.valueOf(cc1.getDecouvert()));
		cC1Av.addCell(String.valueOf(cc1.getCl().getId()));
		document.add(cC1Av);
		
		Paragraph indic2=new Paragraph("Compte débiteur : ",FontFactory.getFont(FontFactory.HELVETICA));
		indic2.setSpacingAfter(5);
		document.add(indic2);
		PdfPTable cC2Av= new PdfPTable(5);
		cC2Av.setSpacingAfter(10);
		cC2Av.addCell("ID");
		cC2Av.addCell("Numero de compte");
		cC2Av.addCell("Solde");
		cC2Av.addCell("Découvert autorisé");
		cC2Av.addCell("ID Client");
		cC2Av.addCell(String.valueOf(cc2.getId()));
		cC2Av.addCell(cc2.getNumero());
		cC2Av.addCell(String.valueOf(cc2.getSolde()));
		cC2Av.addCell(String.valueOf(cc2.getDecouvert()));
		cC2Av.addCell(String.valueOf(cc2.getCl().getId()));
		document.add(cC2Av);
		
		
		
		document.close();
				
				
	}
	
public static void bilanComptesEpargne(CompteEpargne ce1, CompteEpargne ce2, double somme) throws FileNotFoundException, DocumentException {
		
		Document document = new Document(PageSize.A4, 75, 75,75, 75);
		
		PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\int0348\\Desktop\\Formation\\PdfVirementCe.pdf"));
		document.open();
		
		Paragraph titre = new Paragraph("Bilan du virement", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, Font.UNDERLINE, new CMYKColor(54,255,201,0)));
		titre.setSpacingAfter(20);
		document.add(titre);
		
		Paragraph sousTitre1=new Paragraph("Somme virée : "+String.valueOf(somme)+" euros.", FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE,15));
		sousTitre1.setSpacingAfter(10);
		document.add(sousTitre1);

		Paragraph indic1=new Paragraph("Compte débité : ", FontFactory.getFont(FontFactory.HELVETICA));
		indic1.setSpacingAfter(5);
		document.add(indic1);
		PdfPTable cE1Av= new PdfPTable(5);
		cE1Av.setSpacingAfter(10);
		cE1Av.addCell("ID");
		cE1Av.addCell("Numero de compte");
		cE1Av.addCell("Solde");
		cE1Av.addCell("Taux");
		cE1Av.addCell("ID Client");
		cE1Av.addCell(String.valueOf(ce1.getId()));
		cE1Av.addCell(ce1.getNumero());
		cE1Av.addCell(String.valueOf(ce1.getSolde()));
		cE1Av.addCell(String.valueOf(ce1.getTaux()));
		cE1Av.addCell(String.valueOf(ce1.getCl().getId()));
		document.add(cE1Av);
		
		Paragraph indic2=new Paragraph("Compte débiteur : ",FontFactory.getFont(FontFactory.HELVETICA));
		indic2.setSpacingAfter(5);
		document.add(indic2);
		PdfPTable cE2Av= new PdfPTable(5);
		cE2Av.setSpacingAfter(10);
		cE2Av.addCell("ID");
		cE2Av.addCell("Numero de compte");
		cE2Av.addCell("Solde");
		cE2Av.addCell("Découvert autorisé");
		cE2Av.addCell("ID Client");
		cE2Av.addCell(String.valueOf(ce2.getId()));
		cE2Av.addCell(ce2.getNumero());
		cE2Av.addCell(String.valueOf(ce2.getSolde()));
		cE2Av.addCell(String.valueOf(ce2.getTaux()));
		cE2Av.addCell(String.valueOf(ce2.getCl().getId()));
		document.add(cE2Av);
		
		
		
		document.close();
				
				
	}

}
