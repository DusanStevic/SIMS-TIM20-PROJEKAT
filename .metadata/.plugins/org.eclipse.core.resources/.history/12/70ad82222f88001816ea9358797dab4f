package probniPrototip;
/***********************************************************************
 * Module:  Kvar.java
 * Author:  marina
 * Purpose: Defines the Class Kvar
 ***********************************************************************/

import java.util.*;

/** @pdOid a8c1d345-c153-4fc8-9e44-cf9e8b964096 */
public class Kvar {
   /** @pdOid 228fea08-f6cc-4644-beef-815ba12a0160 */
   protected int idKvara;//moralo da se promeni-Maki
   /** @pdOid 732bd47a-f1e0-4478-97b9-aa9663765eb6 */
   protected String opisKvara;
   /** @pdOid 7b485fc0-8d70-44d6-b44e-76fdf9598105 */
   protected Date datumKvara;
   
   /** @pdRoleInfo migr=no name=NaplatnoMesto assc=association19 mult=1..1 */
   public NaplatnoMesto naplatnoMesto;
   
   Kvar(int idKvara){
	   this.idKvara = idKvara;
   }
   
   Kvar(Kvar kvar){
	   this.idKvara = kvar.idKvara;
	   this.opisKvara = kvar.opisKvara;
	   this.naplatnoMesto = new NaplatnoMesto(kvar.naplatnoMesto);
   }
   
   Kvar(int idKvara, String opisKvara, Date datumKvara, NaplatnoMesto naplatnoMesto) {
	   this.idKvara = idKvara;
	   this.opisKvara = opisKvara;
	   this.datumKvara = datumKvara;
	   this.naplatnoMesto = naplatnoMesto;
   }

   public String toString() {
	   return this.idKvara + " " + this.opisKvara + " " + this.datumKvara + " " + this.naplatnoMesto;
   }
}