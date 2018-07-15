package tests;

import static org.junit.Assert.assertEquals;
import model.Administrator;
import model.Korisnik;
import model.RadnikUCentrali;

import java.util.ArrayList;

import org.junit.Test;

public class LogInTest {
static ArrayList<model.Korisnik> korisnici = new ArrayList<model.Korisnik>();
	
	static model.Administrator administrator = new model.Administrator(1,"Pera","Peric","pera.peric","pera");
	
	static model.RadnikUCentrali radnikUCentrali = new model.RadnikUCentrali(2,"Mika","Mikic","mika.mikic","mika", "0");
	
	@Test
	public void test() {
		korisnici.add(administrator);
		korisnici.add(radnikUCentrali);
		assertEquals(0,Korisnik.logIn("pera.peric","pera", korisnici));
		assertEquals(1,Korisnik.logIn("mika.mikic","mika", korisnici));
		
	}
}
