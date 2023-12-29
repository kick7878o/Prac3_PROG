package activities;

/** Class Workshop.java
 * 
 * This class is made for storing workshops
 * 
 * @author Juan Carlos Medinilla Alonso (juancarlos.medinilla@estudiants.urv.cat)
 * @author Joan David Frent Frent (joandavid.frentf@estudiants.urv.cat)
 */
public class Workshop extends Activities {
    private String sartingHour; // Starting hour of the workshop (format hh:mm)
    private int duration; // Duration of the workshop (in minutes)
    private int capacity; // Max capacity
    private int sumRates=0; // Total sum of punctuation
    private int nPeople=0; // number of pepole who rated the workshop

    /** Constructor for the workshop for when
     * a workshop has already been created (without activity code generation)
     * 
     * NOTE:
     *  -> 1st line of attributes: child class needs to use
     *  -> rest of lines: retrieved from parent class
     * 
     * @param sartingHour hour that it'll start the workshop
     * @param duration duation of the workshop
     * @param capacity max capacity of the workshop
     * @param sumRates total sum of the pepople who rated the workshop
     * @param nPeople number of people who rated
     * @param activityDay day of the activity
     * @param activityName name of the activity 
     * @param activityLocation location of the activity
     * @param postalCode postal code of the activity
     * @param activityCode code of the activity
     * @param entityCreator entity creator
     */
    public Workshop(String sartingHour, int duration, int capacity, int sumRates, int nPeople,
                    int activityDay, String act_code, String activityName, String activityLocation, 
                    int postalCode, String activityCode, String entityCreator) {
        super(ActivityType.WORKSHOP, act_code, activityCode, activityLocation, 
              postalCode, postalCode, entityCreator);

        this.sartingHour = sartingHour;
        this.duration = duration;
        this.capacity = capacity;
        this.sumRates = sumRates;
        this.nPeople = nPeople;
    }
    
    // Getters & Setters
    public String getSartingHour() { return sartingHour; }
    public void setSartingHour(String sHour) { this.sartingHour = sHour; }
    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }
    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    public int getSumRates() { return sumRates; }
    public void setSumRates(int sumRates) { this.sumRates = sumRates; }
    public int getnPeople() { return nPeople; }
    public void setnPeople(int nPeople) { this.nPeople = nPeople; }

    /** Method that duplicates the workshop
     * instance.
     * @return duplicate
     */
    public Workshop copy() {
        return new Workshop(sartingHour, duration, capacity, sumRates, 
                            nPeople, activityDay, sartingHour, activityName, 
                            activityLocation, postalCode, activityCode, entityCreator);
    }
    @Override
    public String toString() {
        return super.toString()+
               "Hour: " +sartingHour+ "h\n" +
               "Duration: " +duration+ " minutes\n" +
               "Capacity: " +capacity+ " people\n" +
               "Sum of rates: " +sumRates+ "\n" +
               "Number of people: " +nPeople+ " have voted\n\n";
    }

    @Override
    public String toTextFormat() {
        return super.actType+ ";" // Check if when put the instance in the file. Shows WORKSHOP
            +super.activityCode+ ";"
            +super.activityName+ ";"
            +super.activityLocation+ ";"
            +super.postalCode+ ";"
            +super.activityDay+ ";"
            +super.entityCreator+ ";"
            +sartingHour+ ";"
            +duration+ ";"
            +capacity+ ";"
            +sumRates+ ";"
            +nPeople;
    }

    @Override
    public void fromTextFormat(String txt) {
        String[] aux = txt.split(";");
        //super.actType = ActivityType.valueOf(aux[0]);
        super.activityCode = aux[1];
        super.activityName = aux[2];
        super.activityLocation = aux[3];
        super.postalCode = Integer.parseInt(aux[4]);
        super.activityDay = Integer.parseInt(aux[5]);
        super.entityCreator = aux[6];
        sartingHour = aux[7];
        duration = Integer.parseInt(aux[8]);
        capacity = Integer.parseInt(aux[9]);
        sumRates = Integer.parseInt(aux[10]);
        nPeople = Integer.parseInt(aux[11]);
    }
}
