/** Class consoleApp.java
 * 
 * This class is made for making a full functional app
 *  to manage the event "Setmana de la Ciència a la URV 2023"
 *  between 10 and 19 of November of 2023.
 * 
 * @author Joan David Frent Frent (joandavid.frentf@estudiants.urv.cat)
 * @author XXXX (xxxx.xxxx@estudiants.urv.cat)
 * @author YYYY (yyyy.yyyy@estudiants.urv.cat)
 * @author ZZZZ (zzzz.zzzz@estudiants.urv.cat)
 */
package consoleApp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.CacheRequest;
import java.util.Scanner;

public class consoleApp {
   // Declaration of keyboard readers
   private static Scanner keyboard = new Scanner(System.in); // reads from keyboard
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

   public static void main(String[] args) {
		do {
			switch () {
				case  1: option1();   break;
				case  2: option2();   break;
				case  3: option3();   break;
				case  4: option4();   break;
				case  5: option5();   break;
				case  6: option6();   break;
				case  7: option7();   break;
				case  8: option8();   break;
				case  9: option9();   break;
				case 10: option10();  break;
				case 11: option11();  break;
				case 12: option12();  break;
				case 13: option13();  break;
				case 14: option14();  break;
				case 15: option15();  break;
				default: System.out.println("\n\n\tNumero introducido fuera de rango.\n\n"); break;
			}
		}while();
   }

	// Method that displays the menu
   private static void menu() {
		System.out.println("\n\n\nMenu options:\n");
		System.out.println("   1. Show data from a list.");
		System.out.println("   2. Show the activity list from a specific entity.");
		System.out.println("   3. Show the activity list from a given day.");
		System.out.println("   4. Show the workshop list with available spots.");
		System.out.println("   5. Add new activity.");
		System.out.println("   6. Register user's petition to book a workshop's spot.");
		System.out.println("   7. Show user's list from a workshop.");
		System.out.println("   8. Show which user booked more workshops.");
		System.out.println("   9. Register the punctuation from a user that went to a booked workshop.");
		System.out.println("  10. Calculate the average that a workshop has recieved.");
		System.out.println("  11. Get the most successful workshop");
		System.out.println("  12. Show visit's list offered by an entity.");
		System.out.println("  13. Show the talk data that the person will do");
		System.out.println("  14. Cancel a workshop.");
		System.out.println("  15. End Program");
		System.out.print("\n\tChoose option: ");
	}
}
