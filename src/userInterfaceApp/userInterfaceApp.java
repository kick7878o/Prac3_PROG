package userInterfaceApp;

import java.io.*;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

import activities.*;
import entities.*;
import exceptions.*;
import reservations.*;
import users.*;

public class userInterfaceApp extends JFrame{
    
    private static final long serialVersionUID = 1L;
    private static String ActivityListHeader, TalkListHeader, VisitListHeader, WorkShopListHeader;
    private static File fileCheck; // To chekc if the file exists

    ListEntities entityList = initEntityList("src\\dataFiles\\Entity.txt"); // Initialize entity list
	ListUsers userList = initUserList("src\\dataFiles\\Users.txt"); // Initialize usersList
	ListOfActivities activityList = initActivitiesList("src\\dataFiles\\Activities.txt"); // Initialize Activity Structure
	ListReservations reservationList = initReservationList("src\\dataFiles\\Reservation.ser"); // Init reservation list

	private JButton[] lastButtons;

    public userInterfaceApp() throws IOException{
        super("Practica 3");
        this.setLocation(100, 200);
		//this.setSize(600, 600);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setLayout(new BorderLayout());

		JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 50));

		JLabel label = new JLabel("Last 10 days");
		label.setFont(new Font("Arial", Font.BOLD, 20));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setBorder(new EmptyBorder(0, 600, 0, 600));
		buttonsPanel.add(label);

		lastButtons = new JButton[10];
		for(int i = 0; i < 10; i++) {
			lastButtons[i] = new JButton(""+(i+1));
			//lastButtons[i].setBackground(Color.CYAN);
			lastButtons[i].setPreferredSize(new Dimension(200, 50));
			buttonsPanel.add(lastButtons[i]);
		}
		
		JPanel typePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 200, 200));
		JButton type1 = new JButton("Workshop");
		JButton type2 = new JButton("Visits");
		JButton type3 = new JButton("Talks");
		type1.setPreferredSize(new Dimension(100, 50));
		type2.setPreferredSize(new Dimension(100, 50));
		type3.setPreferredSize(new Dimension(100, 50));
		typePanel.add(type1);
		typePanel.add(type2);
		typePanel.add(type3);

		JLabel titol = new JLabel("URV Science Week");
		titol.setBorder(new EmptyBorder(30, 0, 0, 0));
		titol.setFont(new Font("Arial", Font.BOLD, 40));
		titol.setHorizontalAlignment(JLabel.CENTER);
		
		this.add(buttonsPanel, BorderLayout.CENTER);
		this.add(typePanel, BorderLayout.SOUTH);
		this.add(titol, BorderLayout.PAGE_START);

		this.setVisible(true);
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
		// boolean exit = false;
		// do {
		// 	System.out.println("\n\n----- Storage phase of data structures -----\n");
		// 	System.out.println(" Do you want to store everything you've done?");
		// 	System.out.println("   1. Yes");
		// 	System.out.println("   2. No (Will loose al modification data)");
		// 	System.out.print("\tOption: ");
		// 	try {
		// 		byte opt = Byte.parseByte(keyboard.next());
		// 		switch (opt) {
		// 			case 1: storeActivities(lActv); storeReservations(lResv); exit=true;
		// 				break;
		// 			case 2: System.out.println("\n\n\t ······ All modifications lost ······\n\n");
		// 				exit=true;
		// 				break;
		// 			default: wrongOption(); 
		// 				break;
		// 		}			
		// 	} catch (NumberFormatException e) {
		// 		System.out.println("\n\n  ____ ERRROR: You have to write a number ____\n");
		// 	}
		// } while (!exit);

        storeActivities(lActv); storeReservations(lResv);

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
				System.out.println(" ------- Activity list stored -------\n");
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
				var oFile = new ObjectOutputStream(new FileOutputStream("src\\dataFiles\\Reservation.ser"));
				oFile.writeInt(lResv.getnElem());
	
				for (int i=0; i < lResv.getnElem(); i++)
					oFile.writeObject(lResv.getListRes()[i]);

				System.out.println("\n\n ------- Reservation list stored -------\n");
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

    public static void main(String[] args) throws IOException, ActivityListEmpty {
        new userInterfaceApp();
    }
}