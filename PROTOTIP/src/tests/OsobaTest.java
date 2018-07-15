package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Osoba;

public class OsobaTest {
	Osoba o;

	@Test
	public void testSetIme() {
		o=new Osoba();
		o.setIme("Milica");
		assertEquals(o.getIme(),"Milica");
		
	}
	
	@Test
	public void testSetPrezime(){
		
	}
}
