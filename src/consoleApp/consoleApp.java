/** Class consoleApp.java
 * 
 * This class is made for making a full functional app
 *  to manage the event "Setmana de la Ciència a la URV 2023"
 *  between 10 and 19 of November of 2023.
 * 
 * @author Joan David Frent Frent (joandavid.frentf@estudiants.urv.cat)
 * @author Juan Carlos Medinilla Alonso (juancarlos.medinilla@estudiants.urv.cat)
 * @author Aleix (aleix.chillida@estudiants.urv.cat)
 * @author ZZZZ (zzzz.zzzz@estudiants.urv.cat)
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
	// Global variables to catch the headers of each file 
	private static String ActivityListHeader, TalkListHeader, VisitListHeader, WorkShopListHeader;
	private static File fileCheck; // To chekc if the file exists

   public static void main(String[] args) throws IOException, ActivityListEmpty {
		// Data initialization phase
		ListEntities entityList = initEntityList("src\\dataFiles\\Entity.txt"); // Initialize entity list
		ListUsers userList = initUserList("src\\dataFiles\\Users.txt"); // Initialize usersList
		ListOfActivities activityList = initActivitiesList("src\\dataFiles\\Activity.txt"); // Initialize Activity Structure
		ListReservations reservationList = initReservationList("src\\dataFiles\\Reservation.ser"); // Init reservation list

		boolean exit = false; // Boolean to handle if the user wants to end the program
			// Main loop
			do {
				try {
					menu();
					int opt = Integer.parseInt(keyboard.next()); // user's input
					switch (opt) {
						// We use '->' to remove the need of adding a 'break;' after each case
						// Important note: can't add more than 1 instruction to each case
						case  1 -> Show_DataList(userList, /*reservationList,*/ activityList, entityList);
					 	case  2 -> Show_ActivitiesFromEntity(); 
						case  3 -> Show_ActivitiesXDay(); 
						case  4 -> Show_WorkshopListWSpots(activityList); 
						case  5 -> Add_Activity(); 
						case  6 -> Register_UserReservation(userList, activityList, reservationList); 
						case  7 -> Show_UsersFromWorkshop(); 
						case  8 -> Highest_UserReservation(reservationList, userList); 
						case  9 -> Register_PunctuationFromUserAfterworkshop(userList, reservationList, activityList); 
						case 10 -> Calculate_AverageWorkshop(activityList); 
						case 11 -> Most_SuccessfulWorkshop(activityList); 
						case 12 -> Show_VisitListFromEntity(); 
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

	public static void Show_DataList(ListUsers lUser, //ListReservations lResv,
	 										ListOfActivities lActiv, ListEntities lEntity) {
		System.out.println("\n\n----- Show Data List -----\n");

		//Users List
		System.out.println(lUser.toString());

		//Reservations List
		//System.out.println(lResv.toString());

		//Activities List
		System.out.println(lActiv.toString());

		//Entities List
		System.out.println(lEntity.toString());

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
	
	public static void Add_Activity() {
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

			// Filter reservation list by user / activities list by workshop
			ListReservations resvUser = lResv.filterByUserName(userName);
			ListOfActivities activUser = lActv.filterByWorkShop();
			// List with activities without the user being already subscribed to
			ListOfActivities userWSNotReserved = new ListOfActivities(activUser.getnElem());

			// Iteration over the two lists to compare if the code in the reservation list
			// is (not) the same as the activity list
			// With this we filter the activities the user already booked in
			for (int i=0; i < resvUser.getnElem(); i++) {
				for (int j = 0; j < activUser.getnElem(); j++) {
					if (resvUser.getListRes()[i].getIdWorkShop() != activUser.getListActv()[j].getActivityCode()) {
						userWSNotReserved.addActivity(activUser.getListActv()[j]);
					}
				}
			}

			do { // Loop to check if the workshop code is valid or not
				System.out.println("\n\nWhich workshop does the user want to book?\n  " 
																+userWSNotReserved.showNamesSpotsLeftAndCode());			
				System.out.print("  Write its code: ");
				wkCode = br.readLine();
			} while (userWSNotReserved.checkActivCode(wkCode) == false);

			Workshop wshop = userWSNotReserved.getWorkShopByCode(wkCode); // Get workshop data

			do { // Loop to generate random code
				code = randomReservationCode();
			} while (lResv.checkReservationCode(code) == true);

			// Creation of new reservation instance
			Reservation resv = new Reservation(code, userName, wshop.getActivityCode(), -1);
			wshop.setSpotsLeft(wshop.getSpotsLeft()-1); // Update spots left

			lResv.addReservation(resv); // Add it to the list
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			// No need to show anything because the list is empty
		}
	}

	/** Method to generate a random reservation code
	 * @return random number
	 */
	private static int randomReservationCode() { return new Random().nextInt(200); }

	public static void Show_UsersFromWorkshop() {
		System.out.println("\n\n----- Show user's list from a workshop -----\n");
		
	}
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
			if (maxUser != null) {
				System.out.println("User with most workshop bookings: " + usr + ", Bookings: " + maxReservations);
			} else {
				System.out.println("No bookings found.");
			}
		} catch (NullPointerException e) {
			System.out.println("No bookings found.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

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

			// Filter the list of reservations by the user name
			ListReservations resvUser = lResv.filterByUserName(uName);
			// Filter the list of activities by the workshop
			ListOfActivities wshopUser = lActiv.filterByWorkShop();
			// Auxiliar list for filtering a workshop that has been booked and has not been rated yet
			ListOfActivities wkBookedNoVotation = new ListOfActivities(wshopUser.getnElem());

			// We iterate from each reservation instance over the activity instance
			// We check if the reservation workshop id is the same as the activity code from the activ list
			// We also check if the rate level is -1, which means that the user has not rated the workshop yet
			for (int i = 0; i < resvUser.getnElem(); i++) {
				for (int j = 0; j < wshopUser.getnElem(); j++) {
					if ((resvUser.getListRes()[i].getIdWorkShop() == wshopUser.getListActv()[j].getActivityCode())
						 && (resvUser.getListRes()[i].getRateLvl() == -1))
						wkBookedNoVotation.addActivity(wshopUser.getListActv()[j]);
					
				}
			} // With all that we get an activity list fitered with the activity code
			  // and if the user rated or not

			String wkCode;
			do { // Loop to check if the workshop code is valid or not
				System.out.println("\n\nWhich workshop does the user want to rate?\n  " 
																+wkBookedNoVotation.showNamesAndCode());			
				System.out.print("  Write its code: ");
				wkCode = keyboard.next();
			} while (wkBookedNoVotation.checkActivCode(wkCode) == false);

			byte rate;
			do { // Loop to ask for the rate
				System.out.println("\n\nIndicate the rate you want to give to the workshop: ");
				rate = keyboard.nextByte();
			} while (rate < 0 && rate > 10);

			// register punctuation in the reservation
			lResv.registerPunctuation(wkCode, rate);
			
			// register total punctuation into the workshop activity
			lActiv.registerPunctuationInWorkShop(wkCode, rate);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
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

			if(workshop.getActivityName().equals(workshopName)){
				double average = workshop.getScores();
				System.out.println("Average score of the workshop => "+average);
			}else if(i == lWorkshop.getnElem()-1){
				System.out.println("No workshop found with the given name.");
			}

		}

	}

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
	public static void Show_VisitListFromEntity() {
		System.out.println("\n\n----- Show visit's list offered by an entity -----\n");
	}

	public static void Show_TalkData(ListOfActivities lActiv) {
		System.out.println("\n\n----- Show the talk data that the person will do -----\n");

		System.out.println("Enter the speaker name");
		String speakerName = keyboard.nextLine();

		for(int i = 0; i < lActiv.getnElem(); i++){
			Activities currentActivity = lActiv.getActivity(i);

			if (currentActivity instanceof Talk && ((Talk) currentActivity).getSpeakerName().equals(speakerName)) {
				System.out.println(currentActivity.toString());
			}
		}	
	}
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
			
			if(currentActivity instanceof Workshop && currentActivity.getActivityName().equals(workshopName)){
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
	
	/** Method that indicates that the input number is wrong */
	private static void wrongOption() { 
		System.out.println("\n\n  ¡¡¡ Incorrect number input !!! \n\n"); 
	}


	/** Method to initialize the activity list from 
	 * text file
	 * 
	 * @param pathFile ubication of the file to load
	 * @return list of reservations
	 */
	private static ListOfActivities initActivitiesList(String pathFile) {
		Scanner f = null;
		try {
			fileCheck = new File(pathFile); // Check if the file exists

			if (fileCheck.exists()) {
				f = new Scanner(new File(pathFile)); // File reader
				ActivityListHeader = f.nextLine(); // Activity header
				TalkListHeader = f.nextLine(); // Talk header
				VisitListHeader = f.nextLine(); // Visit header
				WorkShopListHeader = f.nextLine(); // Workshop header
				int nActivities = Integer.parseInt(f.nextLine()); // Number of activities
				//System.out.println("There's " +nActivities+ " activities.\n\n"  
				//						 +" Activity file format: \n  " +ActivityListHeader+ "\n"
				//						 +" Talk format: \n  " +TalkListHeader+ "\n"
				//						 +" Visit format: \n  " +VisitListHeader+ "\n"
				//						 +" WorkShop format: \n  " +WorkShopListHeader+ "\n"); // Show data
	
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
			} else {
				ListOfActivities lActiv = new ListOfActivities();
				System.out.println(" ------- Activity list loaded -------\n\n");
				return lActiv;
			}								 
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
	 * @param pathFile ubication of the file to load
	 * @return list of reservations
	 */
	private static ListUsers initUserList(String pathFile) {
		Scanner f = null;
		try {
			f = new Scanner(new File(pathFile)); // File reader
			//String header = f.nextLine(); // Header of the user text file
			f.nextLine();
			int nUsers = Integer.parseInt(f.nextLine()); // Number of users in the file
			//System.out.println("There's " +nUsers+ " users.\n  User file format: " +header);
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
	 * @param pathFile ubication of the file to load
	 * @return list of reservations
	 */
	private static ListEntities initEntityList(String pathFile) {
		Scanner f = null;
		try {
			f = new Scanner(new File(pathFile));
			//String header = f.nextLine();
			f.nextLine();
			int nEntities = Integer.parseInt(f.nextLine());
			//System.out.println("\n\nThere's " +nEntities+ " entities.\n  User file format: " +header);
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
			System.out.println("\n------- Entity's list loaded -------\n\n");
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
			System.out.println("   2. No (Will loose al modification data)");
			System.out.print("\tOption:");
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

	/** Method that stores into a text file the list of Activities
	 * 
	 * @param lActv list of activities
	 * @throws ActivityListEmpty
	 */
	private static void storeActivities(ListOfActivities lActv) throws ActivityListEmpty {
		Writer f = null;
		try {
			if (lActv.getnElem() != 0) {
				f = new BufferedWriter(new FileWriter("Activities.txt"));
				var array = lActv.getListActv(); // We get the activity list
				f.write(ActivityListHeader+ "\n");
				f.write(TalkListHeader+ "\n");
				f.write(VisitListHeader+ "\n");
				f.write(WorkShopListHeader+ "\n"); // Write headers of the activity list
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
				System.out.println(" ------- Activity list stored -------\n\n");
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

	/** Method to initialize the reservation list from 
	 * serialized file
	 * 
	 * @return list of reservations
	 */
	private static ListReservations initReservationList(String pathFile) {
		try {
			File check = new File(pathFile);

			if (check.exists()) { // If the file in that path exists
				var iFile = new ObjectInputStream(new FileInputStream(pathFile));
				
				var length = iFile.readInt(); // Length of the list
				ListReservations lResvData = new ListReservations(length); // New reserv list
	
				// Iteration over the list to get all data deserializing it
				for (int i = 0; i < length; i++)
					lResvData.addReservation((Reservation)iFile.readObject());
	
				iFile.close();
				System.out.println(" ------- Reservation list loaded -------\n\n");
				return lResvData;
			} else { // If not we create an empty list
				ListReservations lResvEmpty = new ListReservations();
				System.out.println(" ------- Reservation list loaded -------\n\n");
				return lResvEmpty;
			}
	  	} catch (IOException e) {
			e.printStackTrace();
			return null;
	  	} catch (Exception e) {
			e.printStackTrace();
			return null;
	  	}
	}

	/** Method to store the reservation list into a serialized file
	 * 
	 * @param lResv list of reservations
	 */
	private static void storeReservations(ListReservations lResv) {
		try {
			if (lResv.getnElem() != 0) { // If there's something in the list, we store it
				var oFile = new ObjectOutputStream(new FileOutputStream("ListReservations.ser"));
				var resvArray = lResv.getListRes();
				oFile.writeInt(resvArray.length);
	
				for (Reservation resv : resvArray)
					oFile.writeObject(resv);

				System.out.println(" ------- Reservation list stored -------\n\n");
				oFile.close();
			} else {
				System.out.println(" ------- Nothing to store from the reservation list -------\n\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}