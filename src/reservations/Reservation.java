/** Class Reservation.java
 *
 * This class is made for storing one reservation
 *  that the user made to take part of the workshop at some given
 *  hour and duration of the day.
 *
 * @author Joan David Frent Frent (joandavid.frentf@estudiants.urv.cat)
 */
package reservations;

/** NOTES TO BE ELIMINATED AFTER:
  * CHECK: places avaliable when making the reservation
  * STORE: reservation code - userName - workshop code
  * MODIFY: decrease the number of places left for that workshop
  *   (modification in reservations or workshop?)
  * AFTER WORKSHOP: ask satisfaction level [0-10].
  *   STORE: in Reservation.java
  *   MODIFY: sum of punctuations for that workshop,
  *           number of ppl that punctuated (not everyone has to)
  *
  * XTRA: make a serialized file
  *
  * POSSIBLE ERRORS:
  *   Workshop selected on its full capacity
  *
*/
public class Reservation {
   private int idRes; // ID reservation
   // Atributo que recoge la instancia del usuario
   // Atributo que recoge el codigo del taller
   private int rateLvl; // Satisfaction level between 1-10 (included)

   /** Constructor to declare an instance for the reservations
      *
      * @param idRes reservation identificator
      * @param user instance of the user
      * @param wshop instance of the workshop
      * @param rateLvl satisfaction level after the workshop
   */
   public Reservation (int idRes, /*User user*/, /*Workshop wshop*/, int rateLvl) {
      this.idRes = idRes;
      // this.user = user;
      // this.wshop = wshop;
      this.rateLvl = rateLvl;
   }

   /** Method to get the reservation identificator
    *
    * @return reservation identificator
   */
   public int getIdRes() { return idRes; }
   /** Method to set the reservation identificator
    *
    * @param idRes reservation identificator
   */
   public void setIdRes(int idRes) { this.idRes = idRes; }

   /** Method to get the user instance
    *
    * @return user instance
   */
   // public User getUser() { return user; }

   /** Method to get the workshop instance
    *
    * @return workshop instance
   */
   // public Workshop getWshop() { return wshop; }

   /** Method to get the satisfaction level
    *
    * @return satisfaction level
   */
   public int getRateLvl() { return rateLvl; }
   /** Method to set the satisfaction level
    *
    * @param rateLvl satisfaction level
   */
   public void setRateLvl(int rateLvl) { this.rateLvl = rateLvl; }

}