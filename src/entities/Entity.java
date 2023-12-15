package entities;

/**Class Entity.java
 * 
 * This class is made for storing entities
 * 
 * @author Juan Carlos Medinilla Alonso (juancarlos.medinilla@estudiants.urv.cat)
 */
public class Entity {
    private String name;            //Name of the entity
    private String numTel;          //Contact number
    private String email;           //Email adress

    /**
     * @param name
     * @param numTel
     * @param email
     */
    public Entity(String name, String numTel, String email) {
        this.name = name;
        this.numTel = numTel;
        this.email = email;
    }

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return
     */
    public String getNumTel() {
        return numTel;
    }
    
    /**
     * @param numTel
     */
    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    /**
     * @return
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public Entity copy(){
        return new Entity(name, numTel, email);
    }

    public String toString() {
        return "Entity [name=" + name + ", numTel=" + numTel + ", email=" + email + "]";
    }

    
}
