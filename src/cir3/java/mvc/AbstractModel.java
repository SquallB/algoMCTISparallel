
package cir3.java.mvc;

import java.util.LinkedList;
import java.util.List;

/**
 * Generic class for a model.
 * 
 * 
 */
public abstract class AbstractModel {
    private List<View> views;
    
    /**
     * Adds a view to the list of views known by the model.
     * 
     * @param v the view to add
     */
    public void addView(View v) {
        views.add(v);
    }

    /**
     * Removes a view to the list of views known by the model.
     * 
     * @param v the view to remove
     */
    public void deleteView(View v) {
        views.remove(v);
    }

    /**
     * Calls the method refresh on all the views known by the model.
     * 
     * @param e the event fired by the model
     */
    public void refreshViews(Event e) {
        for(View v: views) {
            v.refresh(e);
        }
    }
    
    /**
     * Default constructor.
     */
    public AbstractModel() {
        this.views = new LinkedList<>();
    }
}
