package model;
/***********************************************************************
 * Module:  SefStanice.java
 * Author:  marina
 * Purpose: Defines the Class SefStanice
 ***********************************************************************/

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import gui.Main;
import utils.Utility;

public class SefStanice extends Korisnik {
	NaplatnaStanica naplatnaStanica;
	SefStanice() {
		
	}
	public SefStanice(int idOsobe, String ime, String prezime, String username, String password, NaplatnaStanica ns) {
		super(idOsobe, ime, prezime, username, password);
		this.naplatnaStanica = ns;
	}
	
	public static void meniSefaStanice() throws IOException, ParseException {
		boolean uslov = true;
		while (true) {
			System.out.println("Opcije koje su vam ponudjene.");
			System.out.println("1. Pregled izvestaja.");
			System.out.println("2. Unos cena za deonice.");
			System.out.println("3. Pregled kvarova.");
			System.out.println("4. Exit.");
			System.out.println("Vas odgovor >> ");
			int odgovor = Utility.unesiInt(Main.input);
			switch(odgovor) {
			case 1:
				pregledIzvestaja();
				break;
			case 2:
				unosCenaZaDeonice();
				break;
			case 3:
				pregledKvarova();
				break;
			
			case 4:
				Korisnik.logOut();
				uslov = false;
				break;
		}	
		if (uslov == false) {
			break;
		}
		}
	}
	
	public static void pregledIzvestaja() throws ParseException {
		
		boolean uslov = true;
		while (true) {
			System.out.println("Opcije koje su vam ponudjene.");
			System.out.println("1. Izaberi datum.");
			System.out.println("2. Izbari period.");
			System.out.println("3. Izaberi tip vozila.");
			System.out.println("4. Exit.");
			System.out.println("Vas odgovor >> ");
			int odgovor = Utility.unesiInt(Main.input);
			switch(odgovor) {
			case 1:
				kriterijumDatum();
				break;
			case 2:
				kriterijumPeriod();
				break;
			case 3:
				kriterijumTipVozila();
				break;
			
			case 4:

				uslov = false;
				break;
		}	
		if (uslov == false) {
			break;
		}
		}
		
	}
	
	public static void kriterijumDatum() throws ParseException {
		System.out.println("Unesite datum>>");
		Date datum = Utility.unesiDatum(Main.input);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		
		
		Boolean postoji = false;
		for (Naplata naplata : Main.getNaplate()) {
		
			Date dateWithoutTime = sdf.parse(sdf.format(naplata.vremeNaplate));
			if (dateWithoutTime.equals(datum) && (naplata.stavkaCenovnika.deonica.naplatnaStanica1.getIdStanice() == ((SefStanice)Main.getKorisnik()).naplatnaStanica.getIdStanice() || naplata.stavkaCenovnika.deonica.naplatnaStanica2.getIdStanice() == ((SefStanice)Main.getKorisnik()).naplatnaStanica.getIdStanice()));
			postoji = true;
		}
		if (postoji == true){
			Naplata.ispisiZaglavlje();
			for (Naplata naplata : Main.getNaplate()) {
				Date dateWithoutTime = sdf.parse(sdf.format(naplata.vremeNaplate));
				if (dateWithoutTime.equals(datum) && (naplata.stavkaCenovnika.deonica.naplatnaStanica1.getIdStanice() == ((SefStanice)Main.getKorisnik()).naplatnaStanica.getIdStanice() || naplata.stavkaCenovnika.deonica.naplatnaStanica2.getIdStanice() == ((SefStanice)Main.getKorisnik()).naplatnaStanica.getIdStanice()));

				Naplata.ispisiNaplatu(naplata);
			}
		}else {
			System.out.println("Nema rezultata pretrage za zadati kriterijum.");
		}
		
	}
	
	public static void kriterijumPeriod() throws ParseException {
		System.out.println("Unesite pocetni datum>>");
		Date datum = Utility.unesiDatum(Main.input);
		
		System.out.println("Unesite krajnji datum>>");
		Date datumKraj = Utility.unesiDatum(Main.input);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		
		
		Boolean postoji = false;
		for (Naplata naplata : Main.getNaplate()) {
			Date dateWithoutTime = sdf.parse(sdf.format(naplata.vremeNaplate));
			if ((naplata.stavkaCenovnika.deonica.naplatnaStanica1.getIdStanice() == ((SefStanice)Main.getKorisnik()).naplatnaStanica.getIdStanice() || naplata.stavkaCenovnika.deonica.naplatnaStanica2.getIdStanice() == ((SefStanice)Main.getKorisnik()).naplatnaStanica.getIdStanice()) && dateWithoutTime.before(datumKraj) && dateWithoutTime.after(datum)){
				postoji = true;
			}
				
		}
		if (postoji == true){
			Naplata.ispisiZaglavlje();
			for (Naplata naplata : Main.getNaplate()) {
				Date dateWithoutTime = sdf.parse(sdf.format(naplata.vremeNaplate));
				if ((naplata.stavkaCenovnika.deonica.naplatnaStanica1.getIdStanice() == ((SefStanice)Main.getKorisnik()).naplatnaStanica.getIdStanice() || naplata.stavkaCenovnika.deonica.naplatnaStanica2.getIdStanice() == ((SefStanice)Main.getKorisnik()).naplatnaStanica.getIdStanice()) && dateWithoutTime.before(datumKraj) && dateWithoutTime.after(datum)){
					Naplata.ispisiNaplatu(naplata);
				}
			}
		}else {
			System.out.println("Nema rezultata pretrage za zadati kriterijum.");
		}
		
	}
	
	public static void kriterijumTipVozila() {
		
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
			int id = ((SefStanice)Main.getKorisnik()).naplatnaStanica.getIdStanice();
			if ((naplata.stavkaCenovnika.deonica.naplatnaStanica1.getIdStanice() == id|| naplata.stavkaCenovnika.deonica.naplatnaStanica2.getIdStanice() == id) && naplata.stavkaCenovnika.tipVozila.equals(tp)){
				postoji = true;
			}
		}
		if (postoji == true){
			Naplata.ispisiZaglavlje();
			for (Naplata naplata : Main.getNaplate()){
				int id = ((SefStanice)Main.getKorisnik()).naplatnaStanica.getIdStanice();
				if ((naplata.stavkaCenovnika.deonica.naplatnaStanica1.getIdStanice() == id || naplata.stavkaCenovnika.deonica.naplatnaStanica2.getIdStanice() == id) && naplata.stavkaCenovnika.tipVozila.equals(tp)){					
					Naplata.ispisiNaplatu(naplata);
				}
			}
		}else {
			System.out.println("Nema rezultata pretrage za zadati kriterijum.");
		}
		
	}
	public static void unosCenaZaDeonice() {
		NaplatnaStanica prvaNaplatna = null;
		while(prvaNaplatna == null){
			System.out.println("Unesite id prve naplatne stanice >> ");
			int idStanice = Utility.unesiInt(Main.input);
			prvaNaplatna = Administrator.nadjiStanicu(idStanice);
		}
		NaplatnaStanica drugaNaplatna = null;
		while(drugaNaplatna == null){
			System.out.println("Unesite id druge naplatne stanice >> ");
			int idStanice = Utility.unesiInt(Main.input);
			drugaNaplatna = Administrator.nadjiStanicu(idStanice);
		}
		
		Boolean postoji = false;
		
		for (Deonica deonica : Main.getListaDeonica()){
			if (deonica.naplatnaStanica1.getIdStanice() == prvaNaplatna.getIdStanice()&& deonica.naplatnaStanica2.getIdStanice() == drugaNaplatna.getIdStanice()){
				postoji = true;
				System.out.println("Unesite cenu za deonicu >> ");
				Double cena = Utility.unesiDouble(Main.input);
				int broj = -1;
				
				while(broj != 1 && broj != 2 && broj!= 3 && broj!=4 && broj!=5){
					System.out.println("Unesite kategoriju (1,2,3,4,5) >> ");
					broj = Utility.unesiInt(Main.input);
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
				
				StavkaCenovnika stavka = new StavkaCenovnika(deonica, tp, cena);
				//Main.cenovnik.stavkaCenovnika.add(stavka);
			}
		}
		if (postoji == true){
			System.out.println("Nova stavka cenovnika uspesno dodata.");
		}else {
			System.out.println("Ne postoji deonica za koju zelite da unesete cenu.");
		}
		
		
	}
	
	public static void pregledKvarova() {
		
		int idStanice = ((SefStanice) Main.getKorisnik()).naplatnaStanica.getIdStanice();
		/*
		NaplatnaStanica naplatnaStanica = null;
		for (NaplatnaStanica ns : Main.listaNaplatnihStanica){
			if (ns.idStanice == idStanice){
				naplatnaStanica = ns;
			}
		}*/
		Boolean prvi = true;
		for (Kvar kvar : Main.getListaKvarova()){
			int stanicaId = kvar.naplatnoMesto.getNaplatnaStanica().getIdStanice();
			if (stanicaId == idStanice){
				if (prvi == true){
					Kvar.ispisiZaglavlje();
					prvi = false;
				}
				Kvar.ispisiKvar(kvar);
			}
		}
		
	}
}

