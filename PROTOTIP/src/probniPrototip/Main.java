package probniPrototip;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	static Centrala centrala;
	static Cenovnik cenovnik = new Cenovnik();
	static boolean prvi = true;
	static Scanner input = new Scanner(System.in);
	static ArrayList<Korisnik> listaKorisnika = new ArrayList<Korisnik>();
	static ArrayList<NaplatnoMesto> listaNaplatnihMesta = new ArrayList<NaplatnoMesto>();
	static ArrayList<NaplatnaStanica> listaNaplatnihStanica = new ArrayList<NaplatnaStanica>();
	static ArrayList<Kvar> listaKvarova = new ArrayList<Kvar>();
	static ArrayList<Deonica> listaDeonica = new ArrayList<Deonica>();
	
	public static void main(String[] args) {
			
			Main.openAll();
			Main.ispisiSve();
			Main.ulogujSe();
		
	}
	
	public static void openAll() {
		try {
			UI.otvaranjeKorisnika();
			UI.otvaranjeNaplatnihMesta();
			UI.otvaranjeNaplatnihStanica();
			UI.dopuniKorisnikeRadnimMestima();
			UI.dopuniNaplatnaMestaStanicama();
			UI.otvaranjeKvarova();
			UI.dopuniNaplatnaMestaKvarovima();
			UI.otvaranjeDeonica();
			UI.otvaranjeCentrale();
			UI.otvaranjeCenovnika();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void ulogujSe(){ 
		
		boolean uslov = true;
		if (Main.prvi == false) {
			System.out.println("Da li zelite da ugasite program(DA/NE)? ");
			String odgovor = Utility.unesiOdluku(input);
			if (odgovor.equalsIgnoreCase("da")) {
				uslov = false;
			}
		}
		while (uslov == true){
			prvi = false;
			int rez = Korisnik.logIn();
			if (rez == 0) {
				System.out.println("Uspesno ste se ulogovali kao administrator.");
				Administrator.meniAdministratora();
				break;
			}else if (rez == 1) {
				System.out.println("Uspesno ste se ulogovali kao radnik u centrali.");
				RadnikUCentrali.meniRadnikaUCentrali();
				break;
			}else if (rez == 2) {
				System.out.println("Uspesno ste se ulogovali kao sef stanice.");
				SefStanice.meniSefaStanice();
				break;
			}else if (rez == 3) {
				System.out.println("Uspesno ste se ulogovali kao operater.");
				Operater.meniOperatera();
				break;
			}else {
				System.out.println("Neodgovarajuci unos korisnickog imena ili lozinke. Da li zelite da pokusate ponovo(DA/NE) ");
				String odgovor = Utility.unesiOdluku(input);
				if (odgovor.equalsIgnoreCase("ne")) {
					break;
				}
			}
		}	
	}


	public static void ispisiSve() {
		
		/*
		System.out.println("KORISNICI");
		for (Korisnik k : Main.listaKorisnika){
			System.out.println(k);
		}*/
		/*
		System.out.println("NAPLATNA MESTA");
		for (NaplatnoMesto nm : Main.listaNaplatnihMesta){
			System.out.println(nm);
		}
		*/
		/*
		for (NaplatnaStanica stanica : Main.listaNaplatnihStanica){
			for (NaplatnoMesto nm : Main.listaNaplatnihMesta){
				System.out.println(nm);
			}
			System.out.println("\n");
		}*/
		/*
		System.out.println(centrala.idCentrale);
		for (NaplatnaStanica ns : centrala.naplatnaStanica){
			System.out.println(ns);
		}*/
		/*
		for (Deonica deonica : Main.listaDeonica){
			System.out.println(deonica);
		}*/
		
		/*
		System.out.println("\n");
		System.out.println("KVAROVI");
		for (Kvar kvar : Main.listaKvarova){
			System.out.println(kvar);
		}*/
		
		/*
		System.out.println(cenovnik.stavkaCenovnika.size());
		for (StavkaCenovnika stavka : cenovnik.stavkaCenovnika){
			System.out.println(stavka);
		}
		*/
	}


}
