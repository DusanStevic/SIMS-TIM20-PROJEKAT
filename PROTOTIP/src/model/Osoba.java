package model;
/***********************************************************************
 * Module:  Osoba.java
 * Author:  marina
 * Purpose: Defines the Class Osoba
 ***********************************************************************/

import java.util.*;


public class Osoba {
	//promenila Maki na protected zato sto ne moze kod otvaranja drugacije
   private int idOsobe;
   protected String ime;
   protected String prezime;
   
   Osoba() {
	   
   }
   
   Osoba(int idOsobe, String ime, String prezime){
	   this.setIdOsobe(idOsobe);
	   this.setIme(ime);
	   this.setPrezime(prezime);
   }
   
   @Override
	public String toString() {
		
		return this.getIdOsobe() + " " + this.getIme() + " " + this.getPrezime();
	}

public int getIdOsobe() {
	return idOsobe;
}

public void setIdOsobe(int idOsobe) {
	this.idOsobe = idOsobe;
}

public String getIme() {
	return ime;
}

public void setIme(String ime) {
	this.ime = ime;
}

public String getPrezime() {
	return prezime;
}

public void setPrezime(String prezime) {
	this.prezime = prezime;
}

}