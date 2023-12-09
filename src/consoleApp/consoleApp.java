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
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class consoleApp {
   // Declaration of keyboard readers
   private static Scanner keyboard = new Scanner(System.in); // reads from keyboard
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

   public static void main(String[] args) throws IOException{
		boolean exit = false;

			while (!exit) {
				try {
					menu();
					int opt = Integer.parseInt(keyboard.next());
					switch (opt) {
						// We use '->' to remove the need of adding a 'break;' after each case
						case  1 -> Show_DataList();
						case  2 -> Show_ActivitiesFromEntity();  
						case  3 -> Show_ActivitiesXDay();  
						case  4 -> Show_WorkshopListWSpots();  
						case  5 -> Add_Activity();  
						case  6 -> Register_UserReservation();  
						case  7 -> Show_UsersFromWorkshop();  
						case  8 -> Highest_UserReservation();  
						case  9 -> Register_PunctuationFromUserAfterworkshop();  
						case 10 -> Calculate_AverageWorkshop(); 
						case 11 -> Most_SuccessfulWorkshop(); 
						case 12 -> Show_VisitListFromEntity(); 
						case 13 -> Show_TalkData(); 
						case 14 -> Cancel_Workshop(); 
						case 15 -> exit = true; 
						default -> wrongOption(); // If we insert a wrong number, it'll show a msg error
					}
				} catch (NumberFormatException e) { // We catch an input other than a number
					System.out.println("\n\n  ____ You have to write a number ____\n");
					continue;
				} catch (NoSuchElementException e) { // We catch the force shut down of the program
					System.out.println("\n\n¡¡¡ U have forced the end of the program, data might be lost !!!\n\n");
					exit = true;
				}
			}
			// We close everything we used to free memory
			keyboard.close();
			br.close();
			// ...
   }

	/** Method that displays the menu */
   private static void menu() {
		System.out.println("\n\n\n========== Menu options ==========\n");
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

	private static void Show_DataList(){}
	private static void Show_ActivitiesFromEntity(){}
	private static void Show_ActivitiesXDay(){}
	private static void Show_WorkshopListWSpots(){}
	private static void Add_Activity(){}
	private static void Register_UserReservation(){}
	private static void Show_UsersFromWorkshop(){}
	private static void Highest_UserReservation(){}
	private static void Register_PunctuationFromUserAfterworkshop(){}
	private static void Calculate_AverageWorkshop(){}
	private static void Most_SuccessfulWorkshop(){}
	private static void Show_VisitListFromEntity(){}
	private static void Show_TalkData(){}
	private static void Cancel_Workshop(){}
	
	/** Method that indicates that the input number is wrong */
	private static void wrongOption(){
		System.out.println("\n\n  ¡¡¡ Incorrect number. Write one between 1 and 15 !!! \n\n");
	}
}
