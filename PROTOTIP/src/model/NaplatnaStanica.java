package model;
/***********************************************************************
 * Module:  NaplatnaStanica.java
 * Author:  Korisnik
 * Purpose: Defines the Class NaplatnaStanica
 ***********************************************************************/

import java.util.*;

public class NaplatnaStanica {
   private int idStanice;//Maki promenila na protected
   
   public ArrayList<NaplatnoMesto> naplatnoMesto = new ArrayList<NaplatnoMesto>();
   
   NaplatnaStanica(NaplatnaStanica ns){
	   this.setIdStanice(ns.getIdStanice());
	   for (NaplatnoMesto nm : naplatnoMesto){
		   naplatnoMesto.add(nm);
	   }
   }
  
   public NaplatnaStanica(int idStanice){
	   this.setIdStanice(idStanice);
   }
   public NaplatnaStanica(int idStanice, ArrayList<NaplatnoMesto> naplatnaMesta) {
	   this.setIdStanice(idStanice);
	   this.naplatnoMesto = naplatnaMesta;
   }
   
   @Override
   public String toString() {
   		String naplatnaMesta = "";
   		for (NaplatnoMesto nm : this.naplatnoMesto){
   			naplatnaMesta += nm.getIdNaplatnog();
   			naplatnaMesta += " ";
   		}
   		
   		return this.getIdStanice() + " " + naplatnaMesta;
   		
   	}
   public void izvestajZaradaInterval(java.util.Date pocetni, Date krajnji) {
      // TODO: implement
   }
   
   public void izvestajBrojVozilaInterval(Date pocetni, Date krajnji) {
      // TODO: implement
   }
   
   public void izvestajVrstaVozilaInterval(Date pocetni, Date krajnji) {
      // TODO: implement
   }

public int getIdStanice() {
	return idStanice;
}

public void setIdStanice(int idStanice) {
	this.idStanice = idStanice;
}
   
   
}