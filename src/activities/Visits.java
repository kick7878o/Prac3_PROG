package activities;

/** Class Visits.java
 * 
 * This class is made to store an activity visit
 * that'll be done in a given day.
 * 
 * @author David Lopez (david.lopezr@estudiants.urv.cat)
 * @author Joan David Frent Frent (joandavid.frentf@estudiants.urv.cat)
 */
public class Visits extends Activities{
   private boolean audioGuided;
   private boolean blindFriendly; // For people who needs special treatment

   /** Constructor for the visit for when
     * a new talk has been created (with activity code generation)
     * 
     * NOTE:
     *  -> 1st line of attributes: child class needs to use
     *  -> rest of lines: retrieved from parent class
     * 
     * @param aGuide audio guided
     * @param bFriend blind friendly
     * @param activityDay day of the activity
     * @param activityName name of the activity 
     * @param activityLocation location of the activity
     * @param postalCode postal code of the activity
     * @param activityCode code of the activity
     * @param entityCreator entity creator
    */
   public Visits(boolean aGuide, boolean bFriend, 
                 int activityDay, String activityName, String activityLocation, 
                 int postalCode,String activityCode, String entityCreator) {

      super(ActivityType.VISIT, activityName, activityLocation, 
            postalCode, activityDay, entityCreator);

      audioGuided = aGuide;
      blindFriendly = bFriend;
   }

   /** Constructor for the visit for when
    * a talk has already been created (without activity code generation)
    *
    * NOTE:
    *  -> 1st line of attributes: child class needs to use
    *  -> rest of lines: retrieved from parent class
    * 
    * @param aGuide audio guided
    * @param bFriend blind friendly
    * @param activityDay day of the activity
    * @param activityName name of the activity 
    * @param activityLocation location of the activity
    * @param postalCode postal code of the activity
    * @param activityCode code of the activity
    * @param entityCreator entity creator
    */
   public Visits(boolean aGuide, boolean bFriend, 
                 int activityDay, String act_Code, String activityName, String activityLocation, 
                 int postalCode,String activityCode, String entityCreator) {

      super(ActivityType.VISIT, activityCode, activityLocation, 
            postalCode, postalCode, entityCreator);

      audioGuided = aGuide;
      blindFriendly = bFriend;
   }

   // Getters & Setters
   public boolean isAudioGuided() { return audioGuided; }
   public void setAudioGuided(boolean aGuide) { this.audioGuided = aGuide; }
   public boolean isBlindFriendly() { return blindFriendly; }
   public void setBlindFriendly(boolean bFriend) { this.blindFriendly = bFriend; }

   @Override
   public String toString() {
      return super.toString()+
            "Audio guided: " +(audioGuided ? "Si" : "No")+ "\n" +
            "Blind friendly: " +(blindFriendly ? "Si" : "No")+ "\n\n";
   }

   /** Method that dupplicates the visit instance
    * @return duplicate
    */
   public Visits copy() {
      return new Visits(audioGuided, blindFriendly, 
                        activityDay, activityName, activityLocation,
                        postalCode, activityCode, entityCreator);
   }

   @Override
   public String toTextFormat() {
      return super.actType+ ";" // Check if when put the instance in the file. Shows VISIT
            +super.activityCode+ ";"
            +super.activityName+ ";"
            +super.activityLocation+ ";"
            +super.postalCode+ ";"
            +super.activityDay+ ";"
            +super.entityCreator+ ";"
            +audioGuided+ ";"
            +blindFriendly;
   }

   @Override
   public void fromTextFormat(String txt) {
      String[] aux = txt.split(";");

      super.activityCode = aux[1];
      super.activityName = aux[2];
      super.activityLocation = aux[3];
      super.postalCode = Integer.parseInt(aux[4]);
      super.activityDay = Integer.parseInt(aux[5]);
      super.entityCreator = aux[6];
      audioGuided = Boolean.parseBoolean(aux[7]);
      blindFriendly = Boolean.parseBoolean(aux[8]);
   }
}
