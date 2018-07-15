package model;
/***********************************************************************
 * Module:  Aplikacija.java
 * Author:  Korisnik
 * Purpose: Defines the Class Aplikacija
 ***********************************************************************/

import java.util.*;

/** Klasa sadrzi i poziva metode za ucitavanje i upisivanje podataka u/iz fajlova.
 * Instancira kolekcije ucitanih podataka:
 * 1. Kolekciju podataka o naplatnim stanicama, koja se nalazi u klasi Centrala
 * 2. Kolekciju podataka o naplatnim mestima, koju ima svala naplatna stanica
 * 3. Kolekciju podataka o deonicama
 * 4. Kolekciju podataka o korisnicima koji postoje u sistemu
 * 5. Kolekciju podataka o putarinama (za deonice) za odredjeni tip vozila. Ovu kolekciju sadrzi instancirani cenovnik
 **/

public class Aplikacija {
   public Centrala centrala;
   public java.util.Collection<Osoba> osoba;
   public Cenovnik cenovnik;
   public java.util.Collection<Deonica> deonica;

   public void ucitavanjeStanica(String putanja, Centrala centrala) {
      // TODO: implement
   }
   
   public void ucitavanjeKorisnika(Short putanja, ArrayList<Korisnik> korisnici) {
      // TODO: implement
   }
   
 
   public void ucitavanjeCenovnika(String putanja, Cenovnik cenovnik) {
      // TODO: implement
   }
   
  
   public void ucitavanjeDeonica(String putanja, ArrayList<Deonica> deonice) {
      // TODO: implement
   }
   

   public void upisStanica(String putanja, Centrala centrala) {
      // TODO: implement
   }
   
  
   public void upisKorisnika(String putanja, ArrayList<Korisnik> korisnici) {
      // TODO: implement
   }
   
   
   public void upisCenovnika(String putanja, Cenovnik cenovnik) {
      // TODO: implement
   }
   

   public void upisDeonica(String putanja, ArrayList<Deonica> deonice) {
      // TODO: implement
   }
   
}