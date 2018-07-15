package probniPrototip;
/***********************************************************************
 * Module:  NaplatnaStanica.java
 * Author:  Korisnik
 * Purpose: Defines the Class NaplatnaStanica
 ***********************************************************************/

import java.util.*;

public class NaplatnaStanica {
   protected int idStanice;//Maki promenila na protected
   
   public ArrayList<NaplatnoMesto> naplatnoMesto = new ArrayList<NaplatnoMesto>();
   
   NaplatnaStanica(NaplatnaStanica ns){
	   this.idStanice = ns.idStanice;
	   for (NaplatnoMesto nm : naplatnoMesto){
		   naplatnoMesto.add(nm);
	   }
   }
  
   NaplatnaStanica(int idStanice){
	   this.idStanice = idStanice;
   }
   NaplatnaStanica(int idStanice, ArrayList<NaplatnoMesto> naplatnaMesta) {
	   this.idStanice = idStanice;
	   this.naplatnoMesto = naplatnaMesta;
   }
   
   @Override
   public String toString() {
   		String naplatnaMesta = "";
   		for (NaplatnoMesto nm : this.naplatnoMesto){
   			naplatnaMesta += nm.idNaplatnog;
   			naplatnaMesta += " ";
   		}
   		
   		return this.idStanice + " " + naplatnaMesta;
   		
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
   
   
}