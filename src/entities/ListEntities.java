package entities;

/**Class ListEntities.java
 * 
 * This class is made for storing a list of entities
 * 
 * @author Juan Carlos Medinilla Alonso (juancarlos.medinilla@estudiants.urv.cat)
 */
public class ListEntities {
    private Entity[] listEnt;       //Entities list
    private int nElem;              //Number of entities in the list

    /**
     * @param size
     */
    public ListEntities(int size) {
        listEnt = new Entity[size];
        nElem = 0;
    }

    /**
     * @return
     */
    public int getnElem() {
        return nElem;
    }

    public String toString() {
        String aux = "Entity List => Elements: " +nElem+ "\n";
  
        for (int i = 0; i < nElem; i++) 
           aux += "\n   [" +i+ "] " +listEnt[i]+ "\n";
  
        return aux;
     }
}
