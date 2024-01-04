package reservations;

import java.io.Serializable;

import exceptions.WrongRateNumber;

/** Class Reservation.java
 *
 * This class is made for storing one reservation
 *  that the user made to take part of the workshop at some given
 *  hour and duration of the day.
 *
 * @author Joan David Frent Frent (joandavid.frentf@estudiants.urv.cat)
 */
public class Reservation implements Serializable {
   private int idRes; // ID reservation
   private int rateLvl=-1; // Satisfaction level 0-10 (included)
   private String user, idWorkShop; // Name of the user & workShop Identifier

   /** Constructor to declare an instance for one reservation
    *
    * @param idRes reservation identificator
    * @param user name of the user
    * @param idWorkShop code of the workshop
    * @param rateLvl satisfaction level from the user
    *
   */
   public Reservation (int idRes, String user, String idWorkShop, int rateLvl) {
      this.idRes = idRes;
      this.user = user;
      this.idWorkShop = idWorkShop;
      this.rateLvl = rateLvl;
   }

   // Getter & Setters
   public int getIdRes() { return idRes; }
   public String getIdWorkShop() { return idWorkShop; }
   public String getUser() { return user; }
   public int getRateLvl() { return rateLvl; }
   public void setRateLvl(int rateLvl) throws WrongRateNumber {
      if (0 <= rateLvl && rateLvl <= 10) 
         this.rateLvl = rateLvl;
      else throw new WrongRateNumber(); 
   }

   /** Duplicate of the reservation
    * @return new instance of the reservation
   */
   public Reservation copyReservation() { 
      return new Reservation(idRes, user, idWorkShop, rateLvl); 
   }

   public String toString() {
      return "Reservation: " +idRes+ "; User: " +user+ "; Workshop: " +idWorkShop;
   }
}