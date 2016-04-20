/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cir3.java.mcts;

import cir3.java.minesweeper.model.GameModel;
import java.util.ArrayList;

/**
 *
 * @author Tanguy MERCIE
 */
public class MCTS {
    
    private int numberRun;
    private int score;
    private MCTS parent;
    private ArrayList<MCTS> childCreated = new ArrayList<>();
    private ArrayList<Move> childNotCreated = new ArrayList<>();
    private Move move;
    private boolean isTerminal = false;
    private GameModel board;

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

    public ArrayList<Move> getChildNotCreated() {
        return childNotCreated;
    }

    public void setChildNotCreated(ArrayList<Move> childNotCreated) {
        this.childNotCreated = childNotCreated;
    }

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
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
        MCTS child = this.createChild(this.childNotCreated.get(randomNumber));
        this.childCreated.add(child);
        this.childNotCreated.remove(randomNumber);
        return child;
        
    }

    public MCTS bestChild() {
       double maxFormula = -500;
       int maxIndex =0;
       for (int i =0; i< this.childCreated.size(); i++) {
           MCTS currentChild = this.getChildCreated().get(i);
           double formula = currentChild.getScore() / currentChild.getNumberRun();
           formula *= 1/Math.sqrt(7) * Math.sqrt(Math.log(this.getNumberRun()) / 10 * currentChild.getNumberRun());
           
           if (formula > maxFormula) {
               maxFormula = formula;
               maxIndex = i;
           }
       }
       return this.getChildCreated().get(maxIndex);
       
    }
    
    public int defaultPolicy (boolean player) {
        
        throw new UnsupportedOperationException();
    }

    public void backUpResult(int result, boolean player) {
        MCTS node = this;
        
        while (node != null) {
            node.setNumberRun(node.getNumberRun() +1);
         
            
            if (node.board.isIsPlayer1Turn() == player ){
                node.setScore(node.getScore()+result);
            }else {
                node.setScore(node.getScore() -result);
            }     
            node = node.getParent();
        }
        
    }
    private MCTS createChild(Move move) {
        MCTS newChild = new MCTS();
        newChild.setParent(this);
        
        
        
        //TODO : newChild.board
        //TODO : newChild.childNotYetCreate = newChild.board.possibilities
        /*
        if not newChild.board.won() == None or newChild.board.tied():
            newChild.isTerminal = True
        */
        newChild.setMove(move);
        return newChild;
    }
    
    public MCTS selectChildFromMove (Move move) {
        
        if (this == null) {
            return null;
        }
        for (int i=0; i< this.getChildCreated().size(); i++) {
            
            if (this.getChildCreated().get(i).getMove().equals(move)) {
                return this.getChildCreated().get(i);
            }
        }
        return null;
    }
    
}
