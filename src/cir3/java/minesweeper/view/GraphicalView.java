
package cir3.java.minesweeper.view;

import cir3.java.minesweeper.event.CellEvent;
import cir3.java.mvc.Event;
import cir3.java.minesweeper.model.GameModel;
import cir3.java.mvc.View;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Represents the graphical view of a mine sweeper game.
 * 
 * @author sylvain
 */
public class GraphicalView extends JFrame implements View {
    private GraphicalGridView grid;
    //private JLabel statusBar;
    private GraphicalMenuBar menu;
    private GameModel model;
    //private ChronoGraphicalView chrono;

    /**
     * Refreshes the view using the given event.
     * 
     * @param e the fired event
     */
    @Override
    public void refresh(Event e) {
        if(e instanceof CellEvent) {
            grid.refreshCell(((CellEvent)e).getCell());
        }
    }

    /**
     * 3-arguments constructor.
     * 
     * @param m the model on which the view is
     * @param width the width of the frame
     * @param height the height of the frame
     */
    public GraphicalView(GameModel m, int width, int height) {
        super(GraphicalViewConstants.GAME_FRAME_NAME);
        grid = new GraphicalGridView(m);
        //statusBar = new JLabel(GraphicalViewConstants.STATUS_BAR_TEXT + Integer.toString(m.getNbRemainingMines()), SwingConstants.CENTER);
        menu = new GraphicalMenuBar(this);
        model = m;
        /*chrono = new ChronoGraphicalView();
        m.getChrono().addView(chrono);
        m.getChrono().start();-*/
        
        this.setLayout(new BorderLayout());
        //this.add(chrono, BorderLayout.NORTH);
        this.add(grid, BorderLayout.CENTER);
        //this.add(statusBar, BorderLayout.SOUTH);
        this.setJMenuBar(menu);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setVisible(true);
    }

    /**
     * 1-argument constructor
     * 
     * @param model the model on which the view is
     */
    public GraphicalView(GameModel model) {
        this(model, GraphicalViewConstants.DEFAULT_FRAME_WIDTH, GraphicalViewConstants.DEFAULT_FRAME_HEIGHT);
    }

    /**
     * Default constructor.
     */
    public GraphicalView() {
        this(null);
    }
}