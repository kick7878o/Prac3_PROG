package activities;

/** Class Talks.java
 * 
 * This class is made for storing talks
 * 
 * @author Aleix Chillida Subirats (aleix.chillida@estudiants.urv.cat)
 * @author Joan David Frent Frent (joandavid.frentf@estudiants.urv.cat)
 */
public class Talk extends Activities {
    private final String hour = "at 17:00h (5:00 PM)"; // Time that will be taking place the talk
    private String speakerName; // Name of the speaker

    /** Constructor of the talk instance for when
     * a new talk has been created (with activity code generation)
     * 
     * NOTE:
     *  -> 1st line of attributes: child class needs to use
     *  -> rest of lines: retrieved from parent class
     * 
     * @param sName name of the speaker
     * @param activityDay day of the activity
     * @param activityName name of the activity 
     * @param activityLocation location of the activity
     * @param postalCode postal code of the activity
     * @param activityCode code of the activity
     * @param entityCreator entity creator
     */
    public Talk(String sName, 
                int activityDay, String activityName, String activityLocation,
                int postalCode, String activityCode, String entityCreator) {
        super(ActivityType.TALK, activityName, activityLocation, 
              postalCode, activityDay, entityCreator);

        this.speakerName = sName;
    }

    /** Constructor of the talk instancefor when
     * a talk has already been created (without activity code generation)
     *
     * NOTE:
     *  -> 1st line of attributes: child class needs to use
     *  -> rest of lines: retrieved from parent class
     *
     * @param sName name of the speaker
     * @param activityDay day of the activity
     * @param activityName name of the activity 
     * @param activityLocation location of the activity
     * @param postalCode postal code of the activity
     * @param activityCode code of the activity
     * @param entityCreator entity creator
     */
    public Talk(String sName, 
                int activityDay, String act_code, String activityName, String activityLocation,
                int postalCode, String activityCode, String entityCreator) {
        super(ActivityType.TALK, act_code, sName, 
                activityLocation, postalCode, postalCode, entityCreator);

        this.speakerName = sName;
    }

    // Getters & Setters
    public String getSpeakerName() { return speakerName; }
    public void setSpeakerName(String sName) { this.speakerName = sName; }

    @Override
    public String toString() {
       return super.toString()+
            "Speaker name: " +speakerName+ "\n" +
            "Hour: " +hour+ "\n\n";
    }

    /** Method that dupplicates the Talk instance
     * @return duplicate
    */
    public Talk copy() {
        return new Talk(speakerName, 
                        activityDay, activityName, activityLocation,
                        postalCode, activityCode, entityCreator);
    }

    @Override
    public String toTextFormat() {
        return  super.actType+ ";" // Check if when put the instance in the file. Shows TALK
            +super.activityCode+ ";"
            +super.activityName+ ";"
            +super.activityLocation+ ";"
            +super.postalCode+ ";"
            +super.activityDay+ ";"
            +super.entityCreator+ ";"
            +speakerName;
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
        speakerName = aux[7];
    }
}
