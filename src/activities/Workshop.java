package activities;

/** Class Workshop.java
 * 
 * This class is made for storing workshops
 * 
 * @author Juan Carlos Medinilla Alonso (juancarlos.medinilla@estudiants.urv.cat)
 * @author Joan David Frent Frent (joandavid.frentf@estudiants.urv.cat)
 */
public class Workshop extends Activities {
    private String startingHour; // Starting hour of the workshop (format hh:mm)
    private int duration; // Duration of the workshop (in minutes)
    private int capacity, spotsLeft=capacity; // Max capacity & spots left to the workshop
    private int sumRates=0; // Total sum of punctuation
    private int nPeople=0; // number of pepole who rated the workshop

    /** Constructor for the workshop for when
     * a workshop has already been created (without activity code generation)
     * 
     * NOTE:
     *  -> 1st line of attributes: child class needs to use
     *  -> rest of lines: retrieved from parent class
     * 
     * @param startingHour hour that it'll start the workshop
     * @param duration duation of the workshop
     * @param capacity max capacity of the workshop
     * @param sumRates total sum of the pepople who rated the workshop
     * @param nPeople number of people who rated
     * 
     * @param activityCode code of the activity
     * @param activityName name of the activity 
     * @param activityLocation location of the activity
     * @param postalCode postal code of the activity
     * @param activityDay day of the activity
     * @param entityCreator entity creator
     */
    public Workshop(String startingHour, int duration, int capacity, 
                    int sLeft, int sumRates, int nPeople,
                    String act_code, String activityName, String activityLocation, int postalCode, 
                    int activityDay, String entityCreator) {
        super(ActivityType.WORKSHOP, act_code, activityName, activityLocation, 
            postalCode, activityDay, entityCreator);

        this.startingHour = startingHour;
        this.duration = duration;
        this.capacity = capacity;
        this.spotsLeft = sLeft;
        this.sumRates = sumRates;
        this.nPeople = nPeople;
    }
    
    // Getters & Setters
    public String getStartingHour() { return startingHour; }
    public void setStartingHour(String sHour) { this.startingHour = sHour; }
    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }
    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    public int getSpotsLeft() { return spotsLeft; }
    public void setSpotsLeft(int spotsLeft) { this.spotsLeft = spotsLeft; }
    public int getSumRates() { return sumRates; }
    public void setSumRates(int sumRates) { this.sumRates = sumRates; }
    public int getnPeople() { return nPeople; }
    public void setnPeople(int nPeople) { this.nPeople = nPeople; }

    /** Method that duplicates the workshop
     * instance.
     * @return duplicate
     */
    public Workshop copy() {
        return new Workshop(startingHour, duration, capacity, spotsLeft, sumRates, nPeople, 
                            activityCode, activityName, activityLocation, 
                            postalCode, activityDay, entityCreator);
    }
    @Override
    public String toString() {
        return super.toString()+
               "\tHour: " +startingHour+ "h\n" +
               "\tDuration: " +duration+ " minutes\n" +
               "\tCapacity: " +capacity+ " people\n" +
               "\tSpots Left: " +spotsLeft+ "\n" +
               "\tSum of rates: " +sumRates+ "\n" +
               "\tNumber of people: " +nPeople+ " have voted\n\n";
    }

    @Override
    public String toTextFormat() {
        return super.activityCode+ ";"
            +super.activityName+ ";"
            +super.activityLocation+ ";"
            +super.postalCode+ ";"
            +super.activityDay+ ";"
            +super.entityCreator+ ";"
            +startingHour+ ";"
            +duration+ ";"
            +capacity+ ";"
            +spotsLeft+ ";"
            +sumRates+ ";"
            +nPeople;
    }

    @Override
    public void fromTextFormat(String txt) {
        String[] aux = txt.split(";");
        super.activityCode = aux[0];
        super.activityName = aux[1];
        super.activityLocation = aux[2];
        super.postalCode = Integer.parseInt(aux[3]);
        super.activityDay = Byte.parseByte(aux[4]);
        super.entityCreator = aux[5];
        startingHour = aux[6];
        duration = Integer.parseInt(aux[7]);
        capacity = Integer.parseInt(aux[8]);
        spotsLeft = Integer.parseInt(aux[9]);
        sumRates = Integer.parseInt(aux[10]);
        nPeople = Integer.parseInt(aux[11]);
    }
}
