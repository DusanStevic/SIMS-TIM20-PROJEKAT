package model;
/***********************************************************************
 * Module:  Korisnik.java
 * Author:  Korisnik
 * Purpose: Defines the Class Korisnik
 ***********************************************************************/
/*
import Administrator;
import Korisnik;
import Operater;
import RadnikUCentrali;
import SefStanice;
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

import gui.Main;
import utils.Utility;


public class Korisnik extends Osoba {
   private String username;//Maki promenila na protected zato sto ne moze private kod otvaranja
   private String password;
   
   Korisnik() {
	   
   }
   Korisnik(int idOsobe, String ime, String prezime, String username, String password) {
	   super(idOsobe, ime, prezime);
	   this.setUsername(username);
	   this.setPassword(password);
   }
   
   @Override
  	public String toString() {
  		return super.toString() + this.getUsername() + " " + this.getPassword();
  		
  	}
   public static int logIn(String username, String password, ArrayList<Korisnik> korisnici) {
	   	String korisnickoIme = username;
	   	String lozinka = password;
	   	if (username.equals("") && password.equals("")){
	   		System.out.println("Dobrodosli!");
			System.out.println("Unesite korisniko ime >> ");
			korisnickoIme = Utility.unesiString(Main.input);
			System.out.println("Unesite lozinku >> ");
			lozinka = Utility.unesiString(Main.input);
	   	}
	   	ArrayList<Korisnik> listaKorisnika;
	   	if (korisnici.size() == 0){
	   		listaKorisnika = gui.Main.listaKorisnika;
	   	}else {
	   		listaKorisnika = korisnici;
	   	}
	   
		for (Korisnik korisnik : listaKorisnika) {
			if (korisnik.username.equals(korisnickoIme) && korisnik.password.equals(lozinka)){
				Main.korisnik = korisnik;
				if (username.equals("") && password.equals("")){
					System.out.println("Uspesno ste se prijavili kao korisnik " + korisnik.ime + " " + korisnik.prezime + ".");
				}
				
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
   

   public static void logOut() throws IOException, ParseException {
	   Main.ulogujSe();
   }
public void setIme(String ime) {
	this.ime = ime;
	
}
public void setPrezime(String prezime) {
	this.prezime = prezime;
	
}
public void setLozinka(String lozinka) {
	this.setPassword(lozinka);
	
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
   
   
   
   

}