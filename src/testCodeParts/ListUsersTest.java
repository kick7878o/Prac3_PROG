package testCodeParts;

import users .*;

/** Class UsersAndListUsersTest.java
 *
 * This class is made for testing the users and 
 * ListUsers.java classes
 *
 * @author Aleix Chillida Subirats (aleix.chillida@estudiants.urv.cat)
 */

public class ListUsersTest {
    public static void main(String[] args) {

        //Check constructor
        Users u1 = new Users("Sergi", "sergi@gmail.com", 43530);
        System.out.println(u1); //Correct

        Users u2 = new Users("Marti", "marti12@gmail.com", 43500);
        Users u3 = new Users("Marc", "marccc@gmail.com", 43520);
        Users u4 = new Users("Claudia", "clau@gmail.com", 43540);
        Users u5 = new Users("Alba", "albabo@gmail.com", 43550);

        //Check list constructor and method addUsers2List
        ListUsers list = new ListUsers(5);
        list.addUser2List(u1);
        list.addUser2List(u2);
        list.addUser2List(u3);
        list.addUser2List(u4);
        list.addUser2List(u5);

        System.out.println(list); //Correct

        //Check getters
        System.out.println("Getter name u1: " +u1.getName());
        System.out.println("Getter email u1: " +u1.getEmail());
        System.out.println("Getter postalCode u1: "+u1.getPostalCode());
        System.out.println("Getter name u2: " +u2.getName());
        System.out.println("Getter email u2: "+u2.getEmail());
        System.out.println("Getter postalCode u2: "+u2.getPostalCode());
        System.out.println("Getter name u3: " +u3.getName());
        System.out.println("Getter email u3: "+u3.getEmail());
        System.out.println("Getter postalCode u3: "+u3.getPostalCode());
        System.out.println("Getter name u4: " +u4.getName());
        System.out.println("Getter email u4: "+u4.getEmail());
        System.out.println("Getter postalCode u4: "+u4.getPostalCode());
        System.out.println("Getter name u5: " +u5.getName());
        System.out.println("Getter email u5: "+u5.getEmail());
        System.out.println("Getter postalCode u5: "+u5.getPostalCode()); //Correct

        //Check setters
        u1.setEmail("sergi111@gmail.com");
        u2.setName("Martina");
        u3.setPostalCode(43150);
        u4.setName("Ferran");
        u5.setPostalCode(43555);
        u5.setName("Paula");

        System.out.println(list);  //Correct

        System.out.println(list.showUserName());
        System.out.println(list.getUserDataByName("Sergi"));
        System.out.println(list.isThisUserName("Martina"));


                

    }
   
}
