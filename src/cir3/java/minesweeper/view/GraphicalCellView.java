
package cir3.java.minesweeper.view;

import cir3.java.minesweeper.controller.TicTacToeController;
import cir3.java.minesweeper.model.Cell;
import cir3.java.minesweeper.model.GameModel;
import cir3.java.minesweeper.model.PlayerState;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Represents the graphical view a cell,
 * and handles all the events that are fired when acting on it.
 * 
 * @author sylvain
 */
public class GraphicalCellView extends JButton {
    private GameModel model;
    private Cell cell;
    
    
    
    /**
     * Set the image in the cell, depending if the cell is revealed, and of
     * what is in the cell.
     * 
     * @param revealed a boolean that indicated if the cell is revealed
     * @param cellType the type of the cell
     */
    public void setImage(boolean revealed, String cellType) {
        setIcon(null);
        setDisabledIcon(null);
        
        if(!cellType.equals("")) {
            ImageIcon image = new ImageIcon(cellType + GraphicalViewConstants.IMAGE_EXTENSION);
            
            if(revealed) {
                setDisabledIcon(image);
                setIcon(image);
            }
            else {
                setIcon(image);
            }
            
            repaint();        
        }    
    }
  
    /**
     * Refresh the cell using new information from the model.
     * 
     * @param cell the information of the cell from the model
     */
    public void refresh(Cell cell) {
        if(cell.getState() instanceof PlayerState) {
            PlayerState cellState = (PlayerState)cell.getState();
            String content = "";

           if(cellState == PlayerState.NONE) {
               setEnabled(true);
           }
           else {
               setEnabled(false);
               if(cellState == PlayerState.PLAYER1) {
                   content = GraphicalViewConstants.CELL_PLAYER1;
               }
               else if(cellState == PlayerState.PLAYER2) {
                   content = GraphicalViewConstants.CELL_PLAYER2;
               }
           }

           this.setText(content);
        }
    }
    
    /**
     * 2-arguments constructor.
     * 
     * @param model the model containing informations about the game
     * @param cell the cell which the view is on
     */
    public GraphicalCellView(GameModel model, Cell cell) {
        this.model = model;
        this.cell = cell;
        
        refresh(cell);
        this.addMouseListener(new TicTacToeController(model, cell));
    }

    /**
     * Default constructor.
     */
    public GraphicalCellView() {
        this(null, null);
    }    
}