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
		o=new Osoba();
		o.setPrezime("Milic");
		assertEquals(o.getPrezime(),"Milic");
	}
	
	@Test
	public void testSetId() {
		o=new Osoba();
		o.setIdOsobe(1);
		assertEquals(o.getIdOsobe(),1);
		
	}
	@Test
	public void testGetIme(){
		o=new Osoba();
		o.setIme("Milica");
		assertEquals(o.getIme(),"Milica");
	}
	
	@Test
	public void testGetPrezime() {
		o=new Osoba();
		o.setPrezime("Milic");
		assertEquals(o.getPrezime(),"Milic");
		
	}
	@Test
	public void testGetId() {
		o=new Osoba();
		o.setIdOsobe(1);
		assertEquals(o.getIdOsobe(),1);
		
	}
}
