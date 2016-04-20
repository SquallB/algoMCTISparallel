
package cir3.java.chronometer.model;

import cir3.java.chronometer.event.NewSecondsEvents;
import cir3.java.chronometer.event.NewMinutesEvents;
import cir3.java.mvc.AbstractModel;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Class that represents a time that can be increased every seconds.
 * 
 * 
 */
public class Chronometer extends AbstractModel {
    Time time;
    Timer timer;

    /**
     * Getter for the attribute time
     * 
     * @return the curent time
     */
    public Time getTime() {
        return time;
    }

    /**
     * Setter for the attribute time
     * 
     * @param time a new time to replace the old one 
     */
    public void setTime(Time time) {
        this.time = time;
    }

    /**
     * Getter for the attribute timer
     * 
     * @return the timer used
     */
    public Timer getTimer() {
        return timer;
    }

    /**
     * Setter for the attribute timer
     * 
     * @param timer a new timer to replace the old one
     */
    public void setTimer(Timer timer) {
        this.timer = timer;
    }
    
    /**
     * Increases the minutes of the currentTime (attribute time).
     * Then notifies the views that the minutes changed.
     */
    public void increaseMinutes() {
        int minutes = time.getMinutes() + 1;
        
        time.setMinutes(minutes);
        refreshViews(new NewMinutesEvents(minutes));
    }
    
    /**
     * Increases the seconds of the currentTime (attribute time).
     * If the value of seconds is superior than 60, sets the seconds to 0 and
     * increases the minutes.
     * Then notifies the views that the seconds changed.
     */
    public void increaseSeconds() {
        int seconds = time.getSeconds();
        
        if(seconds + 1 > 59) {
            seconds = 0;
            increaseMinutes();
        }
        else {
            seconds++;
        }
        
        time.setSeconds(seconds);
        refreshViews(new NewSecondsEvents(seconds));
    }
            
    /**
     * Schedules a new TimerTask for the attribute timer.
     * The task is to increase the seconds every 1000 milliseconds.
     */
    public void start() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                increaseSeconds();
            }
        }, 0, 1000);
    }
    
    /**
     * Stops the TimerTask of the attribute timer.
     */
    public void stop() {
        timer.cancel();
    }
        
    /**
     * Default constructor.
     */
    public Chronometer() {
        time = new Time();
        timer = new Timer();
    }    
}