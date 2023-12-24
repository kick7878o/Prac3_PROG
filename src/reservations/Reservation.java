/** Class Reservation.java
 *
 * This class is made for storing one reservation
 *  that the user made to take part of the workshop at some given
 *  hour and duration of the day.
 *
 * @author Joan David Frent Frent (joandavid.frentf@estudiants.urv.cat)
 */
package reservations;

public class Reservation {
   private int idRes, idWorkShop; // ID reservation & workShop Identifier
   private int rateLvl, spotsFilled; // satisfaction level 0-10 (included) & number of spots filled
   private String user; // Name of the user

   /** Constructor to declare an instance for one reservation
      *
      * @param idRes reservation identificator
      * @param user name of the user
      * @param idWorkShop code of the workshop
      *
      * NOTE: need to check if there's space in the WS
   */
   public Reservation (int idRes, String user, int idWorkShop) {
      this.idRes = idRes;
      this.idWorkShop = idWorkShop;
      this.user = user;
   }

   // Getter of the Reservation, WorkShop idetifier & the user' name
   public int getIdRes() { return idRes; }
   public int getIdWorkShop() { return idWorkShop; }
   public String getUser() { return user; }

   // Getter & Setter of the satisfaction level
   public int getRateLvl() { return rateLvl; }
   public void setRateLvl(int rateLvl) { this.rateLvl = rateLvl; }

   // Getter & Setter of spots filled
   public int getSpotsFilled() { return spotsFilled; }
   public void setSpotsFilled(int spotsFilled) { this.spotsFilled = spotsFilled; }

   public Reservation copyReservation() { 
      return new Reservation(idRes, user, idWorkShop); 
   }

   public String toString() {
      return "Reservation: " +idRes+ "; User: " +user+ "; Workshop: " +idWorkShop;
   }
}