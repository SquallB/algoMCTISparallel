
package cir3.java.minesweeper.event;

/**
 * Event fired when the maximum value of something is increased.
 * 
 * 
 */
public class NewMaximumEvent extends NewValueEvent {

    /**
     * 1-argument constructor.
     * 
     * @param value the new maximum.
     */
    public NewMaximumEvent(int value) {
        super(value);
    }

    /**
     * Default constructor.
     */
    public NewMaximumEvent() {
        this(0);
    }
}
