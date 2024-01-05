package exceptions;

/** Class UserReservationListEmpty.java
 * 
 * This class is made for handling the case in which
 * a user didn't make any reservations at all
 * 
 * @author Joan David Frent Frent (joandavid.frentf@estudiants.urv.cat)
 */
public class UserReservationListEmpty extends Exception {
   public UserReservationListEmpty(String name) {
      super("The user " +name+ " has no reservations");
   }
   
}
