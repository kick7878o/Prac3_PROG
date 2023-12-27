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

    /** Constructor for the workshop instance
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
                    int activityDay, String activityName, String activityLocation, 
                    int postalCode, int activityCode, String entityCreator) {
        super(ActivityType.WORKSHOP, activityDay, activityName, activityLocation, 
              postalCode, activityCode, entityCreator);

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
        return new Workshop(sartingHour, duration, capacity, sumRates, nPeople, 
                            activityDay, activityName, activityLocation, 
                            postalCode, activityCode, entityCreator);
    }
    @Override
    public String toString() {
        return super.toString()+
               "Hour: " +sartingHour+ "h\n" +
               "Duration: " +duration+ "\n" +
               "Capacity: " +capacity+ "\n" +
               "Sum of rates: " +sumRates+ "\n" +
               "Number of people: " +nPeople+ "\n\n";
    }
}
