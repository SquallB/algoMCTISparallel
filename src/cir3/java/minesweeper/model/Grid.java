
package cir3.java.minesweeper.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a grid.
 * 
 * 
 */
public class Grid {
    private List<List<Cell>> grid;
    private int nbRows;
    private int nbCols;
    
    /**
     * Getter for the attribute nbRows.
     * 
     * @return the attribute nbRows
     */
    public int getNbRows() {
        return nbRows;
    }
    
    /**
     * Setter for the attribute nbRows.
     * 
     * @param nbRows the value for nbRows
     */
    public void setNbRows(int nbRows) {
        if(nbRows < 0) {
            throw new IllegalArgumentException("Illegal nbRows value");
        }
        
        this.nbRows = nbRows;
    }

    /**
     * Getter for the attribute nbCols.
     * 
     * @return the attribute nbCols
     */
    public int getNbCols() {
        return nbCols;
    }

    /**
     * Setter for the attribute nbRCols.
     * 
     * @param nbCols the value for nbCols
     */
    public void setNbCols(int nbCols) {
        if(nbCols < 0) {
            throw new IllegalArgumentException("Illegal nbCols value");
        }
        
        this.nbCols = nbCols;
    }
     
    /**
     * Create a new cell.
     * 
     * @param i the row
     * @param j the col
     * 
     * @return a new cell
     */
    public Cell createCell(int i, int j) {
        return new Cell(i, j);
    }
    
    /**
     * Checks if the row and the col given are valid for the cell to be in the
     * grid.
     * 
     * @param i the row
     * @param j the col
     * @return true if is is valid, false otherise
     */
    public boolean isCellValid(int i, int j) {        
        return i > -1 && j > -1 && i < nbRows && j < nbCols;
    }
    
    /**
     * Return a cell given a row and a col.
     * 
     * @param i the row
     * @param j the col
     * @return the cell
     */
    public Cell getCell(int i, int j) {
        if(isCellValid(i, j)) {
            return (grid.get(i)).get(j);
        }
        
        return null;
    }
    
    public void changeCellState(int i, int j, State state) {
        this.getCell(i, j).setState(state);
    }
    
    /**
     * 2-arguments constructor.
     * 
     * @param nbRows the number of rows of the grid
     * @param nbCols the number of cols of the grid
     */
     public Grid(int nbRows, int nbCols) {
        setNbRows(nbRows);
        setNbCols(nbCols);
        
        grid = new ArrayList<>();
        
        for(int i = 0; i < nbRows; i++) {
            ArrayList<Cell> newRow = new ArrayList<>();
            
            for(int j = 0; j < nbCols; j++) {
                newRow.add(j, createCell(i, j));
            }
        
            grid.add(i, newRow);
        }
    }

     /**
      * Default constructor.
      */
    public Grid() {
        this(0, 0);
    }
}