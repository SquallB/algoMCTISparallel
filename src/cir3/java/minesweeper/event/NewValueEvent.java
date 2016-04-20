
package cir3.java.minesweeper.event;

import cir3.java.mvc.Event;

/**
 * Event fired when the value of something is changed.
 * 
 *
 */
public class NewValueEvent extends Event {
    private int value;

    /**
     * Getter the attribute value.
     * 
     * @return the attribute value
     */
    public int getValue() {
        return value;
    }

    /**
     * Getter the attribute value.
     * 
     * @param value the new value for value
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * 1-argument constructor.
     * 
     * @param value the new value
     */
    public NewValueEvent(int value) {
        this.value = value;
    }

    /**
     * Default constructor.
     */
    public NewValueEvent() {
        this(0);
    }
}
