package users;

/**Class Users.java
 * 
 * This class is made for store one user
 * 
 * @author Aleix Chillida Subirats (aleix.chillida@estudiants.urv.cat)
 */

public class Users {

    private String name;
    private String email;
    private String postalCode;

    public Users(String name, String email, String postalCode){
        this.name = name;
        this.email = email;
        this.postalCode = postalCode;
    }

    /**Getter name
     * @return name
     */
    public String getName() {
        return name;
    }

    /** Setter name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /** Getter email
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /** Setter email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /** Getter postalCode
     * @return postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /** Setter postalCode
     * @param postalCode
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /** Method that duplicates an instance of Users
     * @return duplicate
     */
    public Users copyUser(){
        return new Users(name, email, postalCode);
    }

    @Override
    public String toString() {
        return "Users [name=" + name + ", email=" + email + ", postalCode=" + postalCode + "]";
    }    
}
