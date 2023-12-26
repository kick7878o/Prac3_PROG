package activities;

import java.time.LocalTime;

/** Class Workshop.java
 * 
 * This class is made for storing workshops
 * 
 * @author Juan Carlos Medinilla Alonso (juancarlos.medinilla@estudiants.urv.cat)
 */
public class Workshop extends Activitats {
    private LocalTime hour; // Time of the workshop
    private int duration, capacity;   // Workshop duration & capacity
    private int score, nScores;      // Total sum of scores & number of people who scored

    /** Constructor to build a workshop
     * @param hour
     * @param duration
     * @param capacity
     * @param score
     * @param nScores
     */
    public Workshop(String nameEntity, String nameActivity, String place, String postCode, 
                    String day,        LocalTime hour,      int duration, int capacity, 
                    int score,         int nScores) {
        super(nameEntity, nameActivity, place, postCode, day);
        this.hour = hour;
        this.duration = duration;
        this.capacity = capacity;
        this.score = score;
        this.nScores = nScores;
    }

    // Getters & Setters
    public LocalTime getHour() { return hour; }
    public void setHour(LocalTime hour) { this.hour = hour; }
    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }
    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
    public int getnScores() { return nScores; }
    public void setnScores(int nScores) { this.nScores = nScores; }

    /** Method that duplicates the instance workshop
     * @return a duplicate
     */
    public Workshop copyWorkShop() {
        return new Workshop(nomActivitat, lloc, dia, codiPostal, codiActivitat, hour, duration, capacity, score, nScores);
    }

    @Override
    public String toString() {
        return super.toString() + "Workshop [hour=" + hour + ", duration=" + duration + ", capacity=" + capacity + ", score=" + score
                + ", nScores=" + nScores + "]";
    }
}
