/** Class FileManager.java
 *
 * This class is made to load data from files
 *
 * @author Joan David Frent Frent (joandavid.frentf@estudiants.urv.cat)
 */
package consoleApp;

import java.io.*;
import java.util.Scanner;

import activities.*;
import entities.*;
import reservations.*;
import users.*;

public class FileManager {
   private ListOfActivities lActiv; 
   private ListReservations lResv;
   private ListEntities lEntity; 
   private ListUsers lUser;
	// Global variables to catch the headers of each file 
	private String ActivityListHeader, TalkListHeader, VisitListHeader, WorkShopListHeader;
	private File fileCheck; // To chekc if the file exists

   // Different Getters
   public ListOfActivities getListActivities() { return lActiv; }
   public ListReservations getListReservations() { return lResv; }
   public ListEntities getListEntities() { return lEntity; }
   public ListUsers getListUsers() { return lUser; }
   public String getActivHeader() { return ActivityListHeader; }
   public String getTalkHeader() { return TalkListHeader; }
   public String getVisitHeader() { return VisitListHeader; }
   public String getWorkShopHeader() { return WorkShopListHeader; }

	/** Method to initialize the activity list from 
	 * text file
	 * 
	 * @param pathFile ubication of the file to load
	 * @return list of reservations
	 */
	public ListOfActivities initActivitiesList(String pathFile) {
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
	
				lActiv = new ListOfActivities(nActivities); // New list of activities
	
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
				lActiv = new ListOfActivities();
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
	public ListUsers initUserList(String pathFile) {
		Scanner f = null;
		try {
			f = new Scanner(new File(pathFile)); // File reader
			//String header = f.nextLine(); // Header of the user text file
			f.nextLine();
			int nUsers = Integer.parseInt(f.nextLine()); // Number of users in the file
			//System.out.println("There's " +nUsers+ " users.\n  User file format: " +header);
			lUser = new ListUsers(nUsers); // Setting a new list

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
	public ListEntities initEntityList(String pathFile) {
		Scanner f = null;
		try {
			f = new Scanner(new File(pathFile));
			//String header = f.nextLine();
			f.nextLine();
			int nEntities = Integer.parseInt(f.nextLine());
			//System.out.println("\n\nThere's " +nEntities+ " entities.\n  User file format: " +header);
			lEntity = new ListEntities(nEntities);

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

	/** Method to initialize the reservation list from 
	 * serialized file
	 * 
	 * @return list of reservations
	 */
	public ListReservations initReservationList(String pathFile) {
		try {
			File check = new File(pathFile);

			if (check.exists()) { // If the file in that path exists
				var iFile = new ObjectInputStream(new FileInputStream(pathFile));
				
				var length = iFile.readInt(); // Length of the list
				lResv = new ListReservations(length); // New reserv list
	
				// Iteration over the list to get all data deserializing it
				for (int i = 0; i < length; i++)
					lResv.addReservation((Reservation)iFile.readObject());
	
				iFile.close();
				System.out.println(" ------- Reservation list loaded -------\n\n");
				return lResv;
			} else { // If not we create an empty list
				lResv = new ListReservations();
				System.out.println(" ------- Reservation list loaded -------\n\n");
				return lResv;
			}
	  	} catch (IOException e) {
			e.printStackTrace();
			return null;
	  	} catch (Exception e) {
			e.printStackTrace();
			return null;
	  	}
	}
}