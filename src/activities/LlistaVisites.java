    package activities;
    
    /**
 * Represents a list of visits.
 */

public class LlistaVisites {
    private Visites[] llista;   // Array to store visit activities
    private int nElem; // Number of elements in the list
    
    /**
     * Constructor to initialize the visit list with a given size.
     *
     * @param mida The initial size of the visit list.
     */
    public LlistaVisites(int mida) {
            llista=  new Visites[mida]; // Initialize the array with the specified size
            nElem= 0; // Set the initial number of elements to 0
        }

    /**
     * Getter method to retrieve the visit list.
     *
     * @return The array of visit activities.
     */
    public Visites[] getLlista() {
        return llista;
    }

    /**
     * Setter method to set the visit list.
     *
     * @param llista The array of visit activities to set.
     */

    public void setLlista(Visites[] llista) {
        this.llista = llista;
    }
    /**
     * Getter method to retrieve the number of elements in the visit list.
     *
     * @return The number of elements in the list.
     */
    public int getnElem() {
        return nElem;
    }
    /**
     * Setter method to set the number of elements in the visit list.
     *
     * @param nElem The number of elements to set.
     */
    public void setnElem(int nElem) {
        this.nElem = nElem;
    }

    /**
     * Adds a new visit activity to the list, maintaining alphabetical order by the first letter of the entity name.
     *
     * @param act The visit activity to add.
     */
    public void agefirVisita(Visites act){
        if(nElem<llista.length){
                for (int i = 0; i < nElem; i++) {
                    if(act.getNomEntitat().charAt(0)<=(llista[i].getNomEntitat().charAt(0))){
                        for(int k=nElem; k>i; k--){
                            llista[k]=llista[k-1];
                        }
                        llista[i]=act;
                    }
            } 
        }
    }

    /**
     * Removes a visit activity from the list based on its code.
     *
     * @param codi The code of the visit activity to be removed.
     */
    public void eliminarUsuari(String codi) {
        int i = 0;
        while (i < nElem)
            if (llista[i].getCodiActivitat().equalsIgnoreCase(codi)) {
                for (int j = i; j < nElem - 1; j++) {
                    llista[j] = llista[j + 1];
                }
                nElem--;
            } else
                i++;
    }
}


        