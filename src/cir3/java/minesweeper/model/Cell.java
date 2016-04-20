
package cir3.java.minesweeper.model;

/**
 * Represents a cell.
 * 
 * 
 */
public class Cell {
    private State state;
    private int i;
    private int j;

    /**
     * Getter for the attrbiute state.
     * 
     * @return the attribute state
     */
    public State getState() {
        return state;
    }

    /**
     * Setter for the attrbiute state.
     * 
     * @param state the value for state
     */
    public void setState(State state) {
        this.state = state;
    }
    
    /**
     * Getter for the attrbiute i.
     * 
     * @return the attribute i
     */
    public int getI() {
        return i;
    }

    /**
     * Setter for the attrbiute i.
     * 
     * @param i the new value for i
     */
    public void setI(int i) {
        this.i = i;
    }

    /**
     * Getter for the attrbiute j.
     * 
     * @return the attribute j
     */
    public int getJ() {
        return j;
    }

    /**
     * Setter for the attrbiute j.
     * 
     * @param j the new value for j
     */
    public void setJ(int j) {
        this.j = j;
    }
    
    /**
     * Clone the cell.
     * 
     * @return a clone of the cell
     */
    @Override
    public Cell clone() {
        return new Cell(i, j);
    }

    /**
     * 2-arguments constructor.
     * 
     * @param i the row of the cell
     * @param j the coll of the cell
     */
    public Cell(int i, int j) {
        this.i = i;
        this.j = j;
        state = PlayerState.NONE;
    }

    /**
     * Default constructor.
     */
    public Cell() {
        this(-1, -1);
    }
}