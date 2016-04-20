
package cir3.java.chronometer.event;

import cir3.java.minesweeper.event.NewValueEvent;

/**
 * Event fired when an attribute representing minutes changed its value.
 * 
 * 
 */
public class NewMinutesEvents extends NewValueEvent {
    
    /**
     * 1-argument constructor.
     * 
     * @param value the new value of the minutes
     */
    public NewMinutesEvents(int value) {
        super(value);
    }

    /**
     * Default constructor.
    **/
    public NewMinutesEvents() {
        this(0);
    }    
}
