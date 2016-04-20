
package cir3.java.chronometer.event;

import cir3.java.minesweeper.event.NewValueEvent;

/**
 * Event fired when an attribute representing seconds changed its value.
 * 
 * 
 */
public class NewSecondsEvents extends NewValueEvent {

    /**
     * 1-argument constructor.
     * 
     * @param value the new value of the seconds
     */
    public NewSecondsEvents(int value) {
        super(value);
    }

    /**
     * Defautl constructor.
     */
    public NewSecondsEvents() {
        this(0);
    }   
}
