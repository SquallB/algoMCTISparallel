/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cir3.java.minesweeper.event;

import cir3.java.minesweeper.model.Cell;
import cir3.java.mvc.AbstractModel;
import cir3.java.mvc.Event;
import java.util.List;

/**
 *
 * @author .Sylvain
 */
public class GameOverEvent extends Event {
    private List<Cell> winningCombinaison;

    public List<Cell> getWinningCombinaison() {
        return winningCombinaison;
    }

    public void setWinningCombinaison(List<Cell> winningCombinaison) {
        this.winningCombinaison = winningCombinaison;
    }

    public GameOverEvent(AbstractModel model, List<Cell> winningCombinaison) {
        super(model);
        this.winningCombinaison = winningCombinaison;
    }
}
