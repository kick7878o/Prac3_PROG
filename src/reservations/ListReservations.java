/** Class ListReservations.java
 * 
 * This class is made for storing a list of reservations
 * 
 * @author Joan David Frent Frent (joandavid.frentf@estudiants.urv.cat)
*/
package reservations;

public class ListReservations {
   private Reservation[] listRes; // List of reservations
   private int nElem; // Number of elements from the list
   private static final short INIT_CAPACITY = 10; // Initial array capacity

   // NOTE2SELF: maybe it's way better to define a size
   //  and make it bigger if necessary.

   /** Constructor to make the list
    * 
   */
   public ListReservations() {
      listRes = new Reservation[INIT_CAPACITY];
      nElem = 0; // initialization of the elements
   }

   /** Getter that returns the occupied size of the list
    * @return a number
    */
   public int getElem() { return nElem; }

   /** Method to add a reservation to the list
    * 
    * @param resv an instance of the reservation
    */
   public void addReservation(Reservation resv) {
      if (nElem >= listRes.length) { // Resize the array if necessary
         Reservation[] aux = new Reservation[nElem*2]; // Double capacity
         for (int i=0; i < aux.length; i++) {
            aux[i] = listRes[i];
            listRes = aux;
         }
      }
      //listRes[nElem] = new Reservation(/*res.get, res.get, res.get, res.get */);
      nElem++;
   }
   
   /** Method that shows the list of reservations
    * @return data list
    */
   public String toString() {
      String aux = "Reservation List => Elements: " +nElem+ "\n";

      for (int i = 0; i < nElem; i++) 
         aux += "\n   [" +i+ "] " +listRes[i]+ "\n";

      return aux;
   }

   /** Method to duplicate the list of reservations
    * 
    * @return new list
    */
   public ListReservations copyListReserv() {
      ListReservations aux = new ListReservations(); // auxiliar list

      for (int i=0; i < nElem; i++)
         aux.addReservation(listRes[i]); // iteration to add the elements to the aux list

      return aux;
   }
}