
package cir3.java.minesweeper.event;

import cir3.java.mvc.Event;
import cir3.java.minesweeper.model.Cell;
import cir3.java.minesweeper.model.GameModel;

/**
 * Event fired when something occured on a cell.
 * 
 *
 */
public class CellEvent extends Event {
     private Cell cell;

     /**
      * Getter for the attribute cell;
      * 
      * @return the attribute cell
      */
    public Cell getCell() {
        return cell;
    }

    /**
     * Setter for the attribute cell;
     * 
     * @param cell new value for cell
     */
    public void setCell(Cell cell) {
        this.cell = cell;
    }

    /**
     * 2-arguments constructor.
     * 
     * @param model the model the controller will act on
     * @param cell the cell on which something occured
     */
    public CellEvent(GameModel model, Cell cell) {
        super(model);
        this.cell = cell;
    }

    /**
     * Default constructor.
     */
    public CellEvent() {
        this(null, null);
    }
}
