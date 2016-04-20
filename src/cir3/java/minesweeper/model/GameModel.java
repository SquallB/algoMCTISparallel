package cir3.java.minesweeper.model;

import cir3.java.minesweeper.event.CellStateEvent;
import cir3.java.mvc.AbstractModel;
import java.util.ArrayList;
import java.util.List;

public class GameModel extends AbstractModel {
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
    
    public List<Cell> getWinningCombinaison() {
        List<Cell> winning;
        PlayerState player;
        if(this.isPlayer1Turn) {
            player = PlayerState.PLAYER1;
        }
        else {
            player = PlayerState.PLAYER2;
        }
        
        //horizontal
        for(int i = 0; i <  grid.getNbRows(); i++) {
            winning = new ArrayList<>();
            for(int j = 0; j < grid.getNbCols(); j++) {
                
                Cell cell = grid.getCell(i, j);
                if(cell.getState() == player) {
                    winning.add(cell);
                }
            }
            if(winning.size() == 3) {
                return winning;
            }
        }
        
        //vertical
        for(int j = 0; j <  grid.getNbCols(); j++) {
            winning = new ArrayList<>();
            for(int i = 0; i < grid.getNbRows(); i++) {
                Cell cell = grid.getCell(i, j);
                if(cell.getState() == player) {
                    winning.add(cell);
                }
            }
            if(winning.size() == 3) {
                return winning;
            }
        }
        
        //diagonal
        winning = new ArrayList<>();
        for(int i = 0; i <  grid.getNbRows(); i++) {
            int j = i;
                
            Cell cell = grid.getCell(i, j);
            if(cell.getState() == player) {
                winning.add(cell);
            }
        }
        if(winning.size() == 3) {
            return winning;
        }
        
        //other diagonal
        winning = new ArrayList<>();
        for(int i = 0; i <  grid.getNbRows(); i++) {
            int j = grid.getNbCols() - 1 - i;
                
            Cell cell = grid.getCell(i, j);
            if(cell.getState() == player) {
                winning.add(cell);
            }
        }
        if(winning.size() == 3) {
            return winning;
        }
    
        return null;
    }
    
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
    
    public List<Cell> calculatePossibilities() {
        List<Cell> possibilities = new ArrayList<>();
        
        for(int i = 0; i < grid.getNbRows(); i++) {
            for(int j = 0; j < grid.getNbCols(); j++) {
                Cell cell = grid.getCell(i, j);
                if(cell.getState() instanceof PlayerState) {
                    PlayerState state = (PlayerState)cell.getState();
                    if(state == PlayerState.NONE) {
                        possibilities.add(cell);
                    }
                }
            }
        }
        
        return possibilities;
    }
    
    public GameModel simulateMove(int i, int j) {
        return simulateMove(grid.getCell(i, j));
    }
    
    public GameModel simulateMove(Cell cell) {
        GameModel model = new GameModel(this);
        PlayerState state;
        if(this.isPlayer1Turn) {
            state = PlayerState.PLAYER1;
        }
        else {
            state = PlayerState.PLAYER2;
        }
        model.grid.changeCellState(cell.getI(), cell.getJ(), state);
        model.isPlayer1Turn = !isPlayer1Turn;
        return model;
    }

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
