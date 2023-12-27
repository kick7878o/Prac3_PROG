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

    /** Method to add a user to the list
     * @param user instance of Users 
     */
    public void addUser(Users user) {
        listUser[nElem] = user.copyUser();
        nElem++;
    }
     
    @Override
    public String toString(){
        String aux = "Users List => Elements: " +nElem+ "\n";

        for(int i = 0; i < nElem; i++) 
            aux+= "\n   [" +(i+1)+ "] " +listUser+ "\n";
        
        return aux;
    }  
}
