package users;

/** Class Users.java
 * 
 * This class is made for storing one user
 * 
 * @author Aleix Chillida Subirats (aleix.chillida@estudiants.urv.cat)
 */
public class Users {
    private String name; // Name of the user
    private String email; // Email of the user
    private String postalCode; // Postal Code of the user

    /** Constructor of the user
     * 
     * @param name
     * @param email
     * @param postalCode
     */
    public Users(String name, String email, String postalCode){
        this.name = name;
        this.email = email;
        this.postalCode = postalCode;
    }

    // Getters & Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

    /** Method that checks if the input name is the same
     * as the one in the instance
     * 
     * @param userName name of the user
     * @return true or false
     */
    public boolean isThisName(String userName) {
        return this.name.equalsIgnoreCase(userName);
    }
    /** Method that checks if the input email is the same
     * as the one in the instance
     * 
     * @param userEmail email of the user
     * @return true or false
     */
    public boolean isThisEmail(String userEmail) {
        return this.email.equalsIgnoreCase(userEmail);
    }
    /** Method that checks if the input postal code is the same
     * as the one in the instance
     * 
     * @param userPostalCode postal code of the user
     * @return true or false
     */
    public boolean isThisPostalCode(String userPostalCode) {
        return this.postalCode.equalsIgnoreCase(userPostalCode);
    }

    /** Duplicate of the user
     * @return new instance of the user
     */
    public Users copyUser(){ 
        return new Users(name, email, postalCode); 
    }

    /** String of the user data
     * @return user data
     */
    public String toString() {
        return "Users [name=" + name + ", email=" + email + ", postalCode=" + postalCode + "]";
    }    
}
