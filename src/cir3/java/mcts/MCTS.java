/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cir3.java.mcts;

import cir3.java.minesweeper.model.Cell;
import cir3.java.minesweeper.model.GameModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tanguy MERCIE
 */
public class MCTS {
    
    private int numberRun;
    private int score;
    private MCTS parent;
    private ArrayList<MCTS> childCreated = new ArrayList<>();
    private List<Cell> childNotCreated = new ArrayList<>();
    private Cell move;
    private boolean isTerminal = false;
    private GameModel board;

    public GameModel getBoard() {
        return board;
    }
    
    public void setBoard(GameModel board) {
        this.board = board;
    }

    
    
    public int getNumberRun() {
        return numberRun;
    }

    public void setNumberRun(int numberRun) {
        this.numberRun = numberRun;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public MCTS getParent() {
        return parent;
    }

    public void setParent(MCTS parent) {
        this.parent = parent;
    }

    public ArrayList<MCTS> getChildCreated() {
        return childCreated;
    }

    public void setChildCreated(ArrayList<MCTS> childCreated) {
        this.childCreated = childCreated;
    }

    public List<Cell> getChildNotCreated() {
        return childNotCreated;
    }

    public void setChildNotCreated(List<Cell> childNotCreated) {
        this.childNotCreated = childNotCreated;
    }

    public Cell getCell() {
        return move;
    }

    public void setCell(Cell move) {
        this.move = move;
    }

    public boolean isIsTerminal() {
        return isTerminal;
    }

    public void setIsTerminal(boolean isTerminal) {
        this.isTerminal = isTerminal;
    }
    
    public MCTS treePolicy(){
        
        MCTS child = this;
        while (! child.isTerminal) {
            if ( ! child.childNotCreated.isEmpty() ) {
                return child.expand();
            }else {
                child = child.bestChild();
            }
        }
        return child;
    }

    private MCTS expand() {
        int randomNumber = Randomise.getRandomNumber(0, this.childNotCreated.size() -1);
        MCTS child = this.createChild(this.childNotCreated.remove(randomNumber));
        this.childCreated.add(child);
        
        return child;
        
    }

    public MCTS bestChild() {
        if(this.childCreated.size() == 0) {
            return null;
        }
       double maxFormula = Double.MIN_VALUE;
       int maxIndex =0;
       
       for (int i =0; i< this.childCreated.size(); i++) {
           
           MCTS currentChild = this.getChildCreated().get(i);
           double formula = (currentChild.getScore() / currentChild.getNumberRun()) + (1/Math.sqrt(6)) * Math.sqrt( Math.log(this.getNumberRun()) /  currentChild.getNumberRun());
           
           
           if (formula > maxFormula) {
               maxFormula = formula;
               maxIndex = i;
           }
       }
        
       return this.getChildCreated().get(maxIndex);
       
    }
    
    public int defaultPolicy (boolean player) {
        
        GameModel model = this.board;
        while ( ! model.isGameOver() && !model.calculatePossibilities().isEmpty() ) {
            List<Cell> cells = new ArrayList<>();
            cells = model.calculatePossibilities();
            int randomNumber = Randomise.getRandomNumber(0, cells.size()-1);
            Cell cell = cells.get(randomNumber);
            model = model.simulateMove(cell);
        }
        int result =0;
        if (model.isGameOver()){
            if (player != model.isIsPlayer1Turn()) {
                result = 1;
            }else {
                result =-1;
            }
        }
        return result;
    }

    public MCTS backUpResult(int result, boolean player) {
        MCTS node = this;
        boolean stop = false;
        while (!stop) {
            node.setNumberRun(node.getNumberRun() +1);
         
            
            if (node.board.isIsPlayer1Turn() == player ){
                node.setScore(node.getScore()+result);
            }else {
                node.setScore(node.getScore() -result);
            }  
            if (node.getParent() == null) {
                stop = true;
            }else {
                node = node.getParent();
            }
            
        }
        return node;
    }
    private MCTS createChild(Cell move) {
        MCTS newChild = new MCTS();
        newChild.setParent(this);
        
        
        newChild.board = this.board.simulateMove(move);
        newChild.setChildNotCreated(newChild.board.calculatePossibilities());
        if (newChild.board.isGameOver() || newChild.childNotCreated.isEmpty()) {
            newChild.isTerminal = true;
        }
       
        newChild.setCell(move);
        return newChild;
    }
    
    public MCTS selectChildFromMove (Cell move) {
        
       
        for (int i=0; i< this.getChildCreated().size(); i++) {
            
            if (this.getChildCreated().get(i).getCell().equals(move)) {
                
                return this.getChildCreated().get(i);
            }
        }
        return null;
    }
    
}
