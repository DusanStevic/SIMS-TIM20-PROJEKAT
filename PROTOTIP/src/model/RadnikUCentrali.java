package model;
/***********************************************************************
. * Module:  RadnikUCentrali.java
 * Author:  marina
 * Purpose: Defines the Class RadnikUCentrali
 ***********************************************************************/

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import gui.Main;
import utils.Utility;

public class RadnikUCentrali extends Korisnik {
	Centrala zaposlenUCentrali;
	 @Override
	public String toString() {
		return super.toString() + this.zaposlenUCentrali.toString();
		
	}
	RadnikUCentrali() {
		
	}
	public RadnikUCentrali(int idOsobe, String ime, String prezime, String username, String password, String idCentrale) {
		super(idOsobe, ime, prezime, username, password);
		zaposlenUCentrali = new Centrala(idCentrale);
	}
	
	public static void meniRadnikaUCentrali() throws IOException, ParseException {
		boolean uslov = true;
		while (true) {
			System.out.println("Kriterijum za pravljenje izvestaja.");
			System.out.println("1. Naplatna stanica.");
			System.out.println("2. Datum.");
			System.out.println("3. Period.");
			System.out.println("4. Tip vozila.");
			System.out.println("5. Exit.");
			System.out.println("Vas odgovor >> ");
			int odgovor = Utility.unesiInt(Main.input);
			switch(odgovor) {
			case 1:
				izvestajNaplatnaStanica();
				break;
			case 2:
				izvestajDatum();
				break;
			case 3:
				izvestajPeriod();
				break;
			case 4:
				izvestajTipVozila();
				break;
			
			case 5:
				Korisnik.logOut();
				uslov = false;
				break;
		}	
		if (uslov == false) {
			break;
		}
		}
	}
	
	public static void izvestajNaplatnaStanica() {
		NaplatnaStanica naplatnaStanica = null;
		while(naplatnaStanica == null) {
			System.out.println("Unesite id naplatne stanice >> ");
			int idStanice = Utility.unesiInt(Main.input);
			naplatnaStanica = Administrator.nadjiStanicu(idStanice);
		}
		Boolean prvi = false;
		for (Naplata naplata : Main.getNaplate()){
			if (naplata.stavkaCenovnika.deonica.naplatnaStanica1.getIdStanice() == naplatnaStanica.getIdStanice() || naplata.stavkaCenovnika.deonica.naplatnaStanica2.getIdStanice() == naplatnaStanica.getIdStanice()){
				if (prvi == true){
					Naplata.ispisiZaglavlje();
					prvi = false;
				}
				Naplata.ispisiNaplatu(naplata);
			}
		}
		
		if (prvi == false){
			System.out.println("Nema rezultata pretrage.");
		}
		
	}
	
	public static void izvestajDatum() throws ParseException {
		System.out.println("Unesite datum>>");
		Date datum = Utility.unesiDatum(Main.input);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		
		
		Boolean postoji = false;
		for (Naplata naplata : Main.getNaplate()) {
			Date dateWithoutTime = sdf.parse(sdf.format(naplata.vremeNaplate));
			if (dateWithoutTime.equals(datum));
			postoji = true;
		}
		if (postoji == true){
			Naplata.ispisiZaglavlje();
			for (Naplata naplata : Main.getNaplate()) {
				Date dateWithoutTime = sdf.parse(sdf.format(naplata.vremeNaplate));
				if (dateWithoutTime.equals(datum));
				Naplata.ispisiNaplatu(naplata);
			}
		}else {
			System.out.println("Nema rezultata pretrage za zadati kriterijum.");
		}
		
	}
	
	public static void izvestajPeriod() throws ParseException {
		System.out.println("Unesite pocetni datum>>");
		Date datum = Utility.unesiDatum(Main.input);
		
		System.out.println("Unesite krajnji datum>>");
		Date datumKraj = Utility.unesiDatum(Main.input);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		
		
		Boolean postoji = false;
		for (Naplata naplata : Main.getNaplate()) {
			Date dateWithoutTime = sdf.parse(sdf.format(naplata.vremeNaplate));
			if (dateWithoutTime.before(datumKraj) && dateWithoutTime.after(datum)){
				postoji = true;
			}
				
		}
		if (postoji == true){
			Naplata.ispisiZaglavlje();
			for (Naplata naplata : Main.getNaplate()) {
				Date dateWithoutTime = sdf.parse(sdf.format(naplata.vremeNaplate));
				if (dateWithoutTime.before(datumKraj) && dateWithoutTime.after(datum)){
					Naplata.ispisiNaplatu(naplata);
				}
			}
		}else {
			System.out.println("Nema rezultata pretrage za zadati kriterijum.");
		}
		
	}
	
	public static void izvestajTipVozila() {
		int broj = -1;
		while(true){
			System.out.println("Unesite kategoriju vozila(1,2,3,4,5) >> ");
			broj = Utility.unesiInt(Main.input);
			if (broj == 5 || broj == 1 || broj == 2 || broj == 3 || broj == 4){
				break;
			}
		}
		
		TipVozila tp=null;
		if(broj==1){
			tp=TipVozila.prvaKategorija;
		}else if(broj==2){
			tp=TipVozila.drugaKategorija;
		}else if(broj==3){
			tp=TipVozila.trecaKategorija;
		}else if(broj==4){
			tp=TipVozila.cetvrtaKategorija;
		}else if(broj==5){
			tp=TipVozila.petaKategorija;
		}
		
		Boolean postoji = false;
		for (Naplata naplata : Main.getNaplate()) {
			if (naplata.stavkaCenovnika.tipVozila.equals(tp)){
				postoji = true;
			}
		}
		if (postoji == true){
			Naplata.ispisiZaglavlje();
			for (Naplata naplata : Main.getNaplate()){
				if (naplata.stavkaCenovnika.tipVozila.equals(tp)){
					Naplata.ispisiNaplatu(naplata);
				}
			}
		}else {
			System.out.println("Nema rezultata pretrage za zadati kriterijum.");
		}
		
		
	}
}