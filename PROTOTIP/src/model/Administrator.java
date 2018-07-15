package model;
/***********************************************************************
 * Module:  Administrator.java
 * Author:  Korisnik
 * Purpose: Defines the Class Administrator
 ***********************************************************************/

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

import gui.Main;
import utils.Utility;


/** Administrator ima mogucnost da obradjuje podatke u aplikaciji.
 * Za svaku vrstu podataka koju obradjuje, aplikacija mu prosledjuje kolekciju podataka ili objekat koji sadrzi kolekciju kako bi mogao da manipulise tim podacima.
 * */
public class Administrator extends Korisnik {
	
	public Administrator(int idOsobe, String ime, String prezime, String username, String password) {
		super(idOsobe, ime, prezime, username, password);
		
	}
	
	public static void meniAdministratora() throws IOException, ParseException {
		boolean uslov = true;
		while (true) {
			System.out.println("Opcije koje su vam ponudjene.");
			System.out.println("1. Dodaj korisnika.");
			System.out.println("2. Ukloni korisnika.");
			System.out.println("3. Izmeni korisnika.");
			System.out.println("4. Dodaj deonicu.");
			System.out.println("5. Ukloni deonicu.");
			System.out.println("6. Izmeni deonicu.");
			System.out.println("7. Unesi naplatno mesto.");
			System.out.println("8. Obrisi naplatno mesto.");
			System.out.println("9. Unesi naplatnu stanicu.");
			System.out.println("10. Obrisi naplatnu stanicu.");
			System.out.println("11. Exit.");
			System.out.println("Vas odgovor >> ");
			int odgovor = Utility.unesiInt(Main.input);
			switch(odgovor) {
			case 1:
				dodajKorisnika();
				break;
			case 2:
				ukloniKorisnika();
				break;
			case 3:
				izmeniKorisnika();
				break;
			case 4:
				dodajDeonicu();
				break;
			case 5:
				ukloniDeonicu();
				break;
			case 6:
				izmeniDeonicu();
				break;
			case 7:
				unesiMesto(-1);
				break;
			case 8:
				obrisiMesto();
				break;
			case 9:
				unesiStanicu();
				break;
			case 10:
				obrisiStanicu();
				break;
			case 11:
			
				Korisnik.logOut();
				uslov = false;
				break;
		}	
		if (uslov == false) {
			break;
		}
	}
	}


	//Iz metoda koje koriste liste korisnika sam izbrisala te liste jer ih imamo u mainu
   public static void dodajKorisnika() {
	   while (true){
			System.out.println("Da li zelite da unesete: ");
			System.out.println("1. Novog radnika u centrali.");
			System.out.println("2. Novog sefa stanice.");
			System.out.println("3. Operatera.");
			System.out.println("Unesite zeljenu opciju >> ");
			int odgovor = Utility.unesiInt(Main.input);
			switch (odgovor) {
			case 1:
				unesiNovogRadnikaUCentrali();
				break;
				
			case 2:
				unesiNovogSefaStanice();
				break;
			case 3:
				unesiNovogOperatera();
				break;
				
			default:
				System.out.println("Neodgovarajuci unos. Unesite neku od ponudjenih opcija.");
			}
			System.out.println("Unos novog korisnika(DA/NE) >> ");
			String odgovor2 = Utility.unesiString(Main.input);
			if (odgovor2.equalsIgnoreCase("ne")) {
				break;
			}
		}	
   }
   
   public static boolean proveriKorIme(String ime) {
		for (Korisnik kor : Main.getListaKorisnika()) {
			if (kor.getUsername().equals(ime)) {
				return false;
			}
		}
		return true;
	}
   
   public static boolean proveriPostojanjeNaplatnogMesta(int id) {
		for (NaplatnoMesto mesto : Main.getListaNaplatnihMesta()) {
			if (mesto.getIdNaplatnog() == id) {
				return true;
			}
		}
		return false;
	}
   
   public static void unesiNovogRadnikaUCentrali() {
	   while (true) {
			System.out.println("Unesite korisniko ime >> ");
			String korIme = Utility.unesiString(Main.input);
			while (true) {
				boolean dostupno = Administrator.proveriKorIme(korIme);
				if (dostupno == true) {
					break;
				}
			}
			
			System.out.println("Unesite lozinku >> ");
			String lozinka = Utility.unesiString(Main.input);
			System.out.println("Unesite id osobe: ");
			int idOsobe = Utility.unesiInt(Main.input);
			System.out.println("Unesite ime >> ");
			String ime = Utility.unesiString(Main.input);
			System.out.println("Unesite prezime >> ");
			String prezime = Utility.unesiString(Main.input);
			RadnikUCentrali radnik = new RadnikUCentrali(idOsobe, ime, prezime, korIme, lozinka, "0");
			Main.getListaKorisnika().add(radnik);
			System.out.println("Dodaj novog radnika u centrali(DA/NE) >> ");
			String noviM = Utility.unesiOdluku(Main.input);
			if (noviM.equalsIgnoreCase("ne")) {
				break;
			}
		}
   }
   
   public static void unesiNovogSefaStanice() {
	   while (true) {
			System.out.println("Unesite korisniko ime >> ");
			String korIme = Utility.unesiString(Main.input);
			while (true) {
				boolean dostupno = Administrator.proveriKorIme(korIme);
				if (dostupno == true) {
					break;
				}
			}
			
			System.out.println("Unesite lozinku >> ");
			String lozinka = Utility.unesiString(Main.input);
			System.out.println("Unesite id osobe: ");
			int idOsobe = Utility.unesiInt(Main.input);
			System.out.println("Unesite ime >> ");
			String ime = Utility.unesiString(Main.input);
			System.out.println("Unesite prezime >> ");
			String prezime = Utility.unesiString(Main.input);
			NaplatnaStanica ns = null;
			while(ns == null){
				System.out.println("Unesite id naplatne stanice >>");
				int idSt = Utility.unesiInt(Main.input);
				ns = Administrator.nadjiStanicu(idSt);
			}
			SefStanice radnik = new SefStanice(idOsobe, ime, prezime, korIme, lozinka,ns);
			Main.getListaKorisnika().add(radnik);
			System.out.println("Dodaj novog radnika u centrali(DA/NE) >> ");
			String noviM = Utility.unesiOdluku(Main.input);
			if (noviM.equalsIgnoreCase("ne")) {
				break;
			}
		}
	   
   }
   
   public static void unesiNovogOperatera() {
	   while (true) {
			System.out.println("Unesite korisniko ime >> ");
			String korIme = Utility.unesiString(Main.input);
			while (true) {
				boolean dostupno = Administrator.proveriKorIme(korIme);
				if (dostupno == true) {
					break;
				}
			}
			
			System.out.println("Unesite lozinku >> ");
			String lozinka = Utility.unesiString(Main.input);
			System.out.println("Unesite id osobe: ");
			int idOsobe = Utility.unesiInt(Main.input);
			System.out.println("Unesite ime >> ");
			String ime = Utility.unesiString(Main.input);
			System.out.println("Unesite prezime >> ");
			String prezime = Utility.unesiString(Main.input);
			int idNaplatnogMesta = 0;
			Boolean uslov = true;
			while (uslov == true) {
				System.out.println("Unesite naplatno mesto >> ");
				idNaplatnogMesta = Utility.unesiInt(Main.input);
				boolean dostupno = Administrator.proveriPostojanjeNaplatnogMesta(idNaplatnogMesta);
				if (dostupno == true) {
					uslov = false;
				}
			}
			Operater radnik = new Operater(idOsobe, ime, prezime, korIme, lozinka);
			
			Main.getListaKorisnika().add(radnik);
			System.out.println("Dodaj novog radnika u centrali(DA/NE) >> ");
			String noviM = Utility.unesiOdluku(Main.input);
			if (noviM.equalsIgnoreCase("ne")) {
				break;
			}
		}
	   
   }

   public static void ukloniKorisnika() {
	  while(true){
		  System.out.println("Unesite identifikacioni broj korisnika >> ");
		  int idKor = Utility.unesiInt(Main.input);
	      Boolean postoji = false;
	      for (Iterator<Korisnik> it = Main.getListaKorisnika().iterator(); it.hasNext();){
	    	  Korisnik korisnik = it.next();
	    	  if (korisnik.getIdOsobe() == idKor){
	    		  postoji = true;
	    		  it.remove();
	    	  }
	      }
	      
	      if (postoji == true){
	    	  System.out.println("Korisnik je uspesno izbrisan iz evidencije.");
	      }else {
	    	  System.out.println("Ne postoji korisnik sa unetim id-om");
	      }
	      System.out.println("Novo brisanje(DA/NE) >> ");
	      String odgovor = Utility.unesiOdluku(Main.input);
	      if (odgovor.equalsIgnoreCase("NE")){
	    	  break;
	      }
	  }
     
      
      
   }
   public static Korisnik nadjiKorisnika() {
		Korisnik korisnik = null;
		System.out.println("Unesite ime korisnika >> ");
		String ime = Utility.unesiString(Main.input);
		System.out.println("Unesite prezime korisnika >> ");
		String prezime = Utility.unesiString(Main.input);
		for (Korisnik k : Main.getListaKorisnika()) {
			if ((k.getIme().equalsIgnoreCase(ime) || k.getIme().toUpperCase().contains(ime.toUpperCase())) && (k.getPrezime().equalsIgnoreCase(prezime) || k.getPrezime().toUpperCase().contains(prezime.toUpperCase()))){
				korisnik = k;
			}
		}
		return korisnik;
	}

   public static void izmeniKorisnika() {
	   while(true) {
			Korisnik korisnik = Administrator.nadjiKorisnika();
			if (korisnik == null) {
				System.out.println("Ne postoji korisnik sa untetim imenom i prezimenom.");
			}else {
				int odgovor = 0;
				System.out.println("Korisnik je uspesno pronadjen.");
				boolean uslov = true;
				while(uslov == true){
					System.out.println("Podaci koje ste u mogucnosti da izmenite:");
					System.out.println("1.Ime.");
					System.out.println("2. Prezime.");
					System.out.println("3. Lozinka.");
					System.out.println("4. Exit");
					System.out.println("Unesite odgovor >>");
					odgovor = Utility.unesiInt(Main.input);
					switch(odgovor) {
					case 1:
						System.out.println("Unesite novo ime >>");
						String ime = Utility.unesiString(Main.input);
						korisnik.setIme(ime);
						break;
					case 2:
						System.out.println("Unesite novo prezime >> ");
						String prezime = Utility.unesiString(Main.input);
						korisnik.setPrezime(prezime);
						break;
					case 3:
						System.out.println("Unesite novu lozinku >> ");
						String lozinka = Utility.unesiString(Main.input);
						korisnik.setLozinka(lozinka);
						break;
					case 4:
						uslov = false;
						break;
					default:
						System.out.println("Neodgovarajuci unos. Unesite neku od ponudjenih opcija.");	
					}
				}
			}
			System.out.println("Nastavak izmena (DA/NE) >> ");
			String odgovor = Utility.unesiString(Main.input);
			if (odgovor.equalsIgnoreCase("ne")) {
				break;
			}
			
		}
   }
   
   public static NaplatnaStanica nadjiStanicu(int idStanice) {
		NaplatnaStanica stanica = null;
		
		for (NaplatnaStanica ns : Main.getListaNaplatnihStanica()) {
			if (ns.getIdStanice() == idStanice){
				stanica = ns;
			}
		}
		return stanica;
	}
   
   //Izbacila listu deonica kao parametre jer cu ucitati iz fajlova
   public static void dodajDeonicu() {
     
     NaplatnaStanica prvaNaplatna = null;
     while (prvaNaplatna == null){
    	 System.out.println("Unesite id prve naplatne stanice >> ");
         int idPrve = Utility.unesiInt(Main.input);
         prvaNaplatna = nadjiStanicu(idPrve);
     }
     
     NaplatnaStanica drugaNaplatna = null;
     while (drugaNaplatna == null){
    	 System.out.println("Unesite id druge naplatne stanice >> ");
         int idDruge = Utility.unesiInt(Main.input);
         drugaNaplatna = nadjiStanicu(idDruge);
     }
    
     Deonica deonica = new Deonica(prvaNaplatna, drugaNaplatna);
     Main.getListaDeonica().add(deonica);
     System.out.println("Nova deonica je uspesno dodata.");
   }
   
   public static void ukloniDeonicu() {
	   NaplatnaStanica prvaNaplatna = null;
	     while (prvaNaplatna == null){
	    	 System.out.println("Unesite id prve naplatne stanice >> ");
	         int idPrve = Utility.unesiInt(Main.input);
	         prvaNaplatna = nadjiStanicu(idPrve);
	     }
	     
	     NaplatnaStanica drugaNaplatna = null;
	     while (drugaNaplatna == null){
	    	 System.out.println("Unesite id druge naplatne stanice >> ");
	         int idDruge = Utility.unesiInt(Main.input);
	         drugaNaplatna = nadjiStanicu(idDruge);
	     }
	    
	     Deonica deonica = new Deonica(prvaNaplatna, drugaNaplatna);
	     Boolean postoji = false;
	     for (Iterator<Deonica> it = Main.getListaDeonica().iterator(); it.hasNext();){
	    	  Deonica deo = it.next();
	    	  if (deo.naplatnaStanica1.getIdStanice() == prvaNaplatna.getIdStanice() && deo.naplatnaStanica2.getIdStanice() == drugaNaplatna.getIdStanice()){
	    		  postoji = true;
	    		  it.remove();
	    	  }
	      }
	      
	      if (postoji == true){
	    	  System.out.println("Deonica je uspesno izbrisan iz evidencije.");
	      }else {
	    	  System.out.println("Ne postoji deonica sa unetim podacima");
	      }
   }
   
  
   public static void izmeniDeonicu() {
      
      NaplatnaStanica prvaNaplatna = null;
     while (prvaNaplatna == null){
    	 System.out.println("Unesite id prve naplatne stanice >> ");
         int idPrve = Utility.unesiInt(Main.input);
         prvaNaplatna = nadjiStanicu(idPrve);
     }
     
     NaplatnaStanica drugaNaplatna = null;
     while (drugaNaplatna == null){
    	 System.out.println("Unesite id druge naplatne stanice >> ");
         int idDruge = Utility.unesiInt(Main.input);
         drugaNaplatna = nadjiStanicu(idDruge);
     }
    
     Deonica deonica = new Deonica(prvaNaplatna, drugaNaplatna);
     Boolean postoji = false;
     
     for (Deonica deon : Main.getListaDeonica()){
    	 if (deon.naplatnaStanica1.getIdStanice() == prvaNaplatna.getIdStanice() && deon.naplatnaStanica2.getIdStanice() == drugaNaplatna.getIdStanice()) {
    		 postoji = true;
    		 System.out.println("Izmeni PRVU/DRUGU stanicu >> ");
    	     String odgovor = "";
    	     while(!odgovor.equalsIgnoreCase("PRVU") && !odgovor.equalsIgnoreCase("DRUGU")){
    	   	  	odgovor = Utility.unesiString(Main.input);
    	     }
    	     NaplatnaStanica novaNaplatna = null;
    	     while (novaNaplatna == null){
    	    	 System.out.println("Unesite id naplatne stanice >> ");
    	         int idNove = Utility.unesiInt(Main.input);
    	         novaNaplatna = nadjiStanicu(idNove);
    	     }
    	     if (odgovor.equalsIgnoreCase("PRVU")) {
    	    	  deon.naplatnaStanica1 = novaNaplatna;
    	      }else {
    	    	  deon.naplatnaStanica2 = novaNaplatna;
    	      }
    	 }
     }
      
      if (postoji == true){
    	  System.out.println("Deonica je izmenjena.");
      }else {
    	  System.out.println("Ne postoji deonica sa unetim podacima");
      }
   }
   
   //Maki obrisala centralu kao argument..ne znam kako to da sprovedem..i dodala static jer ne moze drugacije iz menija da se pozove
   public static void unesiStanicu() {
      // TODO: implement
   }
   
   //Maki obrisala centralu kao argument..ne znam kako to da sprovedem..i dodala static jer ne moze drugacije iz menija da se pozove

   public static void obrisiStanicu() {
      // TODO: implement
   }
   

   //Obrisala naplatnu stanicu kao argument jer nisam znala kako u meniju da resim
   public static void unesiMesto(int idStanice) {
      if (idStanice == -1) {
    	  System.out.println("Unesite idStanice kojem zelite da dodate naplatnoMesto >>");
      }
   }
   
   public static void obrisiMesto() {
      // TODO: implement
   }

}