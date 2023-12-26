package activities;

/** Class Visits.java
 * 
 * This class is made to store an activity visit
 * that'll be done in a given day.
 * 
 * @author David Lopez (david.lopezr@estudiants.urv.cat)
 */
public class Visits extends Activities{
   private boolean audioGuided;
   private boolean blindFriendly; // For people who needs special treatment

   /** Constructor for the visit that extends the activities
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
                 int postalCode,int activityCode, String entityCreator) {

      super(ActivityType.VISIT, activityDay, activityName, activityLocation, 
            postalCode, activityCode, entityCreator);

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
   public Visits duplicateV() {
      return new Visits(audioGuided, blindFriendly, 
                        activityDay, activityName, activityLocation,
                        postalCode, activityCode, entityCreator);
   }
}
