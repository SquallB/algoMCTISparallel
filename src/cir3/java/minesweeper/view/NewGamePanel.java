package cir3.java.minesweeper.view;

import cir3.java.minesweeper.model.GameModel;
import cir3.java.minesweeper.model.Difficulty;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * Panels that allows to choose a difficulty and start a new game.
 * 
 * @author sylvain
 */
public class NewGamePanel extends JPanel {
    private JButton newGameButton;
    private int nbRows;
    private int nbCols;
    
    /**
     * 2-arguments constructot
     * 
     * @param frame the frame in which the panel is
     * @param width the width of the frame
     */
    public NewGamePanel(final JFrame frame, int width) {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        nbRows = 3;
        nbCols = 3;
        
        newGameButton = new JButton("OK");
        newGameButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {               
                GameModel m = new GameModel(nbRows, nbCols);
                m.addView(new GraphicalView(m));
                frame.setVisible(false);
            }
        });
        this.add(newGameButton);
    }

    /**
     * Default construct or.
     */
    public NewGamePanel() {
        this(null, 0);
    }    
}