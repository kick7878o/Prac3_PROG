package exceptions;

/** Class ReservationListEmpty.java
 * 
 * This class is made handling an empty list storage
 * 
 * @author Joan David Frent Frent (joandavid.frentf@estudiants.urv.cat)
 */
public class ReservationListEmpty extends Exception {
   public ReservationListEmpty() {
      super("\n\n ------- Nothing to store from the reservation list -------\n\n");
   }
   
}
