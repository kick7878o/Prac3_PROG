// @author David López
package activities;
    
public class LlistaActivitats {
    private Activitats[] llista;
    private int nElem;
        
    /** Constructor to initialize the activity list with a given size.
     * @param mida The initial size of the activity list.
     */
    public LlistaActivitats(int mida) {
        llista=  new Activitats[mida];
        nElem= 0;
    }

    // Getters & Setters
    public Activitats[] getLlista() { return llista; }
    public void setLlista(Activitats[] llista) { this.llista = llista; }
    public int getnElem() { return nElem; }

    /** Adds a new activity to the list.
     * @param act The activity to add.
     */
    public void agefirActivitat(Activitats act) {
        if(nElem < llista.length) {
            llista[nElem] = act.copia();
            nElem++;
        }
    }

    /** Removes an activity from the list based on its code.
     * @param codi The code of the activity to be removed.
     */
    public void eliminarActivitat(String codi) {
        int i = 0;
        while (i < nElem)
            if (llista[i].getCodiActivitat().equalsIgnoreCase(codi)) {
                for (int j = i; j < nElem - 1; j++) 
                    llista[j] = llista[j + 1];
                
                nElem--;
            } else
                i++;
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < nElem; i++) 
            str += "\n [" +(i+1)+ "] " +llista[i].toString() + "\n";
        
        return str;
    }
}