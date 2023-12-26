package activities;

/** Class ListWorkshops.java
 * 
 * This class is made for storing a list of workshops
 * 
 * @author Juan Carlos Medinilla Alonso (juancarlos.medinilla@estudiants.urv.cat)
 */
public class ListWorkshops {
    private Workshop[] listWork;    // Workshop list
    private int nElem;              // Number of workshops in the list

    /** Constructor for the list of workshops
     * @param size
     */
    public ListWorkshops(int size) {
        listWork = new Workshop[size];
        nElem = 0;
    }
    
    // Getters & Setters
    public Workshop[] getListWork() { return listWork; }
    public void setListWork(Workshop[] listWork) { this.listWork = listWork; }
    public int getnElem() { return nElem; }

    /** Method that adds a workshop to the list
     * @param workshop
     */
    public void addWorkshop(Workshop workshop) {
        if(nElem < listWork.length) {
            listWork[nElem] = workshop.copyWorkShop();
            nElem++;
        }
    }

    @Override
    public String toString() {
        String str = "List of WorkShops, nElem: " +nElem;
        for (int i = 0; i < nElem; i++) 
            str += "\n [" +(i+1)+ "] " +listWork[i].toString()+ "\n";
        
        return str;
    }
}
