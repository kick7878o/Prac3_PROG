package reservations;

/** Class Reservation.java
 *
 * This class is made for storing one reservation
 *  that the user made to take part of the workshop at some given
 *  hour and duration of the day.
 *
 * @author Joan David Frent Frent (joandavid.frentf@estudiants.urv.cat)
 */
public class Reservation {
   private int idRes, idWorkShop; // ID reservation & workShop Identifier
   private int spotsFilled; // Number of spots filled
   private byte rateLvl; // Satisfaction level 0-10 (included)
   private String user; // Name of the user

   /** Constructor to declare an instance for one reservation
    *
    * @param idRes reservation identificator
    * @param user name of the user
    * @param idWorkShop code of the workshop
    * @param rateLvl satisfaction level from the user
    *
    * NOTE: need to check if there's space in the WS
   */
   public Reservation (int idRes, String user, int idWorkShop, byte rateLvl) {
      this.idRes = idRes;
      this.user = user;
      this.idWorkShop = idWorkShop;
      this.rateLvl = rateLvl;
   }

   // Getter & Setters
   public int getIdRes() { return idRes; }
   public int getIdWorkShop() { return idWorkShop; }
   public String getUser() { return user; }
   public int getRateLvl() { return rateLvl; }
   public void setRateLvl(byte rateLvl) { this.rateLvl = rateLvl; }
   public int getSpotsFilled() { return spotsFilled; }
   public void setSpotsFilled(int spotsFilled) { this.spotsFilled = spotsFilled; }

   public Reservation copyReservation() { 
      return new Reservation(idRes, user, idWorkShop, rateLvl); 
   }

   public String toString() {
      return "Reservation: " +idRes+ "; User: " +user+ "; Workshop: " +idWorkShop;
   }
}