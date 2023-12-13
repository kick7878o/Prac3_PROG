package users;

public class ListUsers {
    private Users[] listUser;
    private int nElem;


    /** Constructor to make the list of users
     * @param size
     */
    public ListUsers(int size){
        listUser = new Users[size];
        nElem = 0;
    }

    /** Getter that returns the number of elements on the list
     * 
     * @return number of elements on list
     */
    public int getElem(){
        return nElem;
    }

/** Method to add a user to the list
 * @param user instance of Users 
 */
    public void addUser(Users user){
        if(nElem < listUser.length) {
            listUser[nElem] = user.copyUser();
            nElem++;
        }
    }
    /** Method to delete a user from the list
    * @param name  
    */
    public void deleteUser(String name){
        int i = 0;
        while(i < nElem){
            if(listUser[i].getName().equalsIgnoreCase(name)){
                for(int j = i; j < nElem; j++){
                    listUser[j] = listUser[j + 1];                   
                }
                nElem--;
            } else {
                i++;
            }
        }
    }
     
    @Override
    public String toString(){
        String aux = "Users List:\n";

        for(int i = 0; i < nElem; i++){
            aux+= "\n [" +i+"] " +listUser+ "\n";
        }
        return aux;
    }
    
    
}
