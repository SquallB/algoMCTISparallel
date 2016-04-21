package cir3.java.minesweeper.view;

import cir3.java.minesweeper.model.Connect4Model;
import cir3.java.minesweeper.model.GameModel;
import cir3.java.minesweeper.model.TicTacToeModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * Represents the menu of the graphical view frame.
 * 
 * @author sylvain
 */
public class GraphicalMenuBar extends JMenuBar{
    private List<JMenuItem> items;
    private JFrame frame;
    
    /**
     * Creates an item of the menu.
     * 
     * @param label the text of the item
     * @param container where the item is contained
     * @return the newly created item
     */
    public JMenuItem createMenuItem(String label, JMenuItem container) {
        JMenuItem newItem = new JMenuItem(label);
        container.add(newItem);
        
        return newItem;
    }
    
    /**
     * Creates a new game.
     * 
     * @param nbRows the number of rows
     * @param nbCols the number of columns
     */
    public void createNewGame(GameModel model) {
        model.addView(new GraphicalView(model));
        frame.setVisible(false);
    }
    
    /**
     * 1-argument constructor
     * 
     * @param frame the frame in which the menu is contained.
     */
    public GraphicalMenuBar(JFrame frame) {
        this.frame = frame;
        items = new LinkedList<>();
        
        JMenu menu = new JMenu(GraphicalViewConstants.MENU_GAME);
        menu.setMnemonic('G');
        JMenuItem item1 = new JMenu(GraphicalViewConstants.MENU_GAME_NEW);
        item1.setMnemonic('N');
        
        JMenuItem item2 = new JMenuItem(GraphicalViewConstants.MENU_GAME_QUIT);
        item2.setMnemonic('Q');
        item2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        JMenuItem newItem = createMenuItem(GraphicalViewConstants.GAME_NAME_TICTACTOE, item1);
        newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        newItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                createNewGame(new TicTacToeModel(3, 3));
            }
        });
        
        newItem = createMenuItem(GraphicalViewConstants.GAME_NAME_CONNECT4, item1);
        newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
        newItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                createNewGame(new Connect4Model(6, 7));
            }
        });
        
        menu.add(item1);
        menu.add(item2);
        
        this.add(menu);
    }

    /**
     * Default constructor.
     */
    public GraphicalMenuBar() {
        this(null);
    }
}