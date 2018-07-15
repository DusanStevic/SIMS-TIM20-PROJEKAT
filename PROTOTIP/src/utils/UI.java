package utils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import gui.Main;
import model.Administrator;
import model.Centrala;
import model.Deonica;
import model.ElektronskaNaplata;
import model.Korisnik;
import model.Kvar;
import model.Naplata;
import model.NaplatnaStanica;
import model.NaplatnoMesto;
import model.Operater;
import model.RadnikUCentrali;
import model.SefStanice;
import model.StavkaCenovnika;
import model.TipVozila;



public class UI {
	
	public static void dopuniKorisnikeRadnimMestima(int id) {
		for (Korisnik korisnik : Main.getListaKorisnika()){
			if (korisnik instanceof Operater) {
				Operater operater = (Operater) korisnik;
				for (NaplatnoMesto nm : Main.getListaNaplatnihMesta()){
					if (nm.getIdNaplatnog() == id){
						operater.mestoRada = nm;
					}
				}
			}
		}
	}
	
	public static void otvaranjeNaplatnihMesta() throws NumberFormatException, IOException {
		String sp = System.getProperty("file.separator");
		BufferedReader br = new BufferedReader(new FileReader("." + sp + "data/naplatnaMesta.txt"));
		String red;
		while((red = br.readLine()) != null) {
			int idStanice = Integer.parseInt(red.split("\\|")[0]);
			NaplatnaStanica naplatnaStanica = new NaplatnaStanica(idStanice);
			int idNaplatnogMesta = Integer.parseInt(red.split("\\|")[1]);
			int idOsobe = Integer.parseInt(red.split("\\|")[2]);
			Operater operater = null;
			for (Korisnik korisnik : Main.getListaKorisnika()) {
				if (korisnik instanceof Operater) {
					if (korisnik.getIdOsobe() == idOsobe) {
						operater = (Operater) korisnik;
					}
				}
			}
			
			String[] idKvarova = red.split("\\|")[3].split("\\,");
			ArrayList<Kvar> kvarovi = new ArrayList<Kvar>();
			
			for (String id : idKvarova) {
				Kvar kvar = new Kvar(Integer.parseInt(id));
				kvarovi.add(kvar);
				
			}
			
			Boolean elektronskaNaplataBool = Boolean.parseBoolean(red.split("\\|")[4]);
			ElektronskaNaplata elektronskaNaplata = new ElektronskaNaplata(elektronskaNaplataBool);
			NaplatnoMesto naplatnoMesto = new NaplatnoMesto(naplatnaStanica, idNaplatnogMesta, operater, elektronskaNaplata, kvarovi);
			Main.getListaNaplatnihMesta().add(naplatnoMesto);
		}
	}
	
	public static void dopuniNaplatnaMestaStanicama() throws NumberFormatException, IOException {
		for (NaplatnoMesto naplatnoMesto: Main.getListaNaplatnihMesta()) {
			for (NaplatnaStanica naplatnaStanica : Main.getListaNaplatnihStanica()) {
				if (naplatnoMesto.getNaplatnaStanica().getIdStanice() == naplatnaStanica.getIdStanice()) {
					naplatnoMesto.setNaplatnaStanica(naplatnaStanica);
				}
			}
		}
	}
	public static void otvaranjeNaplatnihStanica() throws NumberFormatException, IOException {
		String sp = System.getProperty("file.separator");
		BufferedReader br = new BufferedReader(new FileReader("." + sp + "data/naplatneStanice.txt"));
		String red;
		while((red = br.readLine()) != null) {
			int idStanice = Integer.parseInt(red.split("\\|")[0]);
			String[] idNaplatnihMesta = red.split("\\|")[1].split("\\,");
			ArrayList<NaplatnoMesto> naplatnaMesta = new ArrayList<NaplatnoMesto>();
			NaplatnoMesto naplatnoMesto = null;
			for (String id : idNaplatnihMesta) {
				for (NaplatnoMesto nm: Main.getListaNaplatnihMesta()){
					if (Integer.parseInt(id) == nm.getIdNaplatnog()) {
						naplatnoMesto = nm;
						naplatnaMesta.add(naplatnoMesto);
					}
				}
			}
			NaplatnaStanica naplatnaStanica = new NaplatnaStanica(idStanice, naplatnaMesta);
			Main.getListaNaplatnihStanica().add(naplatnaStanica);
		}
	}
	
	public static void dopuniNaplatnaMestaKvarovima() {
		for (NaplatnoMesto naplatnoMesto : Main.getListaNaplatnihMesta()) {
			for (Kvar kvar : naplatnoMesto.kvar) {
				for (Kvar kvarr : Main.getListaKvarova()){
					if (kvar.getIdKvara()==kvarr.getIdKvara()){
						kvar = new Kvar(kvarr);
						
					}
				}
			}
		}
	}
	public static void otvaranjeKorisnika() throws IOException, ParseException {
		String sp = System.getProperty("file.separator");
		BufferedReader br = new BufferedReader(new FileReader("." + sp + "data/korisnici.txt"));
		String red;
		while((red = br.readLine()) != null) {
			int idOsobe = Integer.parseInt(red.split("\\|")[0]);
			String ime = red.split("\\|")[1];
			String prezime = red.split("\\|")[2];
			String username = red.split("\\|")[3];
			String password = red.split("\\|")[4];
			
			if (red.split("\\|")[5].equals("administrator")) {
				Administrator administrator = new Administrator(idOsobe, ime, prezime, username, password);
				Main.getListaKorisnika().add(administrator);
			}else if (red.split("\\|")[5].equals("sefStanice")){
				int idStanice = Integer.parseInt(red.split("\\|")[6]);
				NaplatnaStanica ns = new NaplatnaStanica(idStanice);
				SefStanice sefStanice = new SefStanice(idOsobe, ime, prezime, username, password, ns);
				Main.getListaKorisnika().add(sefStanice);
			}else if (red.split("\\|")[5].equals("radnikUCentrali")) {
				String idCentrale = red.split("\\|")[6];
				RadnikUCentrali radnikUCentrali = new RadnikUCentrali(idOsobe, ime, prezime, username, password, idCentrale);
				Main.getListaKorisnika().add(radnikUCentrali);
			}else if (red.split("\\|")[5].equals("operater")){
				int idNaplatnog = Integer.parseInt(red.split("\\|")[6]);
				Operater operater = new Operater(idOsobe, ime, prezime, username, password);
				dopuniKorisnikeRadnimMestima(idNaplatnog);
				Main.getListaKorisnika().add(operater);
			}
		}
	}
	
	public static void otvaranjeKvarova() throws NumberFormatException, IOException, ParseException {
		String sp = System.getProperty("file.separator");
		BufferedReader br = new BufferedReader(new FileReader("." + sp + "data/kvarovi.txt"));
		String red;
		while((red = br.readLine()) != null) {
			int idKvara = Integer.parseInt(red.split("\\|")[0]);
			String opisKvara = red.split("\\|")[1];
			SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
			Date datum = sdf.parse(red.split("\\|")[2]);
			
			int idNaplatnogMesta = Integer.parseInt(red.split("\\|")[3]);
			NaplatnoMesto naplatnoMesto = null;
			for (NaplatnoMesto nm : Main.getListaNaplatnihMesta()) {
				if (nm.getIdNaplatnog() == idNaplatnogMesta) {
					naplatnoMesto = nm;
				}
			}
			Kvar kvar = new Kvar(idKvara, opisKvara, datum, naplatnoMesto);
			Main.getListaKvarova().add(kvar);
		}
		
	}
	
	public static void otvaranjeCentrale() throws NumberFormatException, IOException {
		String sp = System.getProperty("file.separator");
		BufferedReader br = new BufferedReader(new FileReader("." + sp + "data/centrale.txt"));
		String red;
		while((red = br.readLine()) != null) {
			String idCentrale = red.split("\\|")[0];
			String[] idNaplatneStanice = red.split("\\|")[1].split("\\,");
			ArrayList<NaplatnaStanica> naplatneStanice = new ArrayList<NaplatnaStanica>();
			for (String id : idNaplatneStanice) {
				for (NaplatnaStanica naplatnaStanica : Main.getListaNaplatnihStanica()) {
					if (Integer.parseInt(id) == naplatnaStanica.getIdStanice()) {
						naplatneStanice.add(naplatnaStanica);
					}
				}
			}
			String[] idOsobe = red.split("\\|")[2].split("\\,");
			ArrayList<RadnikUCentrali> listaOsoba = new ArrayList<RadnikUCentrali>();
			for (Korisnik korisnik : Main.getListaKorisnika()) {
				for (String id : idOsobe) {
					if (korisnik.getIdOsobe() == Integer.parseInt(id)) {
						listaOsoba.add((RadnikUCentrali) korisnik);
					}
				}
			}
			
			Main.setCentrala(new Centrala(idCentrale, naplatneStanice, listaOsoba));
		}
	}
	
	public static void otvaranjeDeonica() throws NumberFormatException, IOException {
		String sp = System.getProperty("file.separator");
		BufferedReader br = new BufferedReader(new FileReader("." + sp + "data/deonice.txt"));
		String red;
		while((red = br.readLine()) != null) {
			int idPrveStanice = Integer.parseInt(red.split("\\|")[0]);
			NaplatnaStanica prvaNaplatnaStanica = null;
			for (NaplatnaStanica naplatnaStanica: Main.getListaNaplatnihStanica()){
				if (idPrveStanice == naplatnaStanica.getIdStanice()){
					prvaNaplatnaStanica = naplatnaStanica;
				}
			}
			
			int idDrugeStanice = Integer.parseInt(red.split("\\|")[1]);
			NaplatnaStanica drugaNaplatnaStanica = null;
			for (NaplatnaStanica naplatnaStanica : Main.getListaNaplatnihStanica()){
				if (naplatnaStanica.getIdStanice() == idDrugeStanice){
					drugaNaplatnaStanica = naplatnaStanica;
				}
			}
			
			Deonica deonica = new Deonica(prvaNaplatnaStanica, drugaNaplatnaStanica);
			//System.out.println("Deonica pocetna: "+ prvaNaplatnaStanica.idStanice+" druga: "+drugaNaplatnaStanica.idStanice);
			Main.getListaDeonica().add(deonica);
		}
	}

	public static void otvaranjeCenovnika() throws NumberFormatException, IOException {
		String sp = System.getProperty("file.separator");
		BufferedReader br = new BufferedReader(new FileReader("." + sp + "data/cenovnik.txt"));
		String red;
		while((red = br.readLine()) != null) {
			int idPrveStanice = Integer.parseInt(red.split("\\|")[0].split("\\,")[0]);
			int idDrugeStanice = Integer.parseInt(red.split("\\|")[0].split("\\,")[1]);
			
			Deonica deonica = null;
			for (Deonica d : Main.getListaDeonica()){
				if (d.naplatnaStanica1.getIdStanice() == idPrveStanice && d.naplatnaStanica2.getIdStanice() == idDrugeStanice){
					deonica = d;
				}
			}
			
			String[] cenePoKategorijama = red.split("\\|")[1].split("\\,");
			int brojacKategorije = 0;
			TipVozila tip;
			for (String cena : cenePoKategorijama){
				if (brojacKategorije == 0){
					tip = TipVozila.prvaKategorija;
				}else if(brojacKategorije == 1){
					tip = TipVozila.drugaKategorija;
				}else if (brojacKategorije == 2){
					tip = TipVozila.trecaKategorija;
				}else if (brojacKategorije == 3){
					tip = TipVozila.cetvrtaKategorija;
				}else {
					tip = TipVozila.petaKategorija;
				}
				
				StavkaCenovnika stavka = new StavkaCenovnika(deonica, tip, Double.parseDouble(cena));
				brojacKategorije++;
				//Main.cenovnik.stavkaCenovnika.add(stavka);
			}
		}
	}
	
	public static void otvaranjeNaplata() throws NumberFormatException, IOException {
		String sp = System.getProperty("file.separator");
		BufferedReader br = new BufferedReader(new FileReader("." + sp + "data/naplate.txt"));
		String red;
		while((red = br.readLine()) != null) {
			int idNaplate = Integer.parseInt(red.split("\\|")[0]);
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
			Date vreme = null;
			try {
				vreme = sdf.parse(red.split("\\|")[1]);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int idVozila = Integer.parseInt(red.split("\\|")[2]);
			
			TipVozila kategorija = null;
			kategorija = TipVozila.valueOf(red.split("\\|")[3]);
			
			int idPrveStanice = Integer.parseInt(red.split("\\|")[4].split("\\,")[0]);
			int idDrugeStanice = Integer.parseInt(red.split("\\|")[4].split("\\,")[1]);
			NaplatnaStanica drugaNaplatnaStanica = null;
			NaplatnaStanica prvaNaplatnaStanica = null;
			for (NaplatnaStanica naplatnaStanica : Main.getListaNaplatnihStanica()){
				if (naplatnaStanica.getIdStanice() == idDrugeStanice){
					drugaNaplatnaStanica = naplatnaStanica;
				}
			}
			for (NaplatnaStanica naplatnaStanica : Main.getListaNaplatnihStanica()){
				if (naplatnaStanica.getIdStanice() == idPrveStanice){
					prvaNaplatnaStanica = naplatnaStanica;
				}
			}
			
			Deonica deonica = null;
			for (Deonica d : Main.getListaDeonica()){
				if (d.naplatnaStanica1.getIdStanice() == prvaNaplatnaStanica.getIdStanice() && d.naplatnaStanica2.getIdStanice() == drugaNaplatnaStanica.getIdStanice()){
					deonica = d;
				}
			}
			
			Double cena = Double.parseDouble(red.split("\\|")[5]);
			StavkaCenovnika stavkaCenovnika = new StavkaCenovnika(deonica, kategorija, cena);
			Naplata naplata = new Naplata(idNaplate, vreme, idVozila, stavkaCenovnika);
			//System.out.println("Deonica pocetna: "+ prvaNaplatnaStanica.idStanice+" druga: "+drugaNaplatnaStanica.idStanice);
			Main.getNaplate().add(naplata);
			
		}
	}
}
