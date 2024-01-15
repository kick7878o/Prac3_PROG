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

    /** Method to add an entity to the list
     * NOTE: no need to check if we get out of the list
     * because it is constant
     * 
     * @param entity new entity
     */
    public void addEntity2List(Entity entity) {
        listEnt[nElem] = entity;
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

    /** Method that displays the entities name
     * 
     * @return string with names
     */
    public String showEntityName() {
        String aux = "Avaliable Entities: ";

        for (int i=0; i < listEnt.length; i++)
            aux += "\n" +(i+1)+ ". " +listEnt[i].getName()+ "\n";

        return aux;
    }

    /** Method that gets an entity by its name
     * 
     * @return entity
     */
    public Entity entityPerName(String name){
        // we initzialize it with the first value of the string
        Entity aux=listEnt[0];
        for(int i=0; i<listEnt.length; i++){
            if(listEnt[i].getName()==name){
                aux= listEnt[i];
            }
        }
        return aux;
    }
}
