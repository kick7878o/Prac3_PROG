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
   private byte rateLvl; // Satisfaction level 0-10 (included)
   private String user; // Name of the user
   // NOTE: attribute for number of people that reserved a spot?

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

   /** Method that checks if the input name is the same
    * as the one in the instance
    *
    * @param userName name of the user
    * @return true or false
    */
   public boolean isThisName(String userName) {
      return this.user.equalsIgnoreCase(userName);
   }
   /** Method that checks if the input id is the same
    * as the one in the instance
    *
    * @param idRes id of the reservation
    * @return true or false
    */
   public boolean isThisReservationId(int idRes) {
      return this.idRes == idRes;
   }
   /** Method that checks if the input id is the same
    * as the one in the instance
    *
    * @param idWorkShop id of the workshop
    * @return true or false
    */
   public boolean isThisWorkShopID(int idWorkShop) {
      return this.idWorkShop == idWorkShop;
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