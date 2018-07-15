package probniPrototip;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class UI {
	
	public static void dopuniKorisnikeRadnimMestima() {
		for (Korisnik korisnik : Main.listaKorisnika){
			if (korisnik instanceof Operater) {
				Operater operater = (Operater) korisnik;
				for (NaplatnoMesto nm : Main.listaNaplatnihMesta){
					if (nm.idNaplatnog == operater.mestoRada.idNaplatnog){
						operater.mestoRada = nm;
					}
				}
			}
		}
	}
	
	public static void otvaranjeNaplatnihMesta() throws NumberFormatException, IOException {
		String sp = System.getProperty("file.separator");
		BufferedReader br = new BufferedReader(new FileReader("." + sp + "naplatnaMesta.txt"));
		String red;
		while((red = br.readLine()) != null) {
			int idStanice = Integer.parseInt(red.split("\\|")[0]);
			NaplatnaStanica naplatnaStanica = new NaplatnaStanica(idStanice);
			int idNaplatnogMesta = Integer.parseInt(red.split("\\|")[1]);
			int idOsobe = Integer.parseInt(red.split("\\|")[2]);
			Operater operater = null;
			for (Korisnik korisnik : Main.listaKorisnika) {
				if (korisnik instanceof Operater) {
					if (korisnik.idOsobe == idOsobe) {
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
			Main.listaNaplatnihMesta.add(naplatnoMesto);
		}
	}
	
	public static void dopuniNaplatnaMestaStanicama() throws NumberFormatException, IOException {
		for (NaplatnoMesto naplatnoMesto: Main.listaNaplatnihMesta) {
			for (NaplatnaStanica naplatnaStanica : Main.listaNaplatnihStanica) {
				if (naplatnoMesto.naplatnaStanica.idStanice == naplatnaStanica.idStanice) {
					naplatnoMesto.naplatnaStanica = naplatnaStanica;
				}
			}
		}
	}
	public static void otvaranjeNaplatnihStanica() throws NumberFormatException, IOException {
		String sp = System.getProperty("file.separator");
		BufferedReader br = new BufferedReader(new FileReader("." + sp + "naplatneStanice.txt"));
		String red;
		while((red = br.readLine()) != null) {
			int idStanice = Integer.parseInt(red.split("\\|")[0]);
			String[] idNaplatnihMesta = red.split("\\|")[1].split("\\,");
			ArrayList<NaplatnoMesto> naplatnaMesta = new ArrayList<NaplatnoMesto>();
			NaplatnoMesto naplatnoMesto = null;
			for (String id : idNaplatnihMesta) {
				for (NaplatnoMesto nm: Main.listaNaplatnihMesta){
					if (Integer.parseInt(id) == nm.idNaplatnog) {
						naplatnoMesto = nm;
						naplatnaMesta.add(naplatnoMesto);
					}
				}
			}
			NaplatnaStanica naplatnaStanica = new NaplatnaStanica(idStanice, naplatnaMesta);
			Main.listaNaplatnihStanica.add(naplatnaStanica);
		}
	}
	
	public static void dopuniNaplatnaMestaKvarovima() {
		for (NaplatnoMesto naplatnoMesto : Main.listaNaplatnihMesta) {
			for (Kvar kvar : naplatnoMesto.kvar) {
				for (Kvar kvarr : Main.listaKvarova){
					if (kvar.idKvara==kvarr.idKvara){
						kvar = new Kvar(kvarr);
						
					}
				}
			}
		}
	}
	public static void otvaranjeKorisnika() throws IOException, ParseException {
		String sp = System.getProperty("file.separator");
		BufferedReader br = new BufferedReader(new FileReader("." + sp + "korisnici.txt"));
		String red;
		while((red = br.readLine()) != null) {
			int idOsobe = Integer.parseInt(red.split("\\|")[0]);
			String ime = red.split("\\|")[1];
			String prezime = red.split("\\|")[2];
			String username = red.split("\\|")[3];
			String password = red.split("\\|")[4];
			
			if (red.split("\\|")[5].equals("administrator")) {
				Administrator administrator = new Administrator(idOsobe, ime, prezime, username, password);
				Main.listaKorisnika.add(administrator);
			}else if (red.split("\\|")[5].equals("sefStanice")){
				SefStanice sefStanice = new SefStanice(idOsobe, ime, prezime, username, password);
				Main.listaKorisnika.add(sefStanice);
			}else if (red.split("\\|")[5].equals("radnikUCentrali")) {
				String idCentrale = red.split("\\|")[6];
				RadnikUCentrali radnikUCentrali = new RadnikUCentrali(idOsobe, ime, prezime, username, password, idCentrale);
				Main.listaKorisnika.add(radnikUCentrali);
			}else if (red.split("\\|")[5].equals("operater")){
				int idNaplatnog = Integer.parseInt(red.split("\\|")[6]);
				Operater operater = new Operater(idOsobe, ime, prezime, username, password, idNaplatnog);
				Main.listaKorisnika.add(operater);
			}
		}
	}
	
	public static void otvaranjeKvarova() throws NumberFormatException, IOException, ParseException {
		String sp = System.getProperty("file.separator");
		BufferedReader br = new BufferedReader(new FileReader("." + sp + "kvarovi.txt"));
		String red;
		while((red = br.readLine()) != null) {
			int idKvara = Integer.parseInt(red.split("\\|")[0]);
			String opisKvara = red.split("\\|")[1];
			SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
			Date datum = sdf.parse(red.split("\\|")[2]);
			
			int idNaplatnogMesta = Integer.parseInt(red.split("\\|")[3]);
			NaplatnoMesto naplatnoMesto = null;
			for (NaplatnoMesto nm : Main.listaNaplatnihMesta) {
				if (nm.idNaplatnog == idNaplatnogMesta) {
					naplatnoMesto = nm;
				}
			}
			Kvar kvar = new Kvar(idKvara, opisKvara, datum, naplatnoMesto);
			Main.listaKvarova.add(kvar);
		}
		
	}
	
	public static void otvaranjeCentrale() throws NumberFormatException, IOException {
		String sp = System.getProperty("file.separator");
		BufferedReader br = new BufferedReader(new FileReader("." + sp + "centrale.txt"));
		String red;
		while((red = br.readLine()) != null) {
			String idCentrale = red.split("\\|")[0];
			String[] idNaplatneStanice = red.split("\\|")[1].split("\\,");
			ArrayList<NaplatnaStanica> naplatneStanice = new ArrayList<NaplatnaStanica>();
			for (String id : idNaplatneStanice) {
				for (NaplatnaStanica naplatnaStanica : Main.listaNaplatnihStanica) {
					if (Integer.parseInt(id) == naplatnaStanica.idStanice) {
						naplatneStanice.add(naplatnaStanica);
					}
				}
			}
			String[] idOsobe = red.split("\\|")[2].split("\\,");
			ArrayList<RadnikUCentrali> listaOsoba = new ArrayList<RadnikUCentrali>();
			for (Korisnik korisnik : Main.listaKorisnika) {
				for (String id : idOsobe) {
					if (korisnik.idOsobe == Integer.parseInt(id)) {
						listaOsoba.add((RadnikUCentrali) korisnik);
					}
				}
			}
			
			Main.centrala = new Centrala(idCentrale, naplatneStanice, listaOsoba);
		}
	}
	
	public static void otvaranjeDeonica() throws NumberFormatException, IOException {
		String sp = System.getProperty("file.separator");
		BufferedReader br = new BufferedReader(new FileReader("." + sp + "deonice.txt"));
		String red;
		while((red = br.readLine()) != null) {
			int idPrveStanice = Integer.parseInt(red.split("\\|")[0]);
			NaplatnaStanica prvaNaplatnaStanica = null;
			for (NaplatnaStanica naplatnaStanica: Main.listaNaplatnihStanica){
				if (idPrveStanice == naplatnaStanica.idStanice){
					prvaNaplatnaStanica = naplatnaStanica;
				}
			}
			
			int idDrugeStanice = Integer.parseInt(red.split("\\|")[1]);
			NaplatnaStanica drugaNaplatnaStanica = null;
			for (NaplatnaStanica naplatnaStanica : Main.listaNaplatnihStanica){
				if (naplatnaStanica.idStanice == idDrugeStanice){
					drugaNaplatnaStanica = naplatnaStanica;
				}
			}
			
			Deonica deonica = new Deonica(prvaNaplatnaStanica, drugaNaplatnaStanica);
			Main.listaDeonica.add(deonica);
		}
	}

	public static void otvaranjeCenovnika() throws NumberFormatException, IOException {
		String sp = System.getProperty("file.separator");
		BufferedReader br = new BufferedReader(new FileReader("." + sp + "cenovnik.txt"));
		String red;
		while((red = br.readLine()) != null) {
			int idPrveStanice = Integer.parseInt(red.split("\\|")[0].split("\\,")[0]);
			int idDrugeStanice = Integer.parseInt(red.split("\\|")[0].split("\\,")[1]);
			
			Deonica deonica = null;
			for (Deonica d : Main.listaDeonica){
				if (d.naplatnaStanica1.idStanice == idPrveStanice && d.naplatnaStanica2.idStanice == idDrugeStanice){
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
				Main.cenovnik.stavkaCenovnika.add(stavka);
			}
		}
	}
}
