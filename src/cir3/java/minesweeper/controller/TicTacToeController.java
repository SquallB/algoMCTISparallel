/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cir3.java.minesweeper.controller;

import cir3.java.minesweeper.model.Cell;
import cir3.java.minesweeper.model.GameModel;
import cir3.java.minesweeper.model.PlayerState;
import cir3.java.mvc.Controller;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author .Sylvain
 */
public class TicTacToeController implements Controller, MouseListener {
    private GameModel model;
    private Cell cell;

    public TicTacToeController(GameModel model, Cell cell) {
        this.model = model;
        this.cell = cell;
    }
    @Override
    public void control() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Handles the clicks on the cell.
     * 
     * @param e the event fired
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if(!model.isGameOver()) {
            if(cell.getState() instanceof PlayerState) {
                PlayerState state = (PlayerState)cell.getState();
                if(state == PlayerState.NONE) {
                    PlayerState newState;
                    if(model.isIsPlayer1Turn()) {
                        newState = PlayerState.PLAYER1;
                    }
                    else {
                        newState = PlayerState.PLAYER2;
                    }
                    model.changeCellState(cell.getI(), cell.getJ(), newState);
                    
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
