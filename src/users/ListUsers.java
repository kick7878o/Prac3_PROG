package users;

/** Class ListUsers.java
 * 
 * This class is made for storing a list of users
 * 
 * @author Aleix Chillida Subirats (aleix.chillida@estudiants.urv.cat)
 */
public class ListUsers {
    private Users[] listUser;
    private int nElem;

    /** Constructor to make the list of users
     * @param size of the array
     */
    public ListUsers(int size){
        listUser = new Users[size];
        nElem = 0;
    }

    // Getters & Setters
    public int getElem() { return nElem; }
    public Users[] getListUsers() { return listUser; }

     
    @Override
    public String toString(){
        String aux = "Users List => Elements: " +nElem+ "\n";

        for(int i = 0; i < nElem; i++) 
            aux+= "\n   [" +(i+1)+ "] " +listUser[i]+ "\n";
        
        return aux;
    }

    /** Method to add a user to the list
     * NOTE: no need to check if we surpass the list, it's always constant
     * @param user new user
     */
    public void addUser2List(Users user) {
        listUser[nElem] = user;
        nElem++;
    }


    /** Method that displays the entities name
     * 
     * @return string with names
     */
    public String showUserName() {
        String aux = "Avaliable Users: ";

        for (int i=0; i < listUser.length; i++)
            aux += "\n" +(i+1)+ ". " +listUser[i].getName()+ "\n";

        return aux;
    }
}
