package probniPrototip;
/***********************************************************************
 * Module:  Administrator.java
 * Author:  Korisnik
 * Purpose: Defines the Class Administrator
 ***********************************************************************/

import java.io.IOException;
import java.text.ParseException;
import java.util.*;


/** Administrator ima mogucnost da obradjuje podatke u aplikaciji.
 * Za svaku vrstu podataka koju obradjuje, aplikacija mu prosledjuje kolekciju podataka ili objekat koji sadrzi kolekciju kako bi mogao da manipulise tim podacima.
 * */
public class Administrator extends Korisnik {
	
	Administrator(int idOsobe, String ime, String prezime, String username, String password) {
		super(idOsobe, ime, prezime, username, password);
		
	}
	
	public static void meniAdministratora() {
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
			System.out.println("9. Exit.");
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
				unesiMesto();
				break;
			case 8:
				obrisiMesto();
				break;
			case 9:
			
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
      // TODO: implement
   }
   

   public static void ukloniKorisnika() {
      // TODO: implement
   }
   

   public static void izmeniKorisnika() {
      // TODO: implement
   }
   

   //Izbacila listu deonica kao parametre jer cu ucitati iz fajlova
   public static void dodajDeonicu() {
      // TODO: implement
   }
   
   public static void ukloniDeonicu() {
      // TODO: implement
   }
   
  
   public static void izmeniDeonicu() {
      // TODO: implement
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
   public static void unesiMesto() {
      // TODO: implement
   }
   
   public static void obrisiMesto() {
      // TODO: implement
   }

}