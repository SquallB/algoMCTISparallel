
package cir3.java.minesweeper.view;

import cir3.java.minesweeper.model.Cell;
import cir3.java.minesweeper.model.GameModel;
import cir3.java.minesweeper.model.Grid;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 * Represents the graphical view of a grid.
 * 
 * @author sylvain
 */
public class GraphicalGridView  extends JPanel {
    List<List<GraphicalCellView>> graphicalGrid;

    /**
     * Returns the view of the specified cell.
     * 
     * @param i the row of the cell
     * @param j the column of the cell
     * @return the wanted cell
     */
    public GraphicalCellView getGraphicalCellView(int i, int j) {
        return (graphicalGrid.get(i)).get(j);
    }
    
    /**
     * Refreshes a cell of the grid.
     * 
     * @param cell the cell to refresh
     */
    public void refreshCell(Cell cell) {
        GraphicalCellView cellView = getGraphicalCellView(cell.getI(), cell.getJ());
        cellView.refresh(cell);
    }

    /**
     * 1-argument constructor.
     * 
     * @param model the model on which the view is.
     */
    public GraphicalGridView(GameModel model) {
        
        Grid grid = model.getGrid();
        this.setLayout(new GridLayout(grid.getNbRows(), grid.getNbCols()));
        
        GraphicalCellView cell;
        graphicalGrid = new ArrayList<>();
        ArrayList<GraphicalCellView> newRow;
        
        for(int i = 0; i < grid.getNbRows(); i++) {
           newRow = new ArrayList<>();
            
            for(int j = 0; j < grid.getNbCols(); j++) {
                cell = new GraphicalCellView(model, grid.getCell(i, j));
                newRow.add(cell);
                add(cell);
            }
            
            graphicalGrid.add(newRow);
        }
    }

    /**
     * Default constructor.
     */
    public GraphicalGridView() {
        this(null);
    }
}
