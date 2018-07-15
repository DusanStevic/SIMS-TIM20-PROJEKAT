package model;
/***********************************************************************
 * Module:  Naplata.java
 * Author:  Korisnik
 * Purpose: Defines the Class Naplata
 ***********************************************************************/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import gui.Main;


public class Naplata {
   public int idNaplate;
   
   public Date vremeNaplate;
   
   public int idVozila;
   
   public StavkaCenovnika stavkaCenovnika;
   
   public static void ispisiZaglavlje() {
		System.out.printf("%15s %20s %13s %9s %11s %20s", "Id naplate", "Vreme naplate", "Id vozila", "Tip vozila", "Deonica", "Cena");
		System.out.println();
	}
   
   public static void ispisiNaplatu(Naplata n) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		String datum = sdf.format(n.vremeNaplate);
		
		System.out.printf("%15s %20s %13s %9s %11s %20s", n.idNaplate, datum, String.valueOf(n.idVozila), n.stavkaCenovnika.tipVozila.toString(), n.stavkaCenovnika.deonica.naplatnaStanica1.getIdStanice() + "-"+ n.stavkaCenovnika.deonica.naplatnaStanica2.getIdStanice(), String.valueOf(n.stavkaCenovnika.cena));
		System.out.println();
	}
   
   Naplata() {
	   
   }
   
   Naplata(int idNaplate, Date vremeNaplate, int idVozila) {
	   this.idNaplate = idNaplate;
	   this.vremeNaplate = vremeNaplate;
	   this.idVozila = idVozila;
   }
   
   public Naplata(int idNaplate, Date vremeNaplate, int idVozila, StavkaCenovnika stavka) {
	   this.idNaplate = idNaplate;
	   this.vremeNaplate = vremeNaplate;
	   this.idVozila = idVozila;
	   this.stavkaCenovnika = stavka;
   }
   
   public void memorisiSe(NaplatnoMesto mesto) throws IOException {
	   String sp = System.getProperty("file.separator");
	   SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	   PrintWriter pw = new PrintWriter(new FileWriter("." + sp + "naplate.txt",true));
	   pw.println(this.idNaplate+"|"+ sdf.format(this.vremeNaplate)+"|"+this.idVozila+"|"+ this.stavkaCenovnika.tipVozila.toString()+"|"+this.stavkaCenovnika.deonica.naplatnaStanica1.getIdStanice()+","+this.stavkaCenovnika.deonica.naplatnaStanica2.getIdStanice()+"|"+this.stavkaCenovnika.cena);
	   pw.close();
	   Main.getNaplate().add(this);
   }

}