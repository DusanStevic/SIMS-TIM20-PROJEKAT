package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Korisnik;

public class KorisnikTest {
	public Korisnik k;

	@Test
	public void testSetUsername() {
		k=new Korisnik();
		k.setUsername("Pera");
		assertEquals(k.getUsername(),"Pera");
		
	}
	
	@Test
	public void testSetPassword(){
		k=new Korisnik();
		k.setPassword("2er&");
		assertEquals(k.getPassword(),"2er&");
	}
	
	@Test
	public void testGetPassword(){
		k=new Korisnik();
		k.setPassword("2er&");
		assertEquals(k.getPassword(),"2er&");
	}
	
	@Test
	public void testGetUsername() {
		k=new Korisnik();
		k.setUsername("Pera");
		assertEquals(k.getUsername(),"Pera");
		
	}
}
