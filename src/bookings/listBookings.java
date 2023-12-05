/** Class listBookings.java
 * 
 * This class is made for storing a list of bookings
 * 
 * It will also update the number of assistants that can take part of 
 *  until it's full
 */
package bookings;

public class listBookings {
   private Booking[] bookings;
   private int nElem;

   public listBookings(int size){
      this.bookings = new Booking[size];
      this.nElem = 0;
   }
}