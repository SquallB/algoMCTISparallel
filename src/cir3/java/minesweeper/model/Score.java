
package cir3.java.minesweeper.model;

import cir3.java.chronometer.model.Time;
import java.io.Serializable;
/**
 * Define a score at the end of a game.
 * 
 */

public class Score implements Serializable, Comparable<Score> {
    
    private String player;
    private Time time;
    private Difficulty difficulty;
    /**
     * Getter for the attribute player.
     * @return the attribute player.
     */

    public String getPlayer() {
        return player;
    }

    /**
     * Setter for the attribute player.
     * @param player the attribute to set.
     */
    public void setPlayer(String player) {
        this.player = player;
    }

    /**
     * Getter for the attribute time.
     * @return the attribute time.
     */
    public Time getTime() {
        return time;
    }

    /**
     * Setter for the attribute time.
     * @param time the value of attribute to set.
     */
    public void setTime(Time time) {
        this.time = time;
    }
    
    /**
     * Getter for the attribute difficulty.
     * @return the attribute difficulty.
     */
    public Difficulty getDifficulty() {
        return difficulty;
    }

    /**
     * Setter for the attribute difficulty.
     * @param difficulty the value of attribute to set.
     */
    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }
            
    /**
     * Constructor using for creating a Score.
     * @param player the name of player.
     * @param time the time  used to finish a game.
     * @param difficulty the level of difficulty chosen.
     */
    public Score(String player, Time time, Difficulty difficulty) {
        this.player = player;
        this.time = time;
        this.difficulty = difficulty;
    }
    
    /**
     * Compares a score to another, starting with minutes the seconds.
     * 
     * @param o the other score to compare with the current one
     * @return 1 if current score is better, -1 if worse, 0 if equals
     */
    @Override
    public int compareTo(Score o) {
        int returnValue = 0;
        Time thisScoreTime = getTime();
        Time otherScoreTime = o.getTime();
        
        if(thisScoreTime.getMinutes() > otherScoreTime.getMinutes()) {
            returnValue = 1;
        }
        else if(thisScoreTime.getMinutes() < otherScoreTime.getMinutes()) {
            returnValue = -1;
        }
        else {
            if(thisScoreTime.getSeconds() > otherScoreTime.getSeconds()) {
            returnValue = 1;
            }
            else if(thisScoreTime.getSeconds()< otherScoreTime.getSeconds()) {
                returnValue = -1;
            }
            else {
                returnValue = 0;
            }
        }
        
        return returnValue;
    }
    
    /**
     * Default constructor.
     */
    public Score() {
        this("", new Time(), Difficulty.BEGINNER);
    }
}
