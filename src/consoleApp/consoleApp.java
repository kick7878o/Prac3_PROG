/** Class consoleApp.java
 * 
 * This class is made for making a full functional app
 *  to manage the event "Setmana de la Ciència a la URV 2023"
 *  between 10 and 19 of November of 2023.
 * 
 * @author Joan David Frent Frent (joandavid.frentf@estudiants.urv.cat)
 * @author Juan Carlos Medinilla Alonso (juancarlos.medinilla@estudiants.urv.cat)
 * @author YYYY (yyyy.yyyy@estudiants.urv.cat)
 * @author ZZZZ (zzzz.zzzz@estudiants.urv.cat)
 */
package consoleApp;

import java.io.*;
import java.util.*;

public class consoleApp {
   // Declaration of keyboard readers
   private static Scanner keyboard = new Scanner(System.in); // reads from keyboard
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

   public static void main(String[] args) throws IOException {
		initDataStructures(); // Initialize all data structures

		boolean exit = false; // Boolean to handle if the user wants to end the program
			// Main loop
			do {
				try {
					menu();
					int opt = Integer.parseInt(keyboard.next()); // user's input
					switch (opt) {
						// We use '->' to remove the need of adding a 'break;' after each case
						// Important note: can't add more than 1 instruction to each case
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
						default -> wrongOption(); // If we insert a wrong number, it'll show a msg
					}
				} catch (NumberFormatException e) { // We catch another input different from a number
					System.out.println("\n\n  ____ ERRROR: You have to write a number ____\n");
				} catch (NoSuchElementException e) { // We catch the force shut down of the program
					System.out.println("\n\n¡¡¡ U have forced the end of the program, data might be lost !!!\n\n");
					exit = true;
				}
			} while (!exit);

			storeDataStructures(); // (not)Store all modified data

			// We show a msg to indicate that the program has ended
			System.out.println("\n\n\n=============== THE END ===============\n\n\n");
			
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
	private static void Register_UserReservation() {
		System.out.println("\n\n----- Register user's petition to book a workshop's spot -----\n");
		System.out.println("  Insert the user's name: ");
		String userName = keyboard.next();
		System.out.println("  Insert the workshop's name: ");
		String wName = keyboard.next();
		// Create new reservation instance
		// Add the reservation to the list
	}
	private static void Show_UsersFromWorkshop(){}
	private static void Highest_UserReservation(){}
	private static void Register_PunctuationFromUserAfterworkshop() {
		System.out.println("\n\n----- Register punctuation from user after the WorkShop -----\n");
		System.out.println("  Insert the user's name: ");
		String userName = keyboard.next();
		// Show the user's reservation list that has no rate (rateLvl == null | -1)
		System.out.println("  Insert the satisfaction level [0-10]: ");
		byte rateLvl = keyboard.nextByte();
		// Update the rateLvl into that user reservation 
		// Uptade the sum of the workshop && number of people that have voted
	}
	private static void Calculate_AverageWorkshop(){}
	private static void Most_SuccessfulWorkshop(){}
	private static void Show_VisitListFromEntity(){}
	private static void Show_TalkData(){}
	private static void Cancel_Workshop(){}
	
	/** Method that indicates that the input number is wrong */
	private static void wrongOption() {
		System.out.println("\n\n  ¡¡¡ Incorrect number input !!! \n\n");
	}

	/** Method that initializes all data structures */
	private static void initDataStructures() {
		menuInitData();
		int opt = Integer.parseInt(keyboard.next());
	}
	/** Menu to choose the initialization process */
	private static void menuInitData() {
		System.out.println("\n\n----- Initializaton phase of data structures -----\n");
		System.out.println("  Do you want to start from scratch or from last modification?");
		System.out.println("    1. Start from scratch");
		System.out.println("    2. Start from last modification");
		System.out.println("    (IMPORTANT NOTE: starting from scratch will result in all data loss from previous modifications)");
		System.out.println("\tOption: ");
	}
	
	/** Method that stores all data structures */
	private static void storeDataStructures() {
		menuStoreData();
		int opt = Integer.parseInt(keyboard.next());
	}
	/** Menu to choose the initialization process */
	private static void menuStoreData() {
		System.out.println("\n\n-----Storage phase of data structures -----\n");
		System.out.println("  Do you want to store all data modification?");
		System.out.println("    1. Yes");
		System.out.println("    2. No");
		System.out.println("\tOption: ");

		/** NOTE2SELF: do a back system?
		 * MEANING: go back to last menu used
		 */
	}
}
