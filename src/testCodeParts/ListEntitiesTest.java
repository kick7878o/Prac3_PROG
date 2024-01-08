package testCodeParts;

import entities.Entity;
import entities.ListEntities;

public class ListEntitiesTest {
   public static void main(String[] args) {
     
     //Creating an entity instance and checking if the data preset is correct
     System.out.println("\n- Creating an entity instance and checking if the data preset is correct\n");
     Entity e1 = new Entity("E1", "123456789", "1@hotmail.com");
     System.out.println(e1);

     //Creating a List of Entities without elements and checking it
     System.out.println("\n- Creating a List of Entities without elements and checking it\n");
     int size = 5;
     ListEntities listE = new ListEntities(size);
     System.out.println("\n" +listE);  

     //Creating more Entity instances and adding them to the list
     System.out.println("\n- Creating more Entity instances and adding them to the list\n");
     Entity e2 = new Entity("E2", "987654321", "2@hotmail.com");
     Entity e3 = new Entity("E3", "135724680", "3@hotmail.com");
     Entity e4 = new Entity("Entity4", "159825362", "4@gmail.com");
     Entity e5 = new Entity("Entity5", "603928392", "5@gmail.com");

     listE.addEntity2List(e1);
     listE.addEntity2List(e2);
     listE.addEntity2List(e3);
     listE.addEntity2List(e4);
     listE.addEntity2List(e5);

     //Checking if the list is correct
     System.out.println("\n- Checking if the list is correct\n");
     System.out.println(listE);

     //Cheking setters and getters
     System.out.println("\n- Cheking setters and getters\n");
     //Checking different getters
     System.out.println("\nEntity 1 -> " +e1.getName() + ", " +e1.getNumTel() + ", " +e1.getEmail());
     System.out.println("Entity 1 -> " +listE.getEntityList()[0].getName() + ", " +listE.getEntityList()[0].getNumTel() + ", " +listE.getEntityList()[0].getEmail());
     System.out.println("Entity 2 -> " +e2.getName() + ", " +e2.getNumTel() + ", " +e2.getEmail());
     System.out.println("Entity 2 -> " +listE.getEntityList()[1].getName() + ", " +listE.getEntityList()[1].getNumTel() + ", " +listE.getEntityList()[1].getEmail());

     //Checking setters
     System.out.println("\n" +listE);
     System.out.println(e1 + "\n" + e2 + "\n" + e3);
     
     e1.setName("Entity1");
     e1.setEmail("1@gmail.com");
     e2.setName("Entity2");
     e2.setEmail("2@gmail.com");
     e3.setName("Entity3");
     e3.setEmail("3@gmail.com");
     System.out.println("-> Changing names and emails...");
     //Checking if the setters worked
     System.out.println("\n- Checking if the setters worked\n");
     System.out.println(listE);
     System.out.println(e1 + "\n" + e2 + "\n" + e3);

   }

}
