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
        super("Practica 3");
        this.setLocation(100, 40);
		this.setSize(1200, 800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setLayout(new BorderLayout());

		JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 50));

		JLabel label = new JLabel("The next 10 days(Number of activities per day)");
		label.setFont(new Font("Arial", Font.BOLD, 20));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setBorder(new EmptyBorder(0, 600, 0, 600));
		buttonsPanel.add(label);

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
		
		JLabel label2 = new JLabel("Type of activity");
		label2.setFont(new Font("Arial", Font.BOLD, 20));
		label2.setBorder(new EmptyBorder(60, 600, 0, 600));
		buttonsPanel.add(label2);

		JButton type1 = new JButton("Workshop");
		JButton type2 = new JButton("Visits");
		JButton type3 = new JButton("Talks");
		type1.setPreferredSize(new Dimension(130, 35));
		type1.addActionListener(new ButtonClickListener2());
		type2.setPreferredSize(new Dimension(130, 35));
		type2.addActionListener(new ButtonClickListener3());
		type3.setPreferredSize(new Dimension(130, 35));
		type3.addActionListener(new ButtonClickListener4());

		buttonsPanel.add(type1);
		buttonsPanel.add(type2);
		buttonsPanel.add(type3);

		JLabel titol = new JLabel("URV Science Week");
		titol.setBorder(new EmptyBorder(40, 0, 30, 0));
		titol.setFont(new Font("Arial", Font.BOLD, 40));
		titol.setHorizontalAlignment(JLabel.CENTER);
		
		this.add(buttonsPanel, BorderLayout.CENTER);
		this.add(titol, BorderLayout.PAGE_START);

		this.setVisible(true);

		
    }

	private int numDayActivities(int d) {
		int acts = 0;
		for(int i = 0; i < activityList.getnElem(); i++) {
			if(activityList.getListActv()[i].getActivityDay() == d) {
				acts++;
			}
		}
		return acts;
	}

	private ListOfActivities dayActivities(int d) {
		ListOfActivities acts = new ListOfActivities();
		for(int i = 0; i < activityList.getnElem(); i++) {
			if(activityList.getListActv()[i].getActivityDay() == d) {
				acts.addActivity(activityList.getListActv()[i]);
			}
		}
		return acts;
	}

	private ListOfActivities filterByWorkshop(){
		activityList.filterByWorkShop();
		return activityList;
	}

	private ListOfActivities filterByTalk(){
		activityList.filterByTalk();
		return activityList;
	}

	private ListOfActivities filterByVisits(){
		activityList.filterByVisits();
		return activityList;
	}

	private class ButtonClickListener implements ActionListener {
        private int day;

        public ButtonClickListener(int day) {
            this.day = day;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Mostrar información de la lista de acciones del día
            ListOfActivities activitiesInfo = dayActivities(day);
            JOptionPane.showMessageDialog(null, "Activities of the day " + day + ":\n" + activitiesInfo);
        }
    }

	private class ButtonClickListener2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// Mostrar información de la lista de acciones del día
            filterByWorkshop();
            JOptionPane.showMessageDialog(null, "Activities filtered by Workshop " + ":\n" + activityList);
		}
		
	}

	private class ButtonClickListener3 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// Mostrar información de la lista de acciones del día
            filterByVisits();
            JOptionPane.showMessageDialog(null, "Activities filtered by Visits " + ":\n" + activityList);
		}
		
	}

	private class ButtonClickListener4 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// Mostrar información de la lista de acciones del día
            filterByTalk();
            JOptionPane.showMessageDialog(null, "Activities filtered by Talk " + ":\n" + activityList);
		}
		
	}
}
