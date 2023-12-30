package activities;

import entities.Entity;

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
         aux += "\n   [" +(i+1)+ "] " +listActv[i]+ "\n";

      return aux;
   }

   public ListOfActivities getActivityByDay(Activities[] actv, int day){
      ListOfActivities aux = new ListOfActivities(nElem);;
      int j=0;
      for(int i=0;i<actv.length;i++){
         if(actv[i].activityDay == day){
           aux.addActivity(listActv[j]);
           j++;
         }
      }
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

      public void agefirVisita(Visits act){
         if (nElem<listActv.length) {
               for (int i = 0; i < nElem; i++) {
                     if (act.getActivityName().charAt(0) <= 
                        (listActv[i].getActivityName().charAt(0))) {
                        for(int k=nElem; k>i; k--)
                           listActv[k]=listActv[k-1];
                        
                        listActv[i]=act;
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
            if (listActv[i].getActivityCode().equalsIgnoreCase(codi)) {
               for (int j = i; j < nElem - 1; j++)
                     listActv[j] = listActv[j + 1];
               
               nElem--;
            } else
               i++;
   }

   private ListOfActivities audioGuideFiltered(Entity entit, boolean audio){
      int j=0;

      ListOfActivities aux = new ListOfActivities(nElem);
      if (audio==true) {
         for (int i=0; i < listActv.length; i++) {
            if(listActv[i].entityCreator == entit.getName() && 
               listActv[i].isAudioGuided() == audio) {
               aux.addActivity(listActv[j]);
               j++;
            }
         }
      }
      return aux;
   }

   private ListOfActivities blindFiltered(Entity entit, boolean blind){
      int j=0;
      ListOfActivities aux = new ListOfActivities(nElem);

      if (blind==true) {
         for (int i=0; i < listActv.length; i++) {
            if (listActv[i].entityCreator == entit.getName() && 
               listActv[i].isBlindFriendly() == blind) {
               aux.addActivity(listActv[j]);
               j++;
            }
         }
      }
      return aux;
   }

   public ListOfActivities getVisitsPerEntity(Entity entit, boolean audio, boolean blind){

      ListOfActivities aux = new ListOfActivities(nElem);
   
      aux.audioGuideFiltered(entit, audio);
      aux.blindFiltered(entit, blind);
   
      return aux;
   }

   /** Method that reads from file Activity.txt
    * 
    * @return List of activities
    */
   public ListOfActivities loadActivityDataFromFile() {
      return null;
   }

   /** Method that saves the activity list to a file
    * 
    * @param listAct
    */
   public void saveActivityDataFromList(ListOfActivities listAct) {
   }
}

