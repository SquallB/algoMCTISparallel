package cir3.java.minesweeper.model;

public class GameState implements State {
    private String content;

    public GameState() {
        this("");
    }

    public GameState(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }    
}
