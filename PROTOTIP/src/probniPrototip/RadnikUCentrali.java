package probniPrototip;
/***********************************************************************
 * Module:  RadnikUCentrali.java
 * Author:  marina
 * Purpose: Defines the Class RadnikUCentrali
 ***********************************************************************/

import java.util.*;

public class RadnikUCentrali extends Korisnik {
	Centrala zaposlenUCentrali;
	 @Override
	public String toString() {
		return super.toString() + this.zaposlenUCentrali.toString();
		
	}
	RadnikUCentrali() {
		
	}
	RadnikUCentrali(int idOsobe, String ime, String prezime, String username, String password, String idCentrale) {
		super(idOsobe, ime, prezime, username, password);
		zaposlenUCentrali = new Centrala(idCentrale);
	}
	
	public static void meniRadnikaUCentrali() {
		boolean uslov = true;
		while (true) {
			System.out.println("Kriterijum za pravljenje izvestaja.");
			System.out.println("1. Naplatna stanica.");
			System.out.println("2. Datum.");
			System.out.println("3. Period.");
			System.out.println("4. Tip vozila.");
			System.out.println("5. Exit.");
			System.out.println("Vas odgovor >> ");
			int odgovor = Utility.unesiInt(Main.input);
			switch(odgovor) {
			case 1:
				izvestajNaplatnaStanica();
				break;
			case 2:
				izvestajDatum();
				break;
			case 3:
				izvestajPeriod();
				break;
			case 4:
				izvestajTipVozila();
				break;
			
			case 5:
				Korisnik.logOut();
				uslov = false;
				break;
		}	
		if (uslov == false) {
			break;
		}
		}
	}
	
	public static void izvestajNaplatnaStanica() {
		
	}
	
	public static void izvestajDatum() {
		
	}
	
	public static void izvestajPeriod() {
		
	}
	
	public static void izvestajTipVozila() {
		
	}
}