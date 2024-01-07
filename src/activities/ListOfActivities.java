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

   @Override
   public String toString() {
      String aux = "List of Activities [" +(nElem+1)+ "] =>";

      for (int i=0; i < nElem; i++)
         aux += "\n   [" +(i+1)+ "] " +listActv[i]+ "\n";

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

   /** Method that get the number of talks of the list
    * 
    * @return array size
    */
   public int getNumberTalks() {
      int nTalks = 0;
      for (int i=0; i < nElem; i++) {
         if (listActv[i].actType == ActivityType.TALK)
            nTalks++;
      }
      return nTalks;
   }

   /** Method that get the number of visits of the list
    * 
    * @return array size
    */
   public int getNumberVisits() {
      int nVisits = 0;
      for (int i=0; i < nElem; i++) {
         if (listActv[i].actType == ActivityType.VISIT)
            nVisits++;
      }
      return nVisits;
   }

   /** Method that get the number of workshops of the list
    * 
    * @return array size
    */
   public int getNumberWorkShops() {
      int nWorkShops = 0;
      for (int i=0; i < nElem; i++) {
         if (listActv[i].actType == ActivityType.WORKSHOP)
            nWorkShops++;
      }
      return nWorkShops;
   }
   /** Method that adds an activity to the list of activities
    * 
    * NOTE: resizes if the list is full
    * @param actv an instance of activity
    */
   public void addActivity(Activities actv) {
      // Resize the array if necessary
      if (nElem >= listActv.length) { 
         Activities[] aux = new Activities[nElem*2]; // Double capacity
         for (int i=0; i < aux.length; i++)
            aux[i] = listActv[i];
            
         listActv = aux;
      }

      // add a new reservation to the list
      listActv[nElem] = actv.copy();
      nElem++;
   }

   /** Method that filters the list of activities by workshop
    * 
    * @return a new list with the workshops
    */
   public ListOfActivities filterByWorkShop() {
      ListOfActivities aux = new ListOfActivities(getNumberWorkShops());

      for (Activities actv : listActv)
         if (actv.actType == ActivityType.WORKSHOP)
            aux.addActivity(actv);

      return aux;
   }

   /** Method that filters the list of activities by talks
    * 
    * @return a new list with the workshops
    */
   public ListOfActivities filterByTalk() {
      ListOfActivities aux = new ListOfActivities(getNumberTalks());

      for (Activities activities : listActv) {
         if (activities.actType == ActivityType.TALK) 
            aux.addActivity(activities);
      }

      return aux;
   }

   /** Method that filters the list of activities by visits
    * 
    * @return a new list with the workshops
    */
   public ListOfActivities filterByVisits() {
      ListOfActivities aux = new ListOfActivities(getNumberVisits());

      for (Activities activities : listActv) {
         if (activities.actType == ActivityType.VISIT)
            aux.addActivity(activities);
      }
      return aux;
   }

   /** Method that gets activities stored in an specific day
    * 
    * NOTE: it checks all the array to get the activities of this day
    * @param day a day to check the activities of
    */
   public ListOfActivities getActivityByDay(int day){
      // create an auxiliar to save the specified
      ListOfActivities aux = new ListOfActivities(nElem);;
      int j=0;
      for(int i=0;i<nElem;i++){
         if(listActv[i].activityDay == day){
           aux.addActivity(listActv[j]);
           j++;
         }
      }
      return aux;
   }

   /** Method that shows the names of the workshops
    * 
    * @return string with names
    */
   public String showNamesSpotsLeftAndCode() {
      String aux = "";

      for (Activities activities : listActv) {
         if (activities.actType == ActivityType.WORKSHOP) {
            Workshop wshop = (Workshop)activities;
            if (wshop.getSpotsLeft() != 0)
               aux += "Code: " +wshop.getActivityCode()+ " // Name: " 
               +wshop.getActivityName()+ " (" +wshop.getSpotsLeft()+ " spots left)\n  ";
         }
      }
      return aux;
   }

   /** Method that shows the names of the workshops
    * 
    * @return string with names
    */
   public String showNamesAndCode() {
      String aux = "";

      for (int i=0; i < nElem; i++) {
         if (listActv[i].getActType() == ActivityType.WORKSHOP) {
            Workshop wshop = (Workshop) listActv[i];
            if (wshop.getSpotsLeft() != 0) {
               aux += "Code: " +wshop.getActivityCode()+ " // Name: " 
               +wshop.getActivityName()+ "\n";
            }
         }
      }
      return aux;
   }

   /** Method to check if the activity name exists or not
    * 
    * @param name name of the activity
    * @return
    */
   public boolean checkActivCode(String code) {
      for (int i=0; i < nElem; i++) {
         if (listActv[i].getActivityCode().equalsIgnoreCase(code))
            return true;
      }
      return false;
   }

   /** Method to get an instance of the workshop by name
    * 
    * @param name
    * @return instance
    */
   public Workshop getWorkShopByCode(String code) {
      for (Activities activities : listActv) {
         if (activities.actType == ActivityType.WORKSHOP) {
            Workshop wshop = (Workshop)activities;
            if (wshop.getActivityCode().equalsIgnoreCase(code))
               return wshop;
         }      
      }
      return null;
   }

   /** Method that adds a Visit to the list of activities
    * 
    * NOTE: it checks if the name is earlier in the periodic table to put it in order.
    */
   public void addVisit(Visits act){
      if(nElem<listActv.length){
              for (int i = 0; i < nElem; i++) {
                  if(act.getActivityName().charAt(0)<=(listActv[i].getActivityName().charAt(0))){
                      for(int k=nElem; k>i; k--){
                          listActv[k]=listActv[k-1];
                      }
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
  public void deleteActivity(String codi) {
      int i = 0;
      while (i < nElem)
          if (listActv[i].getActivityCode().equalsIgnoreCase(codi)) {
              for (int j = i; j < nElem - 1; j++) {
                  listActv[j] = listActv[j + 1];
              }
              nElem--;
          } else
              i++;
  }

  /** Method that creates a new auxiliar table to save the audio guided activities
    * 
    * @return a new list with the audio guied activities
    */
  private ListOfActivities audioGuideFiltered(Entity entit, boolean audio){
   int j=0;

   ListOfActivities aux = new ListOfActivities(nElem);
   if(audio==true){
      for(int i=0;i<nElem;i++){
         // Checks if the entitiy creator is the same as the name of the entity and if its audioguided
         if(listActv[i].entityCreator == entit.getName() && listActv[i].isAudioGuided() == audio){
            aux.addActivity(listActv[j]);
            j++;
         }
      }
   }
   return aux;
}

  /** Method that creates a new auxiliar table to save the blind guided activities
    * 
    * @return a new list with the blind guied activities
    */
private ListOfActivities blindFiltered(Entity entit, boolean blind){
   int j=0;

   ListOfActivities aux = new ListOfActivities(nElem);
   if(blind==true){
      for(int i=0;i<nElem;i++){
         // Checks if the entitiy creator is the same as the name of the entity and if its blind guided
         if(listActv[i].entityCreator == entit.getName() && listActv[i].isBlindFriendly() == blind){
            aux.addActivity(listActv[j]);
            j++;
         }
      }
   }
   return aux;
}
 /** Method that creates a new auxiliar table to save the audio & blind guided activities
    * 
    * @return a new list with the audio & blind guied activities
    */
public ListOfActivities getVisitsPerEntity(Entity entit, boolean audio, boolean blind){

   ListOfActivities aux = new ListOfActivities(nElem);
   
   aux.audioGuideFiltered(entit, audio);
   aux.blindFiltered(entit, blind);
   
   return aux;
   }

   public Activities getActivity(int i) {
      try{
         if(i >= 0 && i < nElem){
            return listActv[i];
      }

      else{
            throw new ArrayIndexOutOfBoundsException("Index out of bounds");
          } 
      } catch (ArrayIndexOutOfBoundsException e){
         System.out.println("Error" +e.getMessage());
         return null;
      }
   }

   /** Method to register punctuation into the workshop
    * 
    * @param wkCode workshop code (activity code)
    * @param rate user's given rate
    */
   public void registerPunctuationInWorkShop(String wkCode, byte rate) {
      // Iterate over the list of activities
      for (Activities activ : listActv) {
         if (activ.getActivityCode().equalsIgnoreCase(wkCode)) {
            Workshop wshop = (Workshop)activ;
            wshop.setSumRates(wshop.getSumRates()+rate);
            wshop.setnPeople(wshop.getnPeople()+1);
         }
      }
   }

   /** Method to register a new spot used
    * 
    * @param wkCode code of the workshop
    */
   public void registerNewSpotReserved(String wkCode) {
      for (Activities actv : listActv) {
         if (actv.actType == ActivityType.WORKSHOP) {
            Workshop wk = (Workshop) actv;
            if (wk.getActivityCode().equalsIgnoreCase(wkCode))
               wk.setSpotsLeft(wk.getSpotsLeft()-1);
         }
      }
   }
}

