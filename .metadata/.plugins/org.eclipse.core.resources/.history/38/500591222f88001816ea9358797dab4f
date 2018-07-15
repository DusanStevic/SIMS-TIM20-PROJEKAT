package probniPrototip;
/***********************************************************************
 * Module:  Operater.java
 * Author:  marina
 * Purpose: Defines the Class Operater
 ***********************************************************************/

import java.util.*;

public class Operater extends Korisnik {
	public NaplatnoMesto mestoRada;
	
	
	Operater() {
		
	}
	
	Operater(int idOsobe, String ime, String prezime, String username, String password, int idNaplatnog) {
		super(idOsobe, ime, prezime, username, password);
		this.mestoRada = new NaplatnoMesto(idNaplatnog);
	}
	
	 @Override
	public String toString() {
		
		return this.idOsobe + " " + this.ime + " " + this.prezime + " " + this.mestoRada;
	}
	
	public static void meniOperatera() {
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
		
	}
	
	public static void naplata() {
		
	}
	
	public static void postaviX() {
		
	}
}