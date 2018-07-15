package model;
/***********************************************************************
 * Module:  Deonica.java
 * Author:  Korisnik
 * Purpose: Defines the Class Deonica
 ***********************************************************************/

import java.util.*;

public class Deonica {
   public NaplatnaStanica naplatnaStanica1;
   public NaplatnaStanica naplatnaStanica2;
   
   public Deonica(NaplatnaStanica naplatnaStanica1, NaplatnaStanica naplatnaStanica2){
	   this.naplatnaStanica1 = naplatnaStanica1;
	   this.naplatnaStanica2 = naplatnaStanica2;
   }
   
   public String toString() {
	   return this.naplatnaStanica1 + "      " + this.naplatnaStanica2;
   }
   
   public double konvertujUEvre() {
      // TODO: implement
      return 0;
   }

}