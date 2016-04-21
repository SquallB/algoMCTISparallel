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
public class TicTacToeModel extends GameModel {
    public List<Cell> calculatePossibilities() {
        Grid grid = this.getGrid();
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
    
    public List<Cell> getWinningCombinaison() {
        Grid grid = this.getGrid();
        List<Cell> winning;
        PlayerState player;
        if(this.isIsPlayer1Turn()) {
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
    
    public GameModel simulateMove(Cell cell) {
        GameModel model = new TicTacToeModel(this);
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
    
    public TicTacToeModel(Grid grid) {
        super(grid);
    }
    
    public TicTacToeModel(int nbRows, int nbCols) {
        super(nbRows, nbCols);
    }
    
    public TicTacToeModel(GameModel model) {
        super(new Grid(model.getGrid()));
        this.setIsPlayer1Turn(model.isIsPlayer1Turn());
    }
    
}
