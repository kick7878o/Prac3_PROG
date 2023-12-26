package entities;

/** Class ListEntities.java
 * 
 * This class is made for storing a list of entities
 * 
 * @author Juan Carlos Medinilla Alonso (juancarlos.medinilla@estudiants.urv.cat)
 */
public class ListEntities {
    private Entity[] listEnt;   // Entities list
    private int nElem;          // Number of entities in the list

    /** Constructor for the list of entities
     * @param size size of the list
     */
    public ListEntities(int size) {
        listEnt = new Entity[size];
        nElem = 0;
    }

    // Getters & setters
    public int getnElem() { return nElem; }
    public Entity[] getEntityList() { return listEnt; }
    public void setEntityList(Entity[] listEnt) {
        this.listEnt = listEnt;
        nElem = listEnt.length;
    }

    /** Method that adds an entity into the list
     * @param entity new instance to add
     */
    public void addEntity (Entity entity) {
        listEnt[nElem] = entity.copyEntity();
        nElem++;
    }

   /** Method that shows the list of entities
    * @return data list
    */
    public String toString() {
        String aux = "Entity List => Elements: " +nElem+ "\n";
  
        for (int i = 0; i < nElem; i++) 
           aux += "\n   [" +(i+1)+ "] -> " +listEnt[i]+ "\n";
  
        return aux;
     }
}
