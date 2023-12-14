package activities;

/**Class ListWorkshops.java
 * 
 * This class is made for storing a list of workshops
 * 
 * @author Juan Carlos Medinilla Alonso (juancarlos.medinilla@estudiants.urv.cat)
 */
public class ListWorkshops {
    private Workshop[] listWork;    //Workshop list
    private int nElem;              //Number of workshops in the list

    /**
     * @param size
     */
    public ListWorkshops(int size) {
        listWork = new Workshop[size];
        nElem = 0;
    }

    /**
     * @return
     */
    public Workshop[] getListWork() {
        return listWork;
    }

    /**
     * @param listWork
     */
    public void setListWork(Workshop[] listWork) {
        this.listWork = listWork;
    }

    /**
     * @return
     */
    public int getnElem() {
        return nElem;
    }

    /**
     * @param nElem
     */
    public void setnElem(int nElem) {
        this.nElem = nElem;
    }

    

}
