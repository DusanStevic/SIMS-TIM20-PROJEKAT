package model;
/***********************************************************************
 * Module:  Kvar.java
 * Author:  marina
 * Purpose: Defines the Class Kvar
 ***********************************************************************/

import java.text.SimpleDateFormat;
import java.util.*;

/** @pdOid a8c1d345-c153-4fc8-9e44-cf9e8b964096 */
public class Kvar {
  
   private int idKvara;//moralo da se promeni-Maki
   protected String opisKvara;
   protected Date datumKvara;
   
   
   public NaplatnoMesto naplatnoMesto;
   
   public static void ispisiZaglavlje() {
		System.out.printf("%15s %20s %13s", "Id kvara", "Opis kvara", "Datum kvara");
		System.out.println();
	}
  
  public static void ispisiKvar(Kvar k) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.mm.yyyy");
		String datum = sdf.format(k.datumKvara);
		
		System.out.printf("%15s %20s %13s", String.valueOf(k.getIdKvara()), datum, k.opisKvara);
		System.out.println();
	}
   
   public Kvar(int idKvara){
	   this.setIdKvara(idKvara);
   }
   
   public Kvar(Kvar kvar){
	   this.setIdKvara(kvar.getIdKvara());
	   this.opisKvara = kvar.opisKvara;
	   this.naplatnoMesto = new NaplatnoMesto(kvar.naplatnoMesto);
   }
   
   public Kvar(int idKvara, String opisKvara, Date datumKvara, NaplatnoMesto naplatnoMesto) {
	   this.setIdKvara(idKvara);
	   this.opisKvara = opisKvara;
	   this.datumKvara = datumKvara;
	   this.naplatnoMesto = naplatnoMesto;
   }

   public String toString() {
	   return this.getIdKvara() + " " + this.opisKvara + " " + this.datumKvara + " " + this.naplatnoMesto;
   }

public int getIdKvara() {
	return idKvara;
}

public void setIdKvara(int idKvara) {
	this.idKvara = idKvara;
}
}