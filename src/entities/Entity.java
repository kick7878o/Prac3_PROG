package entities;

/** Class Entity.java
 * 
 * This class is made for storing entities
 * 
 * @author Juan Carlos Medinilla Alonso (juancarlos.medinilla@estudiants.urv.cat)
 */
public class Entity {
    private String name;    // Name of the entity
    private String numTel;  // Contact number
    private String email;   // Email adress

    /** Constructor for the entities
     * @param name
     * @param numTel
     * @param email
     */
    public Entity(String name, String numTel, String email) {
        this.name = name;
        this.numTel = numTel;
        this.email = email;
    }

    // Getters y setters from each attribute
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getNumTel() { return numTel; }
    public void setNumTel(String numTel) { this.numTel = numTel; }
    public String getEmail() { return email; }    
    public void setEmail(String email) { this.email = email; }

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
     * @param numTel postal code of the user
     * @return true or false
     */
    public boolean isThisTelephoneNumber(String numTel) {
        return this.numTel.equalsIgnoreCase(numTel);
    }

    /** Method that copies an entity
     * @return duplicate of the instance of the entity
     */
    public Entity copyEntity() { 
        return new Entity(name, numTel, email); 
    }

    /** Method that returns the info of the entity
     * @return Text with data of the entity
     */
    public String toString() {
        return "Entity [name=" + name + ", numTel=" + numTel + ", email=" + email + "]";
    }    
}
