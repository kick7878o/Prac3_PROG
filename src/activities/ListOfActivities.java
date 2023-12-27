package activities;

/** Class Activities.java
 * 
 * This class is made to store a list of activities
 * that'll be done in a given day.
 * 
 * NOTE: can't repeat activities (can take place once)
 * 
 * @author David Lopez (david.lopezr@estudiants.urv.cat)
 * @author Joan David Frent Frent (joandavid.frentf@estudiants.urv.cat)
 */
public class ListOfActivities {
   private Activities[] listActv; 
   private int nElem; // Number of elements of the list (occupied)
   private static final int INIT_SIZE = 15; // Array initial size

   /** Constructor of the Activities List
    * Number of elements = 0
    * Initializes the array with a prefixated size
    */
   public ListOfActivities() {
      listActv = new Activities[INIT_SIZE];
      nElem = 0;
   }

   /** Constructor of the Activities List
    * Number of elements = 0
    * Initializes the array with a given size
    */
   public ListOfActivities(int size) {
      listActv = new Activities[size];
      nElem = 0;
   }

   // Getters & Setters
   public Activities[] getListActv() { return listActv; }
   public int getnElem() { return nElem; }


   /** Method that adds an activity to the list of activities
    * 
    * NOTE: resizes if the list is full
    * @param actv an insatnce of activity
    */
   public void addActivity(Activities actv) {
      // Resize the array if necessary
      if (nElem >= listActv.length) { 
         Activities[] aux = new Activities[nElem*2]; // Double capacity
         for (int i=0; i < aux.length; i++) {
            aux[i] = listActv[i];
            listActv = aux;
         }
      }

      // add a new reservation to the list
      listActv[nElem] = actv.copy();
      nElem++;
   }

   @Override
   public String toString() {
      String aux = "List of Activities [" +(nElem+1)+ "] =>";

      for (int i=0; i < nElem; i++)
         aux += "\n   [" +i+ "] " +listActv[i]+ "\n";

      return aux;
   }

   /** Method that duplicates the list of activities
    * 
    * @return duplicate of the list
    */
   public ListOfActivities copy() {
      ListOfActivities aux = new ListOfActivities(nElem);

      for (int i=0; i < nElem; i++) 
         aux.addActivity(listActv[i]);

      return aux;
   }
}
