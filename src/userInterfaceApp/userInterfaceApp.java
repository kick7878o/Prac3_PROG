package userInterfaceApp;

import java.io.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import activities.*;
import entities.*;
import exceptions.*;
import reservations.*;
import users.*;
import consoleApp.*;

public class userInterfaceApp extends JFrame{

    public static void main(String[] args) throws IOException, ActivityListEmpty {
        new userInterfaceApp();
    }
   
   private static final long serialVersionUID = 1L;
	private static FileManager fManage = SharedApp.fManager;

	// Data initialization phase
	ListEntities entityList = fManage.getListEntities(); // Initialize entity list
	ListUsers userList = fManage.getListUsers(); // Initialize usersList
	ListOfActivities activityList = fManage.getListActivities(); // Initialize Activity Structure
	ListReservations reservationList = fManage.getListReservations(); // Init reservation list

	private JButton[] lastButtons;

    public userInterfaceApp() throws IOException{

		// Set the Interface Window
        super("Practica 3");
        this.setLocation(100, 40);
		this.setSize(1200, 800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setLayout(new BorderLayout());

		// Create the JPanel where we will put the buttons and labels in
		JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 50));

		// Create the label and set the characteristics
		JLabel label = new JLabel("The next 10 days(Number of activities per day)");
		label.setFont(new Font("Arial", Font.BOLD, 20));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setBorder(new EmptyBorder(0, 600, 0, 600));
		buttonsPanel.add(label);

		// Create an array of JButton of 10 buttons which corresponds to day 10-20 with the corresponding characteristics
		lastButtons = new JButton[10];
		int day;
		for(int i = 0; i < 10; i++) {
			day = i+10;
			lastButtons[i] = new JButton(""+day+"/11/2023" + "\n (" + numDayActivities(day) + ")");
			lastButtons[i].setMargin(new Insets(20, 10, 20, 10));
			lastButtons[i].setBorder(new EmptyBorder(5, 40, 5, 40));
			lastButtons[i].addActionListener(new ButtonClickListener(day));
			buttonsPanel.add(lastButtons[i]);
		}
		
		// Create a new label to anounce the three buttons we are creating
		JLabel label2 = new JLabel("Type of activity");
		label2.setFont(new Font("Arial", Font.BOLD, 20));
		label2.setBorder(new EmptyBorder(60, 600, 0, 600));
		buttonsPanel.add(label2);

		// Create the 3 buttons to show by screen the filtered lists depending on TALK/VISITS/WORKSHOP
		JButton type1 = new JButton("Workshop");
		JButton type2 = new JButton("Visits");
		JButton type3 = new JButton("Talks");

		// Set the size and the action referred to each Activity type
		type1.setPreferredSize(new Dimension(130, 35));
		type1.addActionListener(new ButtonClickListener2());
		type2.setPreferredSize(new Dimension(130, 35));
		type2.addActionListener(new ButtonClickListener3());
		type3.setPreferredSize(new Dimension(130, 35));
		type3.addActionListener(new ButtonClickListener4());

		// Add the three new buttons to the button panel
		buttonsPanel.add(type1);
		buttonsPanel.add(type2);
		buttonsPanel.add(type3);

		// Add the title and the characteristics of it
		JLabel titol = new JLabel("URV Science Week");
		titol.setBorder(new EmptyBorder(40, 0, 30, 0));
		titol.setFont(new Font("Arial", Font.BOLD, 40));
		titol.setHorizontalAlignment(JLabel.CENTER);
		
		// Finally, add the buttons panel and the title to the Interface
		this.add(buttonsPanel, BorderLayout.CENTER);
		this.add(titol, BorderLayout.PAGE_START);

		// Set visible true
		this.setVisible(true);

		
    }

	/** Method that counts how many activities are in a specific day
    * 
    * NOTE: it checks all the array to get the activities of this day
    * @param d a day to check the activities of
    */
	private int numDayActivities(int d) {
		int acts = 0;
		for(int i = 0; i < activityList.getnElem(); i++) {
			if(activityList.getListActv()[i].getActivityDay() == d) {
				acts++;
			}
		}
		return acts;
	}

	/** Method that filters the list of activities by an specific day
    * 
    * @return a new list with the activities in an specific day
    */
	private ListOfActivities dayActivities(int d) {
		ListOfActivities acts = new ListOfActivities();
		for(int i = 0; i < activityList.getnElem(); i++) {
			if(activityList.getListActv()[i].getActivityDay() == d) {
				acts.addActivity(activityList.getListActv()[i]);
			}
		}
		return acts;
	}

	/** Method that shows the activities filtered by Workshop
    */
	private void filterByWorkshop(){
		System.out.println("The activites filtered by Workshop: \n"+activityList.filterByWorkShop());
	}
	/** Method that shows the activities filtered by Talk
    */
	private void filterByTalk(){
		System.out.println("The activities filtered by Talk: \n"+activityList.filterByTalk());
	}
	/** Method that shows the activities filtered by Visits
    */
	private void filterByVisits(){
		System.out.println("The activities filtered by Visits: \n"+activityList.filterByVisits());
	}


	/** Method that is created to implement the action listener of a button
    * 
    * NOTE: it shows by the interface the activities of an specific day
    */
	private class ButtonClickListener implements ActionListener {
        private int day;

        public ButtonClickListener(int day) {
            this.day = day;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Show the information of the actions list of the day
            ListOfActivities activitiesInfo = dayActivities(day);
            JOptionPane.showMessageDialog(null, "Activities of the day " + day + ":\n" + activitiesInfo);
        }
    }
	
	/** Method that is created to implement the action listener of a button
    * 
    * NOTE: it shows by the console the activities filtered by workshop
    */
	private class ButtonClickListener2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// Mostrar información de la lista de acciones del día
            filterByWorkshop();
		}
		
	}

	/** Method that is created to implement the action listener of a button
    * 
    * NOTE: it shows by the console the activities filtered by Visits
    */
	private class ButtonClickListener3 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// Mostrar información de la lista de acciones del día
            filterByVisits();
		}
		
	}

	/** Method that is created to implement the action listener of a button
    * 
    * NOTE: it shows by the console the activities filtered by Talk
    */
	private class ButtonClickListener4 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// Mostrar información de la lista de acciones del día
            filterByTalk();
		}
		
	}
}
