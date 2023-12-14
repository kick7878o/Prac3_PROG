/** Class Reservation.java
 *
 * This class is made for storing one reservation
 *  that the user made to take part of the workshop at some given
 *  hour and duration of the day.
 *
 * @author Joan David Frent Frent (joandavid.frentf@estudiants.urv.cat)
 */
package reservations;

import activities.Workshop;
import users.Users;

public class Reservation {
   private int idRes; // ID reservation
   private int rateLvl; // Satisfaction level between 1-10 (included)
   private Workshop workshop; // Instance of the workshop
   private Users user; // Instance of the user

   /** Constructor to declare an instance for one reservation
      *
      * @param idRes reservation identificator
      * @param user instance of the user
      * @param wshop instance of the workshop
      * @param rateLvl satisfaction level after the workshop
   */
   public Reservation (int idRes, Users user, Workshop workshop, int rateLvl) {
      this.idRes = idRes;
      this.workshop = workshop;
      this.user = user;
      this.rateLvl = rateLvl;
   }

   /** Method to get the reservation identificator
    * @return reservation identificator
   */
   public int getIdRes() { return idRes; }
   /** Method to set the reservation identificator
    * @param idRes reservation identificator
   */
   public void setIdRes(int idRes) { this.idRes = idRes; }

   /** Method to get the user instance
    * @return user instance
   */
   public Users getUser() { return user; }

   /** Method to get the workshop instance
    * @return workshop instance
   */
   public Workshop getWshop() { return workshop; }

   /** Method to get the satisfaction level
    * @return satisfaction level
   */
   public int getRateLvl() { return rateLvl; }
   /** Method to set the satisfaction level
    * @param rateLvl satisfaction level
    * @throws NegativeNumber if the value is negative 
   */
   public void setRateLvl(int rateLvl) { this.rateLvl = rateLvl; }

   /** Method that duplicates an instance of Reservation
    * @return duplicate
    */
   public Reservation copyResv() {
      return new Reservation(idRes, user, workshop, rateLvl);
   }

   /** Method that displays the data of the instance Reservation
    * @return String with the data
    */
   public String toString() {
      return "Reservation ID: " +idRes+ "\n" +
             "User: " +user+ "\n" +
             "Workshop: " +workshop+ "\n" +
             "Satisfaction level: " +rateLvl+ "\n";
   }
}