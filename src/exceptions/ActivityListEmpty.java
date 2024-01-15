package exceptions;

/** Class ActivityListEmpty.java
 * 
 * This class is made handling an empty list storage
 * 
 * @author Joan David Frent Frent (joandavid.frentf@estudiants.urv.cat)
 */
public class ActivityListEmpty extends Exception {
   public ActivityListEmpty() {
      super("\n\n\t<<<<<< The list of activities is empty >>>>>>\n\n\n");
   }
}
