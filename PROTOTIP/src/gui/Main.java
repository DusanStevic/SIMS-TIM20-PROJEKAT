package gui;


import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Administrator;
import model.Cenovnik;
import model.Centrala;
import model.Deonica;
import model.Korisnik;
import model.Kvar;
import model.Naplata;
import model.NaplatnaStanica;
import model.NaplatnoMesto;
import model.Operater;
import model.RadnikUCentrali;
import model.SefStanice;
import utils.UI;
import utils.Utility;
import view.LoginDemo;
import view.Menu;


public class Main {
	public static Korisnik korisnik;
	private static Centrala centrala;
	static Cenovnik cenovnik = new Cenovnik();
	static boolean prvi = true;
	public static Scanner input = new Scanner(System.in);
	
	private static ArrayList<NaplatnoMesto> listaNaplatnihMesta = new ArrayList<NaplatnoMesto>();
	private static ArrayList<NaplatnaStanica> listaNaplatnihStanica = new ArrayList<NaplatnaStanica>();
	private static ArrayList<Korisnik> listaKorisnika = new ArrayList<Korisnik>();
	private static ArrayList<Kvar> listaKvarova = new ArrayList<Kvar>();
	private static ArrayList<Deonica> listaDeonica = new ArrayList<Deonica>();
	private static ArrayList<Naplata> naplate=new ArrayList<Naplata>();
	
	public static void main(String[] args) throws IOException, ParseException {
			
			Main.openAll();
			Main.ispisiSve();
			
			LoginDemo ld=new LoginDemo();
			Korisnik ulogovani=ld.me(getListaKorisnika());
			Menu menu = new Menu(ulogovani);
			//System.out.println(ulogovani.getIme());
		
	}
	
	public static void openAll() {
		try {
			;
			UI.otvaranjeNaplatnihMesta();
			UI.otvaranjeNaplatnihStanica();
			UI.otvaranjeKorisnika();
			//UI.dopuniKorisnikeRadnimMestima();
			UI.dopuniNaplatnaMestaStanicama();
			UI.otvaranjeKvarova();
			UI.dopuniNaplatnaMestaKvarovima();
			UI.otvaranjeDeonica();
			UI.otvaranjeCentrale();
			UI.otvaranjeCenovnika();
			UI.otvaranjeNaplata();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void ulogujSe() throws IOException, ParseException{ 
		
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

	public static ArrayList<NaplatnoMesto> getListaNaplatnihMesta() {
		return listaNaplatnihMesta;
	}

	public static void setListaNaplatnihMesta(ArrayList<NaplatnoMesto> listaNaplatnihMesta) {
		Main.listaNaplatnihMesta = listaNaplatnihMesta;
	}

	public static ArrayList<Korisnik> getListaKorisnika() {
		return listaKorisnika;
	}

	public static void setListaKorisnika(ArrayList<Korisnik> listaKorisnika) {
		Main.listaKorisnika = listaKorisnika;
	}

	public static ArrayList<Naplata> getNaplate() {
		return naplate;
	}

	public static void setNaplate(ArrayList<Naplata> naplate) {
		Main.naplate = naplate;
	}

	public static ArrayList<Deonica> getListaDeonica() {
		return listaDeonica;
	}

	public static void setListaDeonica(ArrayList<Deonica> listaDeonica) {
		Main.listaDeonica = listaDeonica;
	}

	public static ArrayList<NaplatnaStanica> getListaNaplatnihStanica() {
		return listaNaplatnihStanica;
	}

	public static void setListaNaplatnihStanica(ArrayList<NaplatnaStanica> listaNaplatnihStanica) {
		Main.listaNaplatnihStanica = listaNaplatnihStanica;
	}

	public static ArrayList<Kvar> getListaKvarova() {
		return listaKvarova;
	}

	public static void setListaKvarova(ArrayList<Kvar> listaKvarova) {
		Main.listaKvarova = listaKvarova;
	}

	public static Centrala getCentrala() {
		return centrala;
	}

	public static void setCentrala(Centrala centrala) {
		Main.centrala = centrala;
	}

	public static Korisnik getKorisnik() {
		return korisnik;
	}

	public static void setKorisnik(Korisnik korisnik) {
		Main.korisnik = korisnik;
	}


}
