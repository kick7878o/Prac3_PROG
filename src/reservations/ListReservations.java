/** Class ListReservations.java
 * 
 * This class is made for storing a list of reservations
 * 
 * @author Joan David Frent Frent (joandavid.frentf@estudiants.urv.cat)
*/
package reservations;

import java.io.Serializable;

public class ListReservations implements Serializable {
   private Reservation[] listRes; // List of reservations
   private int nElem; // Number of elements from the list
   private static final short INIT_CAPACITY = 3; // Initial array capacity

   /** Constructor to make the list
    * NOTE: we make an initial size then we resize if necessary
   */
   public ListReservations() {
      listRes = new Reservation[INIT_CAPACITY];
      nElem = 0; // initialization of the elements
   }

    /** Constructor to make the list of reservations
     * @param size of the array
     */
    public ListReservations(int size){
        listRes = new Reservation[size];
        nElem = 0;
    }

   /** Getter that returns the occupied size of the list
    * @return a number
    */
   public int getnElem() { return nElem; }
   public Reservation[] getListRes() { return listRes; }
   

   /** Method to add a reservation to the list
    * 
    * @param resv an instance of the reservation
    */
   public void addReservation(Reservation resv) {
      // Resize the array if necessary
      if (nElem >= listRes.length) { 
         Reservation[] aux = new Reservation[nElem*2]; // Double capacity
         for (int i=0; i < nElem; i++)
            aux[i] = listRes[i]; // Copy elements to the aux array
            
         listRes = aux; // aux array to list
      }

      // add a new reservation to the list
      listRes[nElem] = resv.copyReservation();
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

   /** Method that checks if the reservation code given already exists
    * in the list
    * 
    * @param code
    * @return exists or not
    */
   public boolean checkReservationCode(int code) {
      for (int i=0; i < nElem; i++) {
         if (listRes[i].getIdRes() == code) return true;
      }
      return false;
   }

   /** Method to filter the reservations made from a user
    * with the workshop code
    * 
    * @param name name of User
    * @return 
    */
   public Reservation getReservationByCode(String wkCode) {
      for (int i=0; i < nElem; i++) {
         if(listRes[i].getIdWorkShop().equalsIgnoreCase(wkCode))
            return listRes[i];
      }
      return null;
   }

   /** Method that registers the rate from a user
    * 
    * @param wkCode
    * @param rate
    */
   public void registerPunctuation(String wkCode, byte rate) {
      for (int i=0; i < nElem; i++) {
         if (listRes[i].getIdWorkShop().equalsIgnoreCase(wkCode))
            listRes[i].setRateLvl(rate);
      }
   }

   /** Method to filter by the user name
    * 
    * @param userName
    * @return
    */
   public ListReservations filterByUserName(String userName) {
      ListReservations aux = new ListReservations(getnElem());
      for (int i=0; i < nElem; i++) {
         if (listRes[i].getUser().equalsIgnoreCase(userName))
            aux.addReservation(listRes[i]);
      }
      return aux;
   }
}