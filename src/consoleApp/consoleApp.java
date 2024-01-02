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

import activities.Activities;
import activities.ActivityType;
import activities.ListOfActivities;
import activities.Talk;
import activities.Visits;
import activities.Workshop;
import entities.Entity;
import entities.ListEntities;
import reservations.ListReservations;
import users.ListUsers;
import users.Users;

public class consoleApp {
   // Declaration of keyboard readers
   private static Scanner keyboard = new Scanner(System.in); // reads from keyboard
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// Global variables to catch the headers of each file 
	private static String ActivityListHeader, TalkListHeader, VisitListHeader, WorkShopListHeader;

   public static void main(String[] args) throws IOException {
		// Data initialization phase
		ListEntities entityList = initEntityList("src\\dataFiles\\Entity.txt"); // Initialize entity list
		ListUsers userList = initUserList("src\\dataFiles\\Users.txt"); // Initialize usersList
		ListOfActivities activityList = initActivitiesList("src\\dataFiles\\Activity.txt"); // Initialize Activity Structure
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
		System.out.println("\n\n----- Register user's petition to book a workshop's spot -----\n");
	}
	public static void Show_UsersFromWorkshop() {}
	public static void Highest_UserReservation() {}

	/** Method that registers the puntuation from a user after the workshop*/
	public static void Register_PunctuationFromUserAfterworkshop() {
		System.out.println("\n\n----- Register punctuation from user after the WorkShop -----\n");
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
	private static ListOfActivities initActivitiesList(String pathFile) {
		Scanner f = null;
		try {
			f = new Scanner(new File(pathFile)); // File reader
			ActivityListHeader = f.nextLine(); // Activity header
			TalkListHeader = f.nextLine(); // Talk header
			VisitListHeader = f.nextLine(); // Visit header
			WorkShopListHeader = f.nextLine(); // Workshop header
			int nActivities = Integer.parseInt(f.nextLine()); // Number of activities
			System.out.println("There's " +nActivities+ " activities.\n\n"  
									 +" Activity file format: \n  " +ActivityListHeader+ "\n"
									 +" Talk format: \n  " +TalkListHeader+ "\n"
									 +" Visit format: \n  " +VisitListHeader+ "\n"
									 +" WorkShop format: \n  " +WorkShopListHeader+ "\n"); // Show data

			ListOfActivities lActiv = new ListOfActivities(nActivities); // New list of activities

			// Iteration over the list to get all data
			for (int i=0; i < nActivities; i++) {
				String line = f.nextLine(); // Get the next line
				int firstData = line.indexOf(';'); // Get the activity type in number format
				String[] attrib = line.split(";"); // Data split
				ActivityType actType = ActivityType.valueOf(attrib[0]); // Activity Type

				// We create a new default activity depending on the type
				Activities activity = switch(actType) {
					case TALK -> new Talk("","","","",0,0,"");
					case VISIT -> new Visits(false,false,"","","",0,0,"");
					case WORKSHOP -> new Workshop("",0,0,0,0,0,"","","",0,0,"");
				};
				activity.fromTextFormat(line.substring(firstData + 1)); // Process activity data
				lActiv.addActivity(activity); // add to the list
			}
			System.out.println(" ------- Activity list loaded -------\n\n");
			return lActiv;
									 
		} catch (FileNotFoundException e) {
			System.err.println("<<<<< Activity.txt file NOT FOUND in path: " +pathFile+ " >>>>>");
			return null;
		} catch (Exception e) {
			e.printStackTrace(); return null;
		} finally {
			f.close();
		}
	}

	/** Method to initialize the reservation list from 
	 * text file.
	 * 
	 * @return list of reservations
	 */
	private static ListUsers initUserList(String pathFile) {
		Scanner f = null;
		try {
			f = new Scanner(new File(pathFile)); // File reader
			String header = f.nextLine(); // Header of the user text file
			int nUsers = Integer.parseInt(f.nextLine()); // Number of users in the file
			System.out.println("There's " +nUsers+ " users.\n  User file format: " +header);
			ListUsers lUser = new ListUsers(nUsers); // Setting a new list

			// Iterate over the lines of the text file
			for (int i=0; i < nUsers; i++) {
				String line = f.nextLine(); // Line to line reader
				String[] attributes = line.split(";"); // We split the data with ";"

				// Line processing username, email & postalCode
				String userName = attributes[0].trim();
				String userEmail = attributes[1].trim();
				int userPostalCode = Integer.parseInt(attributes[2].trim());

				Users user = new Users(userName, userEmail, userPostalCode); // New user instance

				lUser.addUser2List(user); // Add to the users list
			}
			System.out.println(" ------- User's list loaded -------\n\n");
			return lUser;
		} catch (FileNotFoundException e) {
			System.err.println("<<<<< Users.txt file NOT FOUND in path: " +pathFile+ " >>>>>");
			return null;
		} catch (Exception e) {
			e.printStackTrace(); return null;
		} finally {
			f.close();
		}
	}

	/** Method to initialize the entity list from 
	 * text file.
	 * 
	 * @return list of reservations
	 */
	private static ListEntities initEntityList(String pathFile) {
		Scanner f = null;
		try {
			f = new Scanner(new File(pathFile));
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
			System.out.println(" ------- Entity's list loaded -------\n\n");
			return lEntity;
		} catch (FileNotFoundException e) {
			System.err.println("<<<<< Entity.txt file NOT FOUND in path: " +pathFile+ " >>>>>");
			return null;
		} catch (Exception e) {
			e.printStackTrace(); return null;
		} finally {
			f.close();
		}
	}
	
	/** Method that stores all data structures */
	private static void storeDataStructures(ListOfActivities lActv, ListEntities lEnt, 
															ListUsers lUser, ListReservations lResv) {
		System.out.println("\n\n----- Storage phase of data structures -----\n");
	}
}
