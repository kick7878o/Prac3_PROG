package activities;

/** Class Activities.java
 * 
 * This class is made to store an activity
 * that'll be done in a given day.
 * 
 * NOTE: can't repeat activities (can take place once)
 * 
 * @author David Lopez (david.lopezr@estudiants.urv.cat)
 * @author Joan David Frent Frent (joandavid.frentf@estudiants.urv.cat)
 */
public abstract class Activities {
    protected ActivityType actType; // Activity type: talk - visit - workshop
    protected String activityCode; // Random number (3 letters entity + number >100)
    protected String activityName; // Activity name
    protected String activityLocation; // Location of the activity
    protected int postalCode; // Postal code of the activity
    protected int activityDay; // Day that it will be taking place (10-19)
    protected String entityCreator; // Name of the entity that created the Activity

    /** Contructor of the activities used
     * for when a new activity is created (new code generation)
     * 
     * @param actType type of the activity
     * @param act_code code of the activity
     * @param act_name name of the activity
     * @param act_location location of the activity
     * @param act_postalCode postal code of the activity
     * @param act_day day that it'll take place
     * @param entityCreator entitiy that created the activity
    */
    public Activities(ActivityType actType, String act_name, String act_location,
                      int act_postalCode, int act_day, String entityCreator) {
        this.actType = actType;
        this.activityCode = generateActivityCode();
        this.activityName = act_name;
        this.activityLocation = act_location;
        this.postalCode = act_postalCode;
        this.activityDay = act_day;
        this.entityCreator = entityCreator;
    }

    /** Contructor of the activities used
     * for when an activity was already created (without code generation)
     * 
     * @param actType type of the activity
     * @param act_code code of the activity
     * @param act_name name of the activity
     * @param act_location location of the activity
     * @param act_postalCode postal code of the activity
     * @param act_day day that it'll take place
     * @param entityCreator entitiy that created the activity
    */
    public Activities(ActivityType actType, String act_code, String act_name, String act_location,
                      int act_postalCode, int act_day, String entityCreator) {
        this.actType = actType;
        this.activityCode = act_code;
        this.activityName = act_name;
        this.activityLocation = act_location;
        this.postalCode = act_postalCode;
        this.activityDay = act_day;
        this.entityCreator = entityCreator;
    }

    // Getters & Setters for the attributes
    public ActivityType getActType() { return actType; }
    public String getActivityCode() { return activityCode; }
    public void setActivityCode(String activityCode) { this.activityCode = activityCode; }
    public String getActivityName() { return activityName; }
    public void setActivityName(String activityName) { this.activityName = activityName; }
    public String getActivityLocation() { return activityLocation; }
    public void setActivityLocation(String act_Loc) { this.activityLocation = act_Loc; }
    public int getPostalCode() { return postalCode; }
    public void setPostalCode(int postalCode) { this.postalCode = postalCode; }
    public int getActivityDay() { return activityDay; }
    public void setActivityDay(int activityDay) { this.activityDay = activityDay; }
    public String getEntityCreator() { return entityCreator; }
    public void setEntityCreator(String entityCreator) { this.entityCreator = entityCreator; }

    public String generateActivityCode() {
        // New substring with their first 3 letters: URVASB -> aux = URV
        String aux = entityCreator.substring(0,2).toUpperCase();
        // Generate random number between 100 & 900
        int num = 100 + (int) (Math.random() * 900);

        return activityCode = aux + num;
    }
    
    @Override
    public String toString() {
        return "Activity code: " + activityCode + "\n" +
               "Activity name: " + activityName + "\n" +
               "Activity location: " + activityLocation + "\n" +
               "Postal code: " + postalCode + "\n" +
               "Activity day: " + activityDay + "\n" +
               "Entity creator: " + entityCreator + "\n";
    }

    // Abstract method to copy an instance
    public abstract Activities copy();

    /** Method that converts into a String format
     * @return string with data
     */
    public abstract String toTextFormat();
    
    /** Method that converts from String format
     * 
     * @param txt string with data
     */
    public abstract void fromTextFormat(String txt);


    /** Method that calls a Visits function to use in Activities
     * @return boolean with data
     */
    public boolean isAudioGuided() { 
        Activities a = new Visits(isAudioGuided(), isAudioGuided(), activityDay, activityName, activityLocation, activityCode, postalCode, activityCode, entityCreator);
        return a.isAudioGuided(); }

    /** Method that calls a Visits function to use in Activities
     * @return boolean with data
     */
    public boolean isBlindFriendly() { 
    Activities a = new Visits(isAudioGuided(), isAudioGuided(), activityDay, activityName, activityLocation, activityCode, postalCode, activityCode, entityCreator);
    return a.isBlindFriendly(); }
}