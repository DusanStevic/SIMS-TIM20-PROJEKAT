package model;
/***********************************************************************
 * Module:  Operater.java
 * Author:  marina
 * Purpose: Defines the Class Operater
 ***********************************************************************/

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import gui.Main;
import utils.Utility;

public class Operater extends Korisnik {
	public static NaplatnoMesto mestoRada;
	
	
	Operater() {
		
	}
	
	public Operater(int idOsobe, String ime, String prezime, String username, String password) {
		super(idOsobe, ime, prezime, username, password);
		
		//this.mestoRada = new NaplatnoMesto(idNaplatnog);
	}
	
	 @Override
	public String toString() {
		
		return this.getIdOsobe() + " " + this.getIme() + " " + this.getPrezime() + " " + this.mestoRada;
	}
	
	public static void meniOperatera() throws IOException, ParseException {
		boolean uslov = true;
		while (true) {
			System.out.println("Opcije koje su vam ponudjene.");
			System.out.println("1. Podizanje rampe.");
			System.out.println("2. Naplata.");
			System.out.println("3. Postavi X.");
			System.out.println("4. Exit.");
			System.out.println("Vas odgovor >> ");
			int odgovor = Utility.unesiInt(Main.input);
			switch(odgovor) {
			case 1:
				podizanjeRampe();
				break;
			case 2:
				naplata();
				break;
			case 3:
				postaviX();
				break;
			
			case 4:
				Korisnik.logOut();
				uslov = false;
				break;
		}	
		if (uslov == false) {
			break;
		}
		}
	}
	
	public static void podizanjeRampe() {
		System.out.println("Pritisnuto dugme za podizanje rampe.");
		
	}
	
	public static void naplata() throws IOException, ParseException {
		ManuelnaNaplata mn=new ManuelnaNaplata();
		int opcija=0;
		int deo1=0;
		int deo2=0;
		int brojac=0;
		boolean flag=false;
		Deonica izabrana=null;
		while(!flag){
			System.out.println("Unesite deonicu: ");
			deo1=Utility.unesiInt(Main.input);
			deo2=Utility.unesiInt(Main.input);
			for(Deonica d: Main.getListaDeonica()){
				if(d.naplatnaStanica1.getIdStanice()==deo1 && d.naplatnaStanica2.getIdStanice()==deo2){
					
					flag=true;
					izabrana=d;
				}
				brojac++;
			}
			if(brojac==Main.getListaDeonica().size()-1 && flag==false){
				System.out.println("Nepostojeca deonica,pokusajte ponovo.");
			}
		}
		
		while(opcija!=1 && opcija!=2 && opcija!=3 && opcija!=4 && opcija!=5 ){
			System.out.println("Odaberite kategoriju vozila: \n1.\n2.\n3.\n4.\n5.");
			opcija = Utility.unesiInt(Main.input);
		}
		TipVozila tp=null;
		if(opcija==1){
			tp=TipVozila.prvaKategorija;
		}else if(opcija==2){
			tp=TipVozila.drugaKategorija;
		}else if(opcija==3){
			tp=TipVozila.trecaKategorija;
		}else if(opcija==4){
			tp=TipVozila.cetvrtaKategorija;
		}else if(opcija==5){
			tp=TipVozila.petaKategorija;
		}
		/* for(StavkaCenovnika sc: Main.cenovnik.stavkaCenovnika){
	        	if(sc.deonica.naplatnaStanica1==izabrana.naplatnaStanica1 && sc.deonica.naplatnaStanica2==izabrana.naplatnaStanica2 && sc.tipVozila==tp){
	        		mn.stavkaCenovnika=sc;
	        		System.out.println("Naplaceno je:" + mn.stavkaCenovnika.cena);
	        		
	        	}
	        }*/
		 brojac=0;
		 SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		 int min1=1;int max1=1000;
		 int randomNum2 = ThreadLocalRandom.current().nextInt(min1, max1 + 1);
		 mn.idNaplate=randomNum2;
		 int min=1;int max=100;
		 int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
		 Date d=new Date();
		 String df=sdf.format(d);
		 mn.vremeNaplate=sdf.parse(df);
		 mn.idVozila=randomNum;
		 mn.memorisiSe(mestoRada);
	}
	
	public static void postaviX() {
		System.out.println("Naplatno mesto ugaseno. Pritisnut x.");
		
		
	}
}