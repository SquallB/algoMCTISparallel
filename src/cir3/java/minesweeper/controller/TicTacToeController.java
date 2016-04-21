/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cir3.java.minesweeper.controller;

import cir3.java.mcts.MCTS;
import cir3.java.minesweeper.model.Cell;
import cir3.java.minesweeper.model.GameModel;
import cir3.java.minesweeper.model.PlayerState;
import cir3.java.mvc.Controller;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

/**
 *
 * @author .Sylvain
 */
public class TicTacToeController implements Controller, MouseListener {
    private GameModel model;
    private Cell cell;
    public static MCTS tree = null;

    public TicTacToeController(GameModel model, Cell cell) {
        this.model = model;
        this.cell = cell;
    }
    @Override
    public void control() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void mctsSearch (GameModel board) {
        
        MCTS tree = TicTacToeController.tree;
        
        if (tree == null || tree != null) {
            tree = new MCTS();
            tree.setChildNotCreated(board.calculatePossibilities());
            
            
        }
        System.out.println("CE que l'on a ");
        System.out.println(tree.getChildCreated().size() + tree.getChildNotCreated().size());
        System.out.println("ce qu'on devrait");
        System.out.println(board.calculatePossibilities().size());
        tree.setBoard(board);
        boolean player = board.isIsPlayer1Turn();
        
        
        long start = System.currentTimeMillis();
        long end = start + 500;
        int i = 0;
        while (System.currentTimeMillis() < end) {
            /*
            if (i>100) {
                System.out.println("");
            }*/
          
            
            MCTS child = tree.treePolicy();
            int scoreChild = child.defaultPolicy(player);
            tree = child.backUpResult(scoreChild, player);
            i++;
        }
        
        TicTacToeController.tree = tree.bestChild();
        
        
    }
    
    /**
     * Handles the clicks on the cell.
     * 
     * @param e the event fired
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if(!model.isGameOver()) {
            List<Cell> possibilities = model.calculatePossibilities();
            
            if(possibilities.size() > 0 && cell.getState() instanceof PlayerState) {
                PlayerState state = (PlayerState)cell.getState();
                if(state == PlayerState.NONE && possibilities.contains(cell)) {
                    PlayerState newState;
                    if(model.isIsPlayer1Turn()) {
                        newState = PlayerState.PLAYER1;
                    }
                    else {
                        newState = PlayerState.PLAYER2;
                    }
                    model.changeCellState(cell, newState);
                    
                    if(model.isGameOver()) {
                        System.out.println("game over");
                    }
                    else {
                        model.setIsPlayer1Turn(!model.isIsPlayer1Turn());
                        if(model.calculatePossibilities().size() > 0) {
                            if(tree != null) {
                                
                                TicTacToeController.tree = TicTacToeController.tree.selectChildFromMove(cell);
                                
                                
                            } 
                            
                            this.mctsSearch(model);
                          
                            if(model.isIsPlayer1Turn()) {
                                newState = PlayerState.PLAYER1;
                            }
                            else {
                                newState = PlayerState.PLAYER2;
                            }
                                System.out.println(tree.getCell().getI() + "    " + tree.getCell().getJ());
                            model.changeCellState(tree.getCell(), newState);
                            if(model.isGameOver()) {
                                System.out.println("game over");
                            }
                            else {
                                model.setIsPlayer1Turn(!model.isIsPlayer1Turn());
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Does nothing.
     * 
     * @param e the event fired
     */
    @Override
    public void mousePressed(MouseEvent e) {

    }

    /**
     * Does nothing.
     * 
     * @param e the event fired
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * Does nothing.
     * 
     * @param e the event fired
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * Does nothing.
     * 
     * @param e the event fired
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }
    
}
