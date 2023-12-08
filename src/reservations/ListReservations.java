/** Class ListReservations.java
 * 
 * This class is made for storing a list of reservations
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
public class ListReservations {
   private Reservation[] lisRes; // List of reservations
   private int nElem; // Number of elements from the list

   // NOTE2SELF: maybe it's way better to define a size
   //  and make it bigger if necessary.
   // Necessary changes: constructor

   /** Constructor to make the list
    * @param size size of the list
   */
   public ListReservations(int size) {
      lisRes = new Reservation[size];
      nElem = 0; // initialization of the elements
   }

   /** Getter that returns the occupied size of the list
    * @return a number
    */
   public int getElem() { return nElem; }

   /** Method that shows the list of reservations
    * @return data list
    */
   public String toString() {
      String aux = "Reservation List => Elements: " +nElem+ "\n";

      for (int i = 0; i < nElem; i++) 
         aux += "\n   [" +i+ "] " +lisRes[i]+ "\n";

      return aux;
   }
}