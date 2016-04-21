package cir3.java.minesweeper.model;

import cir3.java.minesweeper.event.CellStateEvent;
import cir3.java.mvc.AbstractModel;
import java.util.List;

public abstract class GameModel extends AbstractModel {
    private Grid grid;
    private boolean isPlayer1Turn;
    
    public Grid getGrid() {
        return grid;
    }

    public boolean isIsPlayer1Turn() {
        return isPlayer1Turn;
    }

    public void setIsPlayer1Turn(boolean isPlayer1Turn) {
        this.isPlayer1Turn = isPlayer1Turn;
    }
    
    public abstract List<Cell> getWinningCombinaison();
    
    public boolean isGameOver() {
        return this.getWinningCombinaison() != null;
    }
    
    public void changeCellState(int i, int j, State state) {        
        grid.changeCellState(i, j, state);
        refreshViews(new CellStateEvent(this, getGrid().getCell(i, j), state));
    }
    
    public void changeCellState(Cell cell, State state) {        
        cell.setState(state);
        refreshViews(new CellStateEvent(this, cell, state));
    }
    
    public abstract List<Cell> calculatePossibilities();
    
    public GameModel simulateMove(int i, int j) {
        return simulateMove(grid.getCell(i, j));
    }
    
    public abstract GameModel simulateMove(Cell cell);

    public GameModel(Grid grid) {
         this.grid = grid;
         this.isPlayer1Turn = true;
    }
    
    public GameModel(int nbRows, int nbCols) {
        this.grid = new Grid(nbRows, nbCols);
        this.isPlayer1Turn = true;
    }
    
    public GameModel(GameModel model) {
        this.isPlayer1Turn = model.isPlayer1Turn;
        this.grid = new Grid(model.grid);
    }
}
