package probniPrototip;
/***********************************************************************
 * Module:  SefStanice.java
 * Author:  marina
 * Purpose: Defines the Class SefStanice
 ***********************************************************************/

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class SefStanice extends Korisnik {
	SefStanice() {
		
	}
	SefStanice(int idOsobe, String ime, String prezime, String username, String password) {
		super(idOsobe, ime, prezime, username, password);
		
	}
	
	public static void meniSefaStanice() {
		boolean uslov = true;
		while (true) {
			System.out.println("Opcije koje su vam ponudjene.");
			System.out.println("1. Pregled izvestaja.");
			System.out.println("2. Unos cena za deonice.");
			System.out.println("3. Pregled kvarova.");
			System.out.println("4. Exit.");
			System.out.println("Vas odgovor >> ");
			int odgovor = Utility.unesiInt(Main.input);
			switch(odgovor) {
			case 1:
				pregledIzvestaja();
				break;
			case 2:
				unosCenaZaDeonice();
				break;
			case 3:
				pregledKvarova();
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
	
	public static void pregledIzvestaja() {
		
		boolean uslov = true;
		while (true) {
			System.out.println("Opcije koje su vam ponudjene.");
			System.out.println("1. Izaberi datum.");
			System.out.println("2. Izbari period.");
			System.out.println("3. Izaberi tip vozila.");
			System.out.println("4. Exit.");
			System.out.println("Vas odgovor >> ");
			int odgovor = Utility.unesiInt(Main.input);
			switch(odgovor) {
			case 1:
				kriterijumDatum();
				break;
			case 2:
				kriterijumPeriod();
				break;
			case 3:
				kriterijumTipVozila();
				break;
			
			case 4:

				uslov = false;
				break;
		}	
		if (uslov == false) {
			break;
		}
		}
		
	}
	
	public static void kriterijumDatum() {
		
	}
	
	public static void kriterijumPeriod() {
		
	}
	
	public static void kriterijumTipVozila() {
		
	}
	public static void unosCenaZaDeonice() {
		
	}
	
	public static void pregledKvarova() {
		
	}
}

