/** Class consoleApp.java
 * 
 * This class is made for making a full functional app
 *  to manage the event "Setmana de la Ciència a la URV 2023"
 *  between 10 and 19 of November of 2023.
 * 
 * @author Joan David Frent Frent (joandavid.frentf@estudiants.urv.cat)
 * @author Juan Carlos Medinilla Alonso (juancarlos.medinilla@estudiants.urv.cat)
 * @author Aleix (aleix.chillida@estudiants.urv.cat)
 * @author David lopez (david.lopez@estudiants.urv.cat)
 */
package consoleApp;

import java.io.*;
import java.util.*;

import activities.*;
import entities.*;
import exceptions.*;
import reservations.*;
import users.*;

public class consoleApp {
   // Declaration of keyboard readers
   private static Scanner keyboard = new Scanner(System.in); // reads from keyboard
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static FileManager fManage = SharedApp.fManager;

   public static void main(String[] args) throws IOException, ActivityListEmpty {
		// Data initialization phase
		ListEntities entityList = fManage.getListEntities(); // Initialize entity list
		ListUsers userList = fManage.getListUsers(); // Initialize usersList
		ListOfActivities activityList = fManage.getListActivities(); // Initialize Activity Structure
		ListReservations reservationList = fManage.getListReservations(); // Init reservation list

		boolean exit = false; // Boolean to handle if the user wants to end the program
			// Main loop
			do {
				try {
					menu();
					int opt = Integer.parseInt(keyboard.next()); // user's input
					switch (opt) {
						// We use '->' to remove the need of adding a 'break;' after each case
						// Important note: can't add more than 1 instruction to each case
						case  1 -> Show_DataList(userList, reservationList, activityList, entityList);
					 	case  2 -> Show_ActivitiesFromEntity(); 
						case  3 -> Show_ActivitiesXDay(); 
						case  4 -> Show_WorkshopListWSpots(activityList); 
						case  5 -> Add_Activity(activityList); 
						case  6 -> Register_UserReservation(userList, activityList, reservationList); 
						case  7 -> Show_UsersFromWorkshop(reservationList); 
						case  8 -> Highest_UserReservation(reservationList, userList); 
						case  9 -> Register_PunctuationFromUserAfterworkshop(userList, reservationList, activityList); 
						case 10 -> Calculate_AverageWorkshop(activityList); 
						case 11 -> Most_SuccessfulWorkshop(activityList); 
						case 12 -> Show_VisitListFromEntity(activityList); 
						case 13 -> Show_TalkData(activityList); 
						case 14 -> Cancel_Workshop(activityList); 
						case 15 -> exit = true; 
						default -> wrongOption();  // If we insert a wrong number, it'll show a msg
					}
				} catch (NumberFormatException e) { // We catch another input different from a number
					System.out.println("\n\n  ____ ERRROR: You have to write a number ____\n");
				}
			} while (!exit);

			// (not)Store data structures
 			storeDataStructures(activityList, reservationList);

			// We show a msg to indicate that the program has ended
			System.out.println("\n\n\n=============== THE END ===============\n\n\n");
			
			// We close everything we used to free memory
			keyboard.close();
			br.close();
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

	/** Method that displays all data for the week science
	 * 
	 * @param lUser list of users
	 * @param lEntity list of entities
	 * @param lActiv list of activities
	 * @param lResv list of reservations
	 */
	public static void Show_DataList(ListUsers lUser, ListReservations lResv,
	 										ListOfActivities lActiv, ListEntities lEntity) {
		System.out.println("\n\n----- Show Data List -----\n");

		//Users List
		System.out.println(lUser.toString());

		//Entities List
		System.out.println(lEntity.toString());

		//Activities List
		System.out.println(lActiv.toString());
		
		//Reservations List
		System.out.println(lResv.toString());

	}
	public static void Show_ActivitiesFromEntity() {
		System.out.println("\n\n----- Show the activity list from a specific entity -----\n");
	}
	public static void Show_ActivitiesXDay() {
		System.out.println("\n\n----- Show the activity list from a given day -----\n");
	}
	
	/** Method that shows a list of workshops with available spots
	 * 
	 * @param lActv list of activities
	 */
	public static void Show_WorkshopListWSpots(ListOfActivities lActv) {
		System.out.println("\n\n----- Show the workshop list with available spots -----\n");

		ListOfActivities lWorkshop = lActv.filterByWorkShop();
		ListOfActivities lWorkshopWSpots = new ListOfActivities();

		for(int i = 0; i < lWorkshop.getnElem(); i++){
			
			Activities activity = lWorkshop.getListActv()[i];
			Workshop workshop = (Workshop) activity;

			int capacity = workshop.getCapacity();
			if(capacity > 0){
				lWorkshopWSpots.addActivity(workshop);
			}
		}

		for(int i = 0; i < lWorkshopWSpots.getnElem(); i++){
			Activities activity = lWorkshopWSpots.getListActv()[i];
			Workshop workshop = (Workshop) activity;
			System.out.println(workshop.toString());

		}
	}
	
	/** Method to add an activity to the list
	 * @param lActiv
	 */
	public static void Add_Activity(ListOfActivities lActiv) {
		System.out.println("\n\n----- Add new activity -----\n");
	}

	/** Method to register a user reservation
	 * 
	 * @param lUser list users
	 * @param lActv list activities
	 * @param lResv list reservations
	 */
	public static void Register_UserReservation(ListUsers lUser, ListOfActivities lActv,
																ListReservations lResv) {
		System.out.println("\n\n----- Register user's petition to book a workshop's spot -----\n");
		String userName, wkCode;
		int code;
		try {
			do { // Loop to check if the user is valid or not
				System.out.println("Who wants to book a spot to a workshop?\n  " +lUser.showUserName());
				System.out.print("  Write its name: ");
				userName = br.readLine();
			} while (lUser.isThisUserName(userName) == false); 

			Users user = lUser.getUserDataByName(userName); // Get user data

			// Filter reservation list by user / activities list by workshop
			ListReservations resvUser = lResv.filterByUserName(userName);
			ListOfActivities activUser = lActv.filterByWorkShop();
			// List with activities without the user being already subscribed to
			ListOfActivities userWSNotReserved = new ListOfActivities(activUser.getnElem());

			// If the reservation list is not empty, there's some reservation made
			if (resvUser.getnElem() > 0) {
				// Iterate over the filtered activity list
				for (int i=0; i < activUser.getnElem(); i++) {
					// Iterate over the reservation list
					for (int j = 0; j < resvUser.getnElem(); j++) {
						// If the activity code doesn't exist in the reservation list, we add it to the auxiliar list
						if (resvUser.checkWorkShopCode(activUser.getListActv()[i].getActivityCode()) == false)
							userWSNotReserved.addActivity(activUser.getListActv()[i]);
					}
				}
			} else {
				userWSNotReserved = lActv.filterByWorkShop();
			}

			if (userWSNotReserved.getnElem() != 0) {
				do { // Loop to check if the workshop code is valid or not
					System.out.println("\n\nWhich workshop does the user want to book?\n  " 
																	+userWSNotReserved.showNamesSpotsLeftAndCode());			
					System.out.print("  Write its code: ");
					wkCode = br.readLine();
				} while (lActv.checkActivCode(wkCode) == false);
	
				Workshop wshop = lActv.getWorkShopByCode(wkCode);
				
				do { // Loop to generate random code
					code = randomReservationCode();
				} while (lResv.checkReservationCode(code) == true);
	
				// Creation of new reservation instance
				Reservation resv = new Reservation(code, user.getName(), wshop.getActivityCode(), -1);
				lResv.addReservation(resv); // Add it to the list
	
				lActv.registerNewSpotReserved(wkCode); // Update spots left
	
				System.out.println("\n  Reservation data:\n" +resv);
	
				System.out.println("\n\n----- The reservation has been made successfully -----\n");
			} else {
				System.out.println("\n\n----- The user " +user.getName()+ " has already booked all the workshops -----\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** Method to generate a random reservation code
	 * @return random number
	 */
	private static int randomReservationCode() { return new Random().nextInt(200); }
	
	/** Method to displays the user data from the workshop
	 * @param lResv list of reservations
	 */
	public static void Show_UsersFromWorkshop(ListReservations lResv) {
		System.out.println("\n\n----- Show user's list from a workshop -----\n");
		
		System.out.println("Enter the workshop code");
		String workshopCode = keyboard.nextLine();
		boolean userFound = false;
		
		try{
			for(int i = 0; i < lResv.getnElem(); i++){
				Reservation currentReservation = lResv.getReservation(i);

				if(currentReservation.getIdWorkShop().equals(workshopCode)){
					System.out.println("User: " +currentReservation.getUser());
					userFound = true;
				}	
			}
			if(!userFound)
				throw new NoReservationFound("No reservations found for workshop with code: " +workshopCode);
		} catch (NoReservationFound e){
			System.out.println(e.getMessage());
		}
	}
	
	/** Method to display the user with the most bookings
	 * 
	 * @param lResv reservation list
	 * @param lUser user list
	 */
	public static void Highest_UserReservation(ListReservations lResv, ListUsers lUser) {
		System.out.println("\n\n----- Show which user booked more workshops -----\n");
		
		String maxUser = null;
		int maxReservations = 0;

		try {
			ListReservations lResvCopy = lResv.copyListReserv();

			for(int i = 0; i < lResv.getnElem(); i++){
				Reservation reservation = lResvCopy.getListRes()[i];
				String nameUser = reservation.getUser();
        		int count = 0;

        		for (int j = 0; j < lResv.getnElem(); j++) {
					Reservation reservation2 = lResvCopy.getListRes()[j];
					String nameUser2 = reservation2.getUser();
            		if (nameUser2.equals(nameUser)) {
                		count++;
            		}
        		}

        		if (count > maxReservations) {
        	    	maxUser = nameUser;
        	    	maxReservations = count;
        		}
			}

			Users usr = lUser.getUserDataByName(maxUser);
			if (maxUser != null) 
				System.out.println("User with most workshop bookings: " + usr + ", Bookings: " + maxReservations);
			else 
				System.out.println("No bookings found.");
			
		} catch (NullPointerException e) {
			System.out.println("No bookings found.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/** Method to register the satisfaction level from a user
	 * after the workshop
	 * 
	 * @param lUser user list
	 * @param lResv reservation list
	 * @param lActiv activity list
	 */
	public static void Register_PunctuationFromUserAfterworkshop(ListUsers lUser, 
													ListReservations lResv, ListOfActivities lActiv) {
		System.out.println("\n\n----- Register punctuation from user after the WorkShop -----\n");
      try {
			String uName;
			do { // Loop to check if the user is valid or not
				System.out.println("Who wants to rate a workshop?\n  " +lUser.showUserName());
				System.out.print("\n  Write its name: ");
				uName = br.readLine();
			} while (lUser.isThisUserName(uName) == false);

			// Auxiliar list for filtering a workshop that has been booked and has not been rated yet
			ListOfActivities wkBookedNoVotation = new ListOfActivities(lActiv.getNumberWorkShops());

			// We iterate from each reservation instance over the activity instance (both lists)
			// We check if the reservation workshop id is the same as the activity code from the activ list
			// We also check if the rate level is -1, which means that the user has not rated the workshop yet
			for (int i = 0; i < lResv.getnElem(); i++) {
				for (int j = 0; j < lActiv.getnElem(); j++) {
					if ((lResv.getListRes()[i].getIdWorkShop() == lActiv.getListActv()[j].getActivityCode())
						 && (lResv.getListRes()[i].getRateLvl() == -1))
						wkBookedNoVotation.addActivity(lActiv.getListActv()[j]);
					
				}
			} // With all that we get an activity list fitered with the activity code
			  // and if the user rated or not

			String wkCode;

			if (wkBookedNoVotation.getnElem() != 0) {
				do { // Loop to check if the workshop code is valid or not
					System.out.println("\n\nWhich workshop does the user want to rate?\n  " 
																	+wkBookedNoVotation.showNamesAndCode());			
					System.out.print("  Write its code: ");
					wkCode = keyboard.next();
				} while (wkBookedNoVotation.checkActivCode(wkCode) == false);
	
				byte rate;
				do { // Loop to ask for the rate
					System.out.print("\n\nIndicate the rate you want to give to the workshop: ");
					rate = keyboard.nextByte();
				} while (rate < 0 && rate > 10);
	
				// register punctuation in the reservation
				lResv.registerPunctuation(wkCode, rate);
				
				// register total punctuation into the workshop activity
				lActiv.registerPunctuationInWorkShop(wkCode, rate);
				System.out.println("\n\n----- The rating was registered successfully -----\n");
			} else {
				System.out.println("\n\n----- The user " +uName+ " has not booked yet or rated every booking -----\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("\n\n  ____ ERRROR: You have to write a number ____\n");
		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("No bookings found.");
		} catch (Exception e) {
			e.printStackTrace();
		
		}
	}
	
	/** Method to calculate the average a workshop has recieved
	 * @param lActiv
	 */
	public static void Calculate_AverageWorkshop(ListOfActivities lActiv) {
		System.out.println("\n\n----- Calculate the average that a workshop has recieved -----\n");
		
		System.out.println("Enter the workshop name");
		String workshopName = keyboard.nextLine();
		workshopName = keyboard.nextLine();

		while(!workshopName.matches("[a-zA-Z ]+")) {
    		System.out.println("Enter a valid name");
    		workshopName = keyboard.nextLine();
		}

		ListOfActivities lWorkshop = lActiv.filterByWorkShop();
		Activities[] workshops = lWorkshop.getListActv();
    	
		for(int i = 0; i < lWorkshop.getnElem(); i++){
			Activities activity = workshops[i];
			Workshop workshop = (Workshop) activity;

			if(workshop.getActivityName().equalsIgnoreCase(workshopName)){
				double average = workshop.getScores();
				System.out.println("Average score of the workshop => "+average);
			}else if(i == lWorkshop.getnElem()-1){
				System.out.println("No workshop found with the given name.");
			}

		}

	}

	/** Method to get the most successful worksghop
	 * @param lActiv activity list
	 */
	public static void Most_SuccessfulWorkshop(ListOfActivities lActiv) {

		System.out.println("\n\n----- Get the most successful workshop -----\n");
		double maxSuccessRate = -1;
		Workshop mostSuccessfulWorkshop = null;

		Activities[] activities = lActiv.getListActv();
		for(int i = 0; i < lActiv.getnElem(); i++){
			Activities activity = activities[i];

			if(activity instanceof Workshop){
				Workshop workshop = (Workshop) activity;
				double successRate = ((double) (workshop.getCapacity() - workshop.getSpotsLeft()) / workshop.getCapacity());

				if(successRate > maxSuccessRate){
					maxSuccessRate = successRate;
					mostSuccessfulWorkshop = workshop;
				}
			} 
		}
			if(mostSuccessfulWorkshop != null){
				System.out.println("Most succeful workshop => "+mostSuccessfulWorkshop);
			}
			else{
				System.out.println("No workshops found");
			}
		}
	
	/** Method to show the visit list from an entity
	 * @param lActiv activity list
	 */
	public static void Show_VisitListFromEntity(ListOfActivities lActiv) {
		System.out.println("\n\n----- Show visit's list offered by an entity -----\n");
	}

	/** Method to show the data of a talk that the speaker will do
	 * @param lActiv
	 */
	public static void Show_TalkData(ListOfActivities lActiv) {
		System.out.println("\n\n----- Show the talk data that the person will do -----\n");

		try{
		System.out.println("Enter the speaker name");
		String speakerName = keyboard.nextLine();
		speakerName = keyboard.nextLine();

		for(int i = 0; i < lActiv.getnElem(); i++){
			Activities currentActivity = lActiv.getActivity(i);

			if (currentActivity instanceof Talk && ((Talk) currentActivity).getSpeakerName().equals(speakerName)) {
				System.out.println(currentActivity.toString());
			}
		}
	} catch(InputMismatchException e){
		System.out.println("Enter a correct speaker name");
	}

}
	
	/** Method to cancel a workshop
	 * @param lActiv activity list
	 */
	public static void Cancel_Workshop(ListOfActivities lActiv) {
		System.out.println("\n\n----- Cancel a workshop -----\n");

		String wCode;

		System.out.println("Enter the workshop name");
		String workshopName = keyboard.nextLine();
		workshopName = keyboard.nextLine();

		while(!workshopName.matches("[a-zA-Z ]+")) {
    		System.out.println("Enter a valid name");
    		workshopName = keyboard.nextLine();
		}

		for(int i = 0; i < lActiv.getnElem(); i++){
			Activities currentActivity = lActiv.getActivity(i);
			
			if(currentActivity instanceof Workshop && currentActivity.getActivityName().equalsIgnoreCase(workshopName)){
				Workshop workshop = (Workshop) currentActivity;

				if(workshop.getSpotsLeft() == workshop.getCapacity()){
					wCode = workshop.getActivityCode();
					lActiv.deleteActivity(wCode);
					System.out.println("Workshop cancelled");
				} else {
					System.out.println("Workshop not cancelled(spots left: "+workshop.getSpotsLeft()+")");
				}
			}
		}
		
	}

	/** Method that stores in files the data structures
	 * 
	 * @param lActv list of activities to store
	 * @param lResv list of reservations to store
	 * @throws ActivityListEmpty
	 */
	private static void storeDataStructures(ListOfActivities lActv, ListReservations lResv) throws ActivityListEmpty {
		boolean exit = false;
		do {
			System.out.println("\n\n----- Storage phase of data structures -----\n");
			System.out.println(" Do you want to store everything you've done?");
			System.out.println("   1. Yes");
			System.out.println("   2. No (Will loose all modification data)");
			System.out.print("\tOption: ");
			try {
				byte opt = Byte.parseByte(keyboard.next());
				switch (opt) {
					case 1: storeActivities(lActv); storeReservations(lResv); exit=true;
						break;
					case 2: System.out.println("\n\n\t ······ All modifications lost ······\n\n");
						exit=true;
						break;
					default: wrongOption(); 
						break;
				}			
			} catch (NumberFormatException e) {
				System.out.println("\n\n  ____ ERRROR: You have to write a number ____\n");
			}
		} while (!exit);

	}

	/** Method to store the reservation list into a serialized file
	 * 
	 * @param lResv list of reservations
	 */
	private static void storeReservations(ListReservations lResv) {
		try {
			if (lResv.getnElem() != 0) { // If there's something in the list, we store it
				var oFile = new ObjectOutputStream(new FileOutputStream("src\\dataFiles\\Reservation.ser"));
				oFile.writeInt(lResv.getnElem());
	
				for (int i=0; i < lResv.getnElem(); i++)
					oFile.writeObject(lResv.getListRes()[i]);

				System.out.println("\n\n ------- Reservation list stored -------\n");
				oFile.close();
			} else {
				System.out.println("\n\n ------- Nothing to store from the reservation list -------\n\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** Method that stores into a text file the list of Activities
	 * 
	 * @param lActv list of activities
	 * @throws ActivityListEmpty
	 */
	private static void storeActivities(ListOfActivities lActv) throws ActivityListEmpty {
		Writer f = null;
		try {
			if (lActv.getnElem() != 0) {
				f = new BufferedWriter(new FileWriter("src\\dataFiles\\Activities.txt"));
				var array = lActv.getListActv(); // We get the activity list
				f.write(fManage.getActivHeader()+ "\n");
				f.write(fManage.getTalkHeader()+ "\n");
				f.write(fManage.getVisitHeader()+ "\n");
				f.write(fManage.getWorkShopHeader()+ "\n"); // Write headers of the activity list
				f.write(Integer.toString(lActv.getnElem())+ "\n"); // Write nElements of the list
	
				// Iterate over the elements of the list and write it into the file
				for (int i = 0; i < lActv.getnElem(); i++) {
					// Activity Type, to know which type of activity it is
					f.write(array[i].getActType().name());
					f.write(";");
	
					// Now the activity data
					f.write(array[i].toTextFormat());
					f.write("\n");
				}
				System.out.println("\n\n ------- Activity list stored -------\n");
			} else {
				throw new ActivityListEmpty();
			}
		} catch (IOException e) {
			System.err.println("\t<<<<< Error writing the file >>>>>");
		} finally {
			try {
				f.close();
			} catch (IOException e) {
				System.err.println("\t<<<<< Error closing the file >>>>>");
			}
		}
	}
	
	/** Method that indicates that the input number is wrong */
	private static void wrongOption() { 
		System.out.println("\n\n  ¡¡¡ Incorrect number input !!! \n\n"); 
	}
}