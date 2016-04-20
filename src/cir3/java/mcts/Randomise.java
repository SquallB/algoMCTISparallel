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
public class Randomise {
    
    
    
    public static int getRandomNumber(int min, int max){
        return min + (int) (Math.random()*((max-min) +1));
        
    }
    
}
