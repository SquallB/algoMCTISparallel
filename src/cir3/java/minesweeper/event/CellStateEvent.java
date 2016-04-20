
package cir3.java.minesweeper.event;

import cir3.java.minesweeper.model.Cell;
import cir3.java.minesweeper.model.GameModel;
import cir3.java.minesweeper.model.State;

/**
 * Event fired when a cell has a new mark.
 * 
 * 
 */
public class CellStateEvent extends CellEvent {
    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }   
    
    /**
     * 2-arguments constructor.
     * 
     * @param model the model which fired the event.
     * @param cell the cell that has a new mark
     */
    public CellStateEvent(GameModel model, Cell cell, State state) {
        super(model, cell);
        this.state = state;
    }
}
