package exceptions;

/** Class WornRateNumber.java
 * 
 * This class handles the exception for the rate number [0-10]
 * 
 * @author Joan David Frent Frent (joandavid.frentf@estudiants.urv.cat)
 */
public class WrongRateNumber extends Exception {
   public WrongRateNumber() {
      super("\t<<<<< The number must be between 0 and 10 >>>>>");
   }
}
