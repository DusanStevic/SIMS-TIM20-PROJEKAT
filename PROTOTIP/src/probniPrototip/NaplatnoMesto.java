package probniPrototip;
/***********************************************************************
 * Module:  NaplatnoMesto.java
 * Author:  Korisnik
 * Purpose: Defines the Class NaplatnoMesto
 ***********************************************************************/

import java.util.*;

public class NaplatnoMesto {

   NaplatnaStanica naplatnaStanica;
   protected int idNaplatnog;
   public Operater zaposlenOperater;
   public StanjeNaplatnogMesta stanjeNaplatnogMesta;
   public ElektronskaNaplata elektronskaNaplata;
   public ArrayList<Kvar> kvar = new ArrayList<Kvar>();
   
   NaplatnoMesto(NaplatnoMesto nm){
	   this.naplatnaStanica = new NaplatnaStanica(nm.naplatnaStanica);
	   this.idNaplatnog = nm.idNaplatnog;
	   this.zaposlenOperater = nm.zaposlenOperater;
	   this.elektronskaNaplata = nm.elektronskaNaplata;
	   for (Kvar k : nm.kvar){
		   kvar.add(k);
	   }
   }
   
   NaplatnoMesto(int idNaplatnog) {
	   this.idNaplatnog = idNaplatnog;
   }
   
   NaplatnoMesto(NaplatnaStanica naplatnaStanica, int idNaplatnog, Operater zaposlenOperater, ElektronskaNaplata elektronskaNaplata, ArrayList<Kvar> kvar) {
	   this.naplatnaStanica = naplatnaStanica;
	   this.idNaplatnog = idNaplatnog;
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
  		return this.naplatnaStanica.toString() + " " + this.idNaplatnog + " " + this.zaposlenOperater.idOsobe + " " + String.valueOf(this.elektronskaNaplata.aktivna) + kvarovi;
  		
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
   

}