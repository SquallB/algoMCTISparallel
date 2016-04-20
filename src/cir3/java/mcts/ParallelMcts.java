/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cir3.java.mcts;



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
    
    public MCTS mctsSearch (MCTS tree) {
        if (tree == null) {
            tree = new MCTS();
            //TODO tree.childNotYetCreate = board.possibilities
        }
        //TODO tree.board = board
        String player = "";
        //TODO player = board.player
        
        long start = System.currentTimeMillis();
        long end = start + 500;
        while (System.currentTimeMillis() < end) {
            MCTS child = tree.treePolicy();
            int scoreChild = child.defaultPolicy(player);
            child.backUpResult(scoreChild, player);
        }
        tree = tree.selectChildFromMove(tree.bestChild().getMove());
        return tree;
    }
    
}
