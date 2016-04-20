
package cir3.java.chronometer.view;

import cir3.java.chronometer.event.NewMinutesEvents;
import cir3.java.chronometer.event.NewSecondsEvents;
import cir3.java.mvc.Event;
import cir3.java.minesweeper.event.NewValueEvent;
import cir3.java.mvc.View;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A graphical view for the model Chronometer.
 * 
 * 
 */
public class ChronoGraphicalView extends JPanel implements View {
    private JLabel minutes;
    private JLabel seconds;
    private JLabel separator;
    
    /**
     * Refreshes the view when an event is fired by the model.
     * 
     * @param e event fired by the model
     */
    @Override
    public void refresh(Event e) {
        if(e instanceof NewValueEvent) {
            NewValueEvent nwe = (NewValueEvent) e;
            
            if(nwe instanceof NewMinutesEvents) {
                String minutesText;
                
                if(nwe.getValue() < 10) {
                    minutesText = "0";
                }
                else {
                    minutesText = "";
                }
                minutesText += Integer.toString(nwe.getValue());
                minutes.setText(minutesText);
            }
            else if(nwe instanceof NewSecondsEvents) {
                String secondsText;
                
                if(nwe.getValue() < 10) {
                    secondsText = "0";
                }
                else {
                    secondsText = "";
                }
                secondsText += Integer.toString(nwe.getValue());
                seconds.setText(secondsText);
            }
        }
    }

    /**
     * Default constructor.
     */
    public ChronoGraphicalView() {
        setLayout(new FlowLayout());
        
        minutes = new JLabel("00");
        seconds = new JLabel("00");
        separator = new JLabel(" : ");
        
        add(minutes);
        add(separator);
        add(seconds);
    }    
}
