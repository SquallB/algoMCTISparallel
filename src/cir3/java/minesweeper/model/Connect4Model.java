/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cir3.java.minesweeper.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author .Sylvain
 */
public class Connect4Model extends GameModel {
    public List<Cell> calculatePossibilities() {
        Grid grid = this.getGrid();
        List<Cell> possibilities = new ArrayList<>();
        
        for(int i = 0; i < grid.getNbRows(); i++) {
            for(int j = 0; j < grid.getNbCols(); j++) {
                Cell cell = grid.getCell(i, j);
                if(cell.getState() == PlayerState.NONE && (i == (grid.getNbRows() - 1) || (grid.getCell(i + 1, j).getState() != PlayerState.NONE))) {
                    possibilities.add(cell);
                }
            }
        }
        
        return possibilities;
    }
    
    private boolean checkBounds(int value, int min, int max) {
        return (value <= max) && (value >= min);
    }
    
    private List<Cell> countChain(Cell cell, int di, int dj, int chainSize) {
        List<Cell> winning = new ArrayList<>();
        winning.add(cell);
        Grid grid = getGrid();
        int i = cell.getI();
        int j = cell.getJ();
        int reverseI = i;
        int reverseJ = j;
        int halfSize = chainSize / 2;
        int maxRow = grid.getNbRows() - 1;
        int maxCol = grid.getNbCols() - 1;
        State player;
        if(this.isIsPlayer1Turn()) {
            player = PlayerState.PLAYER1;
        }
        else {
            player = PlayerState.PLAYER2;
        }
        for(int k = 0; k < halfSize; k++) {
            i += di;
            j += dj;
            reverseI -= di;
            reverseJ -= dj;
            
            if(checkBounds(i, 0, maxRow) && checkBounds(j, 0, maxCol) && grid.getCell(i, j).getState() == player && grid.getCell(i-di, j-di) == player) {
                winning.add(cell);
            }
            
            if(checkBounds(reverseI, 0, maxRow) && checkBounds(reverseJ, 0, maxCol) && grid.getCell(reverseI, reverseJ).getState() == player && grid.getCell(reverseI+di, reverseJ+dj) == player) {
                winning.add(cell);
            }
        }
                
        if(winning.size() >= chainSize) {
            return winning;
        }
        else {
            return null;
        }
    }
    
    public List<Cell> getWinningCombinaison() {
        List<Cell> winning;
        int winningWantedSize = 4;
        Grid grid = getGrid();
    
        for(int i = 0; i < grid.getNbRows(); i++) {
            for(int j = 0; j < grid.getNbCols(); j++) {
                Cell cell = grid.getCell(i, j);
                
                winning = countChain(cell, 1, 0, winningWantedSize);
                if(winning != null) {
                    return winning;
                }
                
                winning = countChain(cell, 0, 1, winningWantedSize);
                if(winning != null) {
                    return winning;
                }
                
                winning = countChain(cell, 1, 1, winningWantedSize);
                if(winning != null) {
                    return winning;
                }
                
                winning = countChain(cell, -1, 1, winningWantedSize);
                if(winning != null) {
                    return winning;
                }
            }
        }

        return null;
    }
    
    public GameModel simulateMove(Cell cell) {
        GameModel model = new Connect4Model(this);
        PlayerState state;
        if(this.isIsPlayer1Turn()) {
            state = PlayerState.PLAYER1;
        }
        else {
            state = PlayerState.PLAYER2;
        }
        model.getGrid().changeCellState(cell.getI(), cell.getJ(), state);
        model.setIsPlayer1Turn(!this.isIsPlayer1Turn());
        return model;
    }
    
    public Connect4Model(Grid grid) {
        super(grid);
    }
    
    public Connect4Model(int nbRows, int nbCols) {
        super(nbRows, nbCols);
    }
    
    public Connect4Model(GameModel model) {
        super(new Grid(model.getGrid()));
        this.setIsPlayer1Turn(model.isIsPlayer1Turn());
    }
    
}
