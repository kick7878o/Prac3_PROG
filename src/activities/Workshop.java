package activities;

import java.time.LocalTime;

/** Class Workshop.java
 * 
 * This class is made for storing workshops
 * 
 * @author Juan Carlos Medinilla Alonso (juancarlos.medinilla@estudiants.urv.cat)
 */
public class Workshop extends Activitats {
    private LocalTime hour;                 //Time of the workshop
    private int duration;                   //Workshop duration
    private int capacity;                   //Workshop capacity
    private int score;                      //Sum of scores
    private int nScores;                    //Sum of the people who have voted

    /**
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

    /**
     * @return
     */
    public LocalTime getHour() {
        return hour;
    }

    /**
     * @param hour
     */
    public void setHour(LocalTime hour) {
        this.hour = hour;
    }
    
    /**
     * @return
     */
    public int getDuration() {
        return duration;
    }

    /**
     * @param duration
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * @return
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @param capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * @return
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @return
     */
    public int getnScores() {
        return nScores;
    }

    /**
     * @param nScores
     */
    public void setnScores(int nScores) {
        this.nScores = nScores;
    }

}
