package model;
/***********************************************************************
 * Module:  StavkaCenovnika.java
 * Author:  Korisnik
 * Purpose: Defines the Class StavkaCenovnika
 ***********************************************************************/

import java.util.*;

public class StavkaCenovnika {
   public double cena;            //menjano da bih videla iz neke klase
   public TipVozila tipVozila;
   
   public Deonica deonica;
   
  
   
   public StavkaCenovnika(Deonica deonica, TipVozila tipVozila, double cena){
	   this.deonica = deonica;
	   this.tipVozila = tipVozila;
	   this.cena = cena;
   }
   
   public String toString() {
	   return this.deonica + " " + this.tipVozila + " " + this.cena;
   }
   public boolean uporediStavke(String polaznaStanica, String dolaznaStanica, TipVozila tipVozila) {
      // TODO: implement
      return false;
   }

}