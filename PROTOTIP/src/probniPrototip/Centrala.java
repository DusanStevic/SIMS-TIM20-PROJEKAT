package probniPrototip;
/***********************************************************************
 * Module:  Centrala.java
 * Author:  Korisnik
 * Purpose: Defines the Class Centrala
 ***********************************************************************/

import java.util.*;

public class Centrala {
	String idCentrale;
   public ArrayList<NaplatnaStanica> naplatnaStanica = new ArrayList<NaplatnaStanica>();
   public ArrayList<RadnikUCentrali> radniciUCentrali = new ArrayList<RadnikUCentrali>();
   
   Centrala() {
	   
   }
   
   Centrala(String idCentrale){
	   this.idCentrale = idCentrale;
   }
   
   Centrala(String idCentrale, ArrayList<NaplatnaStanica> naplatnaStanica, ArrayList<RadnikUCentrali> radniciUCentrali) {
	   this.idCentrale = idCentrale;
	   this.naplatnaStanica = naplatnaStanica;
	   this.radniciUCentrali = radniciUCentrali;
   }
   
   public String toString() {
	   String naplatneStanice = "";
	   String radnici = "";
	   
	   for (NaplatnaStanica ns : naplatnaStanica){
		   naplatneStanice += ns.toString();
		   naplatneStanice += " ";
	   }
	   
	   for (RadnikUCentrali r : radniciUCentrali){
		   radnici += r.toString();
		   radnici+= " ";
	   }
	   
	   return this.idCentrale + "\n" + naplatneStanice + "\n" + radnici;
   }

   
}