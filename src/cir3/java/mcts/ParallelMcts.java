/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cir3.java.mcts;

import cir3.java.minesweeper.model.GameModel;



/**
 *
 * @author Tanguy MERCIE
 */
public class ParallelMcts {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }
    
    public MCTS mctsSearch (GameModel board, MCTS tree) {
        if (tree == null) {
            tree = new MCTS();
            tree.setChildNotCreated(board.calculatePossibilities());
            
        }
        tree.setBoard(board);
        boolean player = board.isIsPlayer1Turn();
        
        
        long start = System.currentTimeMillis();
        long end = start + 500;
        while (System.currentTimeMillis() < end) {
            MCTS child = tree.treePolicy();
            int scoreChild = child.defaultPolicy(player);
            child.backUpResult(scoreChild, player);
        }
        tree = tree.selectChildFromMove(tree.bestChild().getCell());
        return tree;
    }
    
}
