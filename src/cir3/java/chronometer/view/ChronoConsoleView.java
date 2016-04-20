
package cir3.java.chronometer.view;

import cir3.java.chronometer.event.NewMinutesEvents;
import cir3.java.chronometer.event.NewSecondsEvents;
import cir3.java.mvc.Event;
import cir3.java.minesweeper.event.NewValueEvent;
import cir3.java.mvc.View;

/**
 * A console view for the model Chronometer.
 * 
 * 
 */
public class ChronoConsoleView implements View {
    private String minutes;
    private String seconds;
    private String separator;

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
                if(nwe.getValue() < 10) {
                    minutes = "0";
                }
                else {
                    minutes = "";
                }
                minutes += Integer.toString(nwe.getValue());
            }
            else if(nwe instanceof NewSecondsEvents) {
                if(nwe.getValue() < 10) {
                    seconds = "0";
                }
                else {
                    seconds = "";
                }
                
                seconds += Integer.toString(nwe.getValue());
            }
        }
        
        display();
    }
    
    /**
     * Diplays in the console the time.
     */
    public void display() {
        System.out.println(minutes + separator + seconds);
    }

    /**
     * Default constructor.
     */
    public ChronoConsoleView() {
        minutes = "00";
        seconds = "00";
        separator = " : ";
    }
}
