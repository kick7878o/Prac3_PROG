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

import activities.ListOfActivities;
import entities.Entity;
import entities.ListEntities;
import reservations.ListReservations;
import users.ListUsers;
import users.Users;

public class consoleApp {
   // Declaration of keyboard readers
   private static Scanner keyboard = new Scanner(System.in); // reads from keyboard
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

   public static void main(String[] args) throws IOException {
		ListEntities entityList = initEntityList("src\\dataFiles\\Entity.txt"); // Initialize entity list
		ListUsers userList = initUserList("src\\dataFiles\\Users.txt"); // Initialize usersList
		ListOfActivities activityList = initActivitiesList(); // Initialize Activity Structure
		ListReservations reservationList = initReservationList(); // Init reservation list


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
						case  6 -> Register_UserReservation(activityList, reservationList, userList); 
						case  7 -> Show_UsersFromWorkshop(); 
						case  8 -> Highest_UserReservation(); 
						case  9 -> Register_PunctuationFromUserAfterworkshop(); 
						case 10 -> Calculate_AverageWorkshop(); 
						case 11 -> Most_SuccessfulWorkshop(); 
						case 12 -> Show_VisitListFromEntity(); 
						case 13 -> Show_TalkData(); 
						case 14 -> Cancel_Workshop(); 
						case 15 -> exit = true; 
						default -> wrongOption();  // If we insert a wrong number, it'll show a msg
					}
				} catch (NumberFormatException e) { // We catch another input different from a number
					System.out.println("\n\n  ____ ERRROR: You have to write a number ____\n");
				}
			} while (!exit);

			// (not)Store data structures
 			storeDataStructures(activityList, entityList, userList, reservationList);

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

	public static void Show_DataList() {}
	public static void Show_ActivitiesFromEntity() {}
	public static void Show_ActivitiesXDay() {}
	public static void Show_WorkshopListWSpots() {}
	public static void Add_Activity() {}

	/** Method that registers the user's petition to book a workshop's spot */
	public static void Register_UserReservation(ListOfActivities lActv, ListReservations lResv, ListUsers lUser) {
		try {
			System.out.println("\n\n----- Register user's petition to book a workshop's spot -----\n");
			System.out.println("  Select the user that wants to make a reservation: ");
			System.out.println(lUser.showUserName()+ "\n\tOption: ");
			byte opc = keyboard.nextByte();
			System.out.println("  Select the workshop: "  +lActv.filterByWorkShop().showNames());
			byte opc2 = keyboard.nextByte();
			// Create new reservation instance
			// Add the reservation to the list
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void Show_UsersFromWorkshop() {}
	public static void Highest_UserReservation() {}

	/** Method that registers the puntuation from a user after the workshop*/
	public static void Register_PunctuationFromUserAfterworkshop() {
		System.out.println("\n\n----- Register punctuation from user after the WorkShop -----\n");
		System.out.println("  Insert the user's name: ");
		String userName = keyboard.next();
		// Show the user's reservation list that has no rate (rateLvl == null | -1)
		System.out.println("  Insert the satisfaction level [0-10]: ");
		byte rateLvl = keyboard.nextByte();
		// Update the rateLvl into that user reservation 
		// Uptade the sum of the workshop && number of people that have voted
	}
	public static void Calculate_AverageWorkshop() {}
	public static void Most_SuccessfulWorkshop() {}
	public static void Show_VisitListFromEntity() {}
	public static void Show_TalkData() {}
	public static void Cancel_Workshop() {}
	
	/** Method that indicates that the input number is wrong */
	private static void wrongOption() { 
		System.out.println("\n\n  ¡¡¡ Incorrect number input !!! \n\n"); 
	}

	/** Method to initialize the reservation list from 
	 * serialized file
	 * 
	 * @return list of reservations
	 */
	private static ListReservations initReservationList() {
		return null;
	}

	/** Method to initialize the activity list from 
	 * text file
	 * 
	 * @return list of reservations
	 */

	private static ListOfActivities initActivitiesList() {
		return null;
	}

	/** Method to initialize the reservation list from 
	 * text file.
	 * 
	 * @return list of reservations
	 */
	private static ListUsers initUserList(String pathFile) {
		try {
			Scanner f = new Scanner(new File(pathFile));
			String header = f.nextLine();
			int nUsers = Integer.parseInt(f.nextLine());
			System.out.println("There's " +nUsers+ " users.\n  User file format: " +header);
			ListUsers lUser = new ListUsers(nUsers);

			for (int i=0; i < nUsers; i++) {
				String line = f.nextLine(); // Line to line reader
				String[] attributes = line.split(";"); // We split the data with ";"

				// Line processing username, email & postalCode
				String userName = attributes[0].trim();
				String userEmail = attributes[1].trim();
				int userPostalCode = Integer.parseInt(attributes[2].trim());

				Users user = new Users(userName, userEmail, userPostalCode);

				lUser.addUser2List(user);
			}
			f.close();
			System.out.println(" ------- User's list loaded -------\n\n");
			return lUser;
		} catch (FileNotFoundException e) {
			System.err.println("<<<<< User file NOT FOUND in path: " +pathFile+ " >>>>>");
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/** Method to initialize the entity list from 
	 * text file
	 * 
	 * @return list of reservations
	 */
	private static ListEntities initEntityList(String pathFile) {
		try {
			Scanner f = new Scanner(new File(pathFile));
			String header = f.nextLine();
			int nEntities = Integer.parseInt(f.nextLine());
			System.out.println("\n\nThere's " +nEntities+ " entities.\n  User file format: " +header);
			ListEntities lEntity = new ListEntities(nEntities);

			for (int i=0; i < nEntities; i++) {
				String line = f.nextLine(); // Line to line reader
				String[] attributes = line.split(";"); // We split the data with ";"

				// Line processing username, email & postalCode
				String entityName = attributes[0].trim();
				String entityPhoneNumber = attributes[1].trim();
				String entityEmail = attributes[2].trim();

				Entity entity = new Entity(entityName, entityPhoneNumber, entityEmail);

				lEntity.addEntity2List(entity);
			}
			f.close();
			System.out.println(" ------- Entity's list loaded -------\n\n");
			return lEntity;
		} catch (FileNotFoundException e) {
			System.err.println("<<<<< User file NOT FOUND in path: " +pathFile+ " >>>>>");
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/** Method that stores all data structures */
	private static void storeDataStructures(ListOfActivities lActv, ListEntities lEnt, 
															ListUsers lUser, ListReservations lResv) {
		System.out.println("\n\n----- Storage phase of data structures -----\n");
	}
}
