package cir3.java.mvc;

import cir3.java.mvc.AbstractModel;

/**
 * Generic class which is fired by a model when one of is attribute is changed.
 * 
 * 
 */
public class Event {
    
    private AbstractModel model;
    
    /**
     * Getter for the attribute model.
     * 
     * @return the attribute model
     */
    public AbstractModel getModel() {
        return model;
    }

    /**
     * Setter for the attribute model.
     * 
     * @param model new value for model
     */
    public void setModel(AbstractModel model) {
        this.model = model;
    }

    /**
     * 1-argument constructor.
     * 
     * @param model the model which fires the event
     */
    public Event(AbstractModel model) {
        this.model = model;
    }

    /** 
     * Default constructor.
     */
    public Event() {
        this(null);
    }

}