/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cir3.java.mcts;

import cir3.java.minesweeper.model.GameModel;
import static java.lang.Math.log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.concurrent.ForkJoinPool;

import static java.lang.Math.sqrt;
import static java.util.stream.IntStream.range;
import static java.util.stream.LongStream.rangeClosed;


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
    
    public void mctsParallel(GameModel board, MCTS tree){
        Collection<? extends Callable> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            
}
        ForkJoinPool pool = new ForkJoinPool(16);
        
        long startTime = System.currentTimeMillis();
  
  
        List<Long> get = (List) pool.submit(() ->
        {mctsSearch(board, tree);});
            
            
      
        
        
        long endTime = System.currentTimeMillis();
 
        System.out.println("Image blur took " + (endTime - startTime) + 
                " milliseconds.");
    }
    

    private static void runTask(int limit) {
        log(range(1, limit).parallel().filter(ParallelMcts::isPrime).count());
    }

    public static boolean isPrime(long n) {
        return n > 1 && rangeClosed(2, (long) sqrt(n)).noneMatch(divisor -> n % divisor == 0);
    }
    
}
