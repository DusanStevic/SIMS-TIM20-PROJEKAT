package probniPrototip;
/***********************************************************************
 * Module:  Korisnik.java
 * Author:  Korisnik
 * Purpose: Defines the Class Korisnik
 ***********************************************************************/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;


public class Korisnik extends Osoba {
   protected String username;//Maki promenila na protected zato sto ne moze private kod otvaranja
   protected String password;
   
   Korisnik() {
	   
   }
   Korisnik(int idOsobe, String ime, String prezime, String username, String password) {
	   super(idOsobe, ime, prezime);
	   this.username = username;
	   this.password = password;
   }
   
   @Override
  	public String toString() {
  		return super.toString() + this.username + " " + this.password;
  		
  	}
   public static int logIn() {
		System.out.println("Dobrodosli!");
		System.out.println("Unesite korisniko ime >> ");
		String korisnickoIme = Utility.unesiString(Main.input);
		System.out.println("Unesite lozinku >> ");
		String lozinka = Utility.unesiString(Main.input);
		for (Korisnik korisnik : Main.listaKorisnika) {
			if (korisnik.username.equals(korisnickoIme) && korisnik.password.equals(lozinka)){
				System.out.println("Uspesno ste se prijavili kao korisnik " + korisnik.ime + " " + korisnik.prezime + ".");
				if (korisnik instanceof Administrator) {
					return 0;
				}else if (korisnik instanceof RadnikUCentrali) {
					return 1;
				}else if (korisnik instanceof SefStanice) {
					return 2;
				}else if (korisnik instanceof Operater) {
					return 3;
				}
			}
		}
		
		return -1;
			
   }
   

   public static void logOut() {
	   Main.ulogujSe();
   }
   
   
   
   

}