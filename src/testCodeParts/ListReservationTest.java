package testCodeParts;

import reservations.*;

/** Class ReservationAndListReservationTest.java
 *
 * This class is made for testing the reservation and 
 * ListReservation.java classes
 *
 * @author Joan David Frent Frent (joandavid.frentf@estudiants.urv.cat)
 */
public class ListReservationTest {
   public static void main(String[] args) {
      // Create new Reservation instances and check if the data preset is correct
      System.out.println("\n- Create new Reservation instances and check if the data preset is correct\n\n");
      Reservation r1 = new Reservation(0001, "Alpha", "URV103", -1);
      System.out.println(r1);

      // Creating new reservation instances to add to the list
      System.out.println("\n- Creating new reservation instances to add to the list\n\n");
      Reservation r2 = new Reservation(0002, "Beta", "URV104", -1);
      Reservation r3 = new Reservation(0003, "Gamma", "URV103", -1);
      Reservation r4 = new Reservation(0004, "Delta", "URV104", -1);
      Reservation r5 = new Reservation(0005, "Epsilon", "URV103", -1);
      Reservation r6 = new Reservation(0006, "Zeta", "URV104", -1);

      // Create a new list of reservations and add it to the list
      System.out.println("\n- Create a new list of reservations and add it to the list\n\n");
      ListReservations list = new ListReservations();
      list.addReservation(r1); // 0
      list.addReservation(r2); // 1
      list.addReservation(r3); // 2
      list.addReservation(r4); // 3
      list.addReservation(r5); // 4
      list.addReservation(r6); // 5 check if it resizes correctly

      // Show the reservation list
      System.out.println(list);

      // Set rates from the reservations and check if they changed
      System.out.println("\n- Set rates from the reservations and check if they changed\n\n");
      r1.setRateLvl(5);
      r2.setRateLvl(7);
      r3.setRateLvl(9);
      r4.setRateLvl(10);
      r5.setRateLvl(8);
      r6.setRateLvl(6);
      System.out.println("- Resv1: " +r1.getRateLvl()+ "; Resv2: " +r2.getRateLvl());

      System.out.println(list); // Check if they changed in the list

      // It didn't change so it means we have to change the instance inside the list
      System.out.println("\n- It didn't change so it means we have to change the instance inside the list\n\n");
      for (int i = 0; i < list.getnElem(); i++) {
         list.getListRes()[i].setRateLvl(i); // We change the rate level with the value that 'i' has
      }

      System.out.println(list); // Check if it changed

      // We can also change the instance directly
      System.out.println("\n- We can also change the instance directly\n\n");
      list.getListRes()[0].setRateLvl(10);
      System.out.println("\n\n"+list.getListRes()[0]+ "\n\n"); // Check if it changed
   }
}
