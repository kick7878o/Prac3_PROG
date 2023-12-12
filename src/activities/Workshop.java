package activities;

import java.time.LocalTime;

public class Workshop extends Activities{
    private LocalTime hour;
    private int duration;
    private int capacity;

    public Workshop(LocalTime hour, int duration, int capacity) {
        this.hour = hour;
        this.duration = duration;
        this.capacity = capacity;
    }

    public LocalTime getHour() {
        return hour;
    }

    public void setHour(LocalTime hour) {
        this.hour = hour;
    }
    
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

}
