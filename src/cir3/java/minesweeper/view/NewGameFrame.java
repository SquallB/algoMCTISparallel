
package cir3.java.minesweeper.view;

import javax.swing.JFrame;

/**
 * Creates a frame for the new game panel.
 * 
 * @author sylvain
 */
public class NewGameFrame extends JFrame {
    private NewGamePanel panel;

    /**
     * 2-arguments constructor.
     * 
     * @param width the width of the frame
     * @param height the height of the frame
     */
    public NewGameFrame(int width, int height) {
        super(GraphicalViewConstants.NEW_GAME_FRAME_NAME);
        
        panel = new NewGamePanel(this, width);
        
        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setVisible(true);
    }

    /**
     * Default constructor.
     * 
     */
    public NewGameFrame() {
        this(GraphicalViewConstants.DEFAULT_FRAME_WIDTH, GraphicalViewConstants.DEFAULT_FRAME_HEIGHT);
    }    
}
