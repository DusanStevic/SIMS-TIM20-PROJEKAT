package probniPrototip;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class Utility {
	
	public static String unesiString(Scanner sc) {
		String tekst = "";
		boolean procitano = true;
		
		do {
			if (sc.hasNextLine()) {
				tekst = sc.nextLine();
				procitano = false;
			}
			else {
				if(!sc.nextLine().isEmpty()) {
					System.out.println("Greska! Pokusajte ponovo.");
				}
			}
		} while (procitano);
		
		return tekst;
	}
	
	public static int unesiInt(Scanner sc) {
		int ceoBroj = 0;
		boolean procitano = true;
		
		do {
			if (sc.hasNextInt()) {
				ceoBroj = sc.nextInt();
				procitano = false;
			}
			else {
				if(!sc.nextLine().isEmpty()) {
					System.out.println("Greska! Pokusajte ponovo.");
				}
			}
			sc.nextLine();
		} while (procitano);
		
		return ceoBroj;
	}
	
	public static float unesiFloat(Scanner sc) {
		float decimalni = 0;
		boolean procitano = true;
		
		do {
			if (sc.hasNextFloat()) {
				decimalni = sc.nextFloat();
				procitano = false;
			}
			else {
				System.out.println("Greska! Pokusajte ponovo.");	
			}
			sc.nextLine();
		} while(procitano);
		
		return decimalni;
	}

	public static double unesiDouble(Scanner sc) {
		double decimalni = 0;
		boolean procitano = true;
		
		do {
			if (sc.hasNextDouble()) {
				decimalni = sc.nextDouble();
				procitano = false;
			}
			else {
				System.out.println("Greska! Pokusajte ponovo.");
			}
			sc.nextLine();
		} while(procitano);
		
		return decimalni;
	}
	
	public static byte unesiByte(Scanner sc) {
		byte bajt = 0;
		boolean procitano = true;
		
		do {
			if (sc.hasNextByte()) {
				bajt = sc.nextByte();
				procitano = false;
			}
			else {
				System.out.println("Greska! Pokusajte ponovo.");
			}
			sc.nextLine();
		} while(procitano);
		
		return bajt;
	}
	
	public static char unesiKarakter(Scanner sc) {
		char karakter = ' ';
		boolean procitano = true;
		do {
			try {
				karakter = sc.next(".").charAt(0);
				procitano = false;
			} catch (Exception e) {
				System.out.println("Greska! Pokusajte ponovo.");
			}
			sc.nextLine();
		} while(procitano);
				
		return karakter;
	}
	
	public static boolean unesiBool(Scanner sc) {
		boolean uslov = true;
		boolean procitano = true;
		
		do {
			if (sc.hasNextBoolean()) {
				uslov = sc.nextBoolean();
				procitano = false;
			}
			else {
				System.out.println("Greska! Pokusajte ponovo.");
			}
			sc.nextLine();
		} while(procitano);
		return uslov;	
	}
	
	public static String unesiOdluku(Scanner sc) {
		String tekst = "";
		boolean procitano = true;
		
		do {
			if (sc.hasNextLine()) {
				tekst = sc.nextLine();
				procitano = false;
				if (!tekst.equalsIgnoreCase("da") && !tekst.equalsIgnoreCase("ne")) {
					procitano = true;
					System.out.println("Greska! Pokusajte ponovo.");
				}
			}
			else {
				if(!sc.nextLine().isEmpty()) {
					System.out.println("Greska! Pokusajte ponovo.");
				}
			}
		} while (procitano);
		
		return tekst;
	}
	
	
	
	public static Date unesiDatumVreme(Scanner sc) {
		Calendar calendar = Calendar.getInstance();
		Date now = new Date();
		calendar.setTime(now);
		calendar.add(Calendar.MONTH, 12);
		Date gornjaGranica = calendar.getTime();
		
		calendar.setTime(now);
		calendar.add(Calendar.MONTH, -12);
		Date donjaGranica = calendar.getTime();
		Date vreme = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		int uslov = 0;
		while(uslov != 1) {
			uslov = 1;
			System.out.println("Unesite datum (dd-MM-yyyy HH:mm): ");
			String unos = Utility.unesiString(sc);
			
			try {
				vreme = ft.parse(unos);
			} catch(ParseException e) {
				uslov = 0;
			}
			if (vreme.after(gornjaGranica) || vreme.before(donjaGranica)) {
				System.out.println("ne sme");
				uslov = 0;
			}
			
		}
		return vreme;
	}
	
	public static Date unesiDatum(Scanner sc) {
		Calendar calendar = Calendar.getInstance();
		Date now = new Date();
		calendar.setTime(now);
		Date granica = calendar.getTime();
		
		Date vreme = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("dd/mm/yyyy");
		int uslov = 0;
		while(uslov != 1) {
			uslov = 1;
			System.out.println("Unesite datum (dd/mm/yyyy): ");
			String unos = Utility.unesiString(sc);
			
			try {
				vreme = ft.parse(unos);
			} catch(ParseException e) {
				uslov = 0;
			}
			if (vreme.before(granica)) {
				System.out.println("ne sme");
				uslov = 0;
			}
			
		}
		return vreme;
	}
}
