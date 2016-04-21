package cir3.java.minesweeper.view;

import cir3.java.minesweeper.model.Connect4Model;
import cir3.java.minesweeper.model.GameModel;
import cir3.java.minesweeper.model.TicTacToeModel;
import java.awt.Component;
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
    private ButtonGroup  buttons;
    private JButton newGameButton;
    private int nbRows;
    private int nbCols;
    private int selectedGame;
    
    /**
     * Adds a radio button to the panel and returns a reference on it
     * 
     * @param label the text of the button
     * @return the newly created button
     */
    public JRadioButton addRadioButton(String label) {
        JRadioButton button = new JRadioButton(label);
        buttons.add(button);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(button);
        
        return button;
    }
    
    /**
     * 2-arguments constructot
     * 
     * @param frame the frame in which the panel is
     * @param width the width of the frame
     */
    public NewGamePanel(final JFrame frame, int width) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        buttons = new ButtonGroup();
        nbRows = 3;
        nbCols = 3;
        selectedGame = 0;
            
        JRadioButton newButton = addRadioButton(GraphicalViewConstants.GAME_NAME_TICTACTOE);
        newButton.setSelected(true);
        newButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                nbRows = 3;
                nbCols = 3;
                selectedGame = 0;
            }
        });
        
        newButton = addRadioButton(GraphicalViewConstants.GAME_NAME_CONNECT4);
        newButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                nbRows = 6;
                nbCols = 7;
                selectedGame = 1;
            }
        });
        
        newGameButton = new JButton("OK");
        newGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {               
                GameModel model = null;

                if(selectedGame == 0) {
                    model = new TicTacToeModel(nbRows, nbCols);
                }
                else if(selectedGame == 1) {
                    model = new Connect4Model(nbRows, nbCols);
                }
                
                if(model != null) {
                    model.addView(new GraphicalView(model));
                    frame.setVisible(false);
                }
            }
        });
        this.add(newGameButton);
    }

    /**
     * Default constructor.
     */
    public NewGamePanel() {
        this(null, 0);
    }    
}