package cir3.java.chronometer.model;

import java.io.Serializable;

/**
 * Represents a time using minutes and seconds.
 * 
 * 
 */
public class Time implements Serializable {
    private int minutes;
    private int seconds;

    /**
     * Getter for the attribute mintues.
     * 
     * @return the attribute minutes
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * Setter for the attribute mintues.
     * 
     * @param minutes the new value for minutes
     */
    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    /**
     * Getter for the attribute seconds.
     * 
     * @return the attribute seconds
     */
    public int getSeconds() {
        return seconds;
    }

    /**
     * Setter for the attribute seconds.
     * 
     * @param seconds the new value for seconds 
     */
    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    /**
     * 2-arguments constructor.
     * 
     * @param minutes value for minutes
     * @param seconds value for seconds
     */
    public Time(int minutes, int seconds) {
        this.minutes = minutes;
        this.seconds = seconds;
    }

    /**
     * Default constructor.
     */
    public Time() {
        this(0, 0);
    }    
}