package entities;

public class ListEntities {
    private Entity[] listEnt;
    private int nElem;

    public ListEntities(int size) {
        listEnt = new Entity[size];
        nElem = 0;
    }

    public int getnElem() {
        return nElem;
    }

    public void setnElem(int nElem) {
        this.nElem = nElem;
    }

    public String toString() {
        String aux = "Entity List => Elements: " +nElem+ "\n";
  
        for (int i = 0; i < nElem; i++) 
           aux += "\n   [" +i+ "] " +listEnt[i]+ "\n";
  
        return aux;
     }
}
