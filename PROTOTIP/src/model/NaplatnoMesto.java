package model;
/***********************************************************************
 * Module:  NaplatnoMesto.java
 * Author:  Korisnik
 * Purpose: Defines the Class NaplatnoMesto
 ***********************************************************************/

import java.util.*;

public class NaplatnoMesto {

   private NaplatnaStanica naplatnaStanica;
   private int idNaplatnog;
   public Operater zaposlenOperater;
   public StanjeNaplatnogMesta stanjeNaplatnogMesta;
   public ElektronskaNaplata elektronskaNaplata;
   public ArrayList<Kvar> kvar = new ArrayList<Kvar>();
   
   NaplatnoMesto(NaplatnoMesto nm){
	   this.setNaplatnaStanica(new NaplatnaStanica(nm.getNaplatnaStanica()));
	   this.setIdNaplatnog(nm.getIdNaplatnog());
	   this.zaposlenOperater = nm.zaposlenOperater;
	   this.elektronskaNaplata = nm.elektronskaNaplata;
	   for (Kvar k : nm.kvar){
		   kvar.add(k);
	   }
   }
   
   NaplatnoMesto(int idNaplatnog) {
	   this.setIdNaplatnog(idNaplatnog);
   }
   
   public NaplatnoMesto(NaplatnaStanica naplatnaStanica, int idNaplatnog, Operater zaposlenOperater, ElektronskaNaplata elektronskaNaplata, ArrayList<Kvar> kvar) {
	   this.setNaplatnaStanica(naplatnaStanica);
	   this.setIdNaplatnog(idNaplatnog);
	   this.zaposlenOperater = zaposlenOperater;
	   this.elektronskaNaplata = elektronskaNaplata;
	   this.kvar = kvar;
   }
   
   @Override
   public String toString() {
	   	String kvarovi = "";
	   	for (Kvar k : kvar){
	   		kvarovi += " ";
	   	}
  		return this.getNaplatnaStanica().toString() + " " + this.getIdNaplatnog() + " " + this.zaposlenOperater.getIdOsobe() + " " + String.valueOf(this.elektronskaNaplata.aktivna) + kvarovi;
  		
  	}
   public void naplati() {
      // TODO: implement
   }
   
   public void prijaviKvar() {
      // TODO: implement
   }
   
   public void podigniRampu() {
      // TODO: implement
   }
   
   public void spustiRampu() {
      // TODO: implement
   }
   
   public void zatvoriMesto() {
      // TODO: implement
   }
   
   public void uvidUCenovnik(Cenovnik cenovnik) {
      // TODO: implement
   }

public int getIdNaplatnog() {
	return idNaplatnog;
}

public void setIdNaplatnog(int idNaplatnog) {
	this.idNaplatnog = idNaplatnog;
}

public NaplatnaStanica getNaplatnaStanica() {
	return naplatnaStanica;
}

public void setNaplatnaStanica(NaplatnaStanica naplatnaStanica) {
	this.naplatnaStanica = naplatnaStanica;
}
   

}