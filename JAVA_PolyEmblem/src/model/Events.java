package model;

/**
 *
 * @author lhopital
 */
public class Events {
    
    /* Describe the event for the player */
    private String descriptionEvent;

    /**
     *
     */
    public boolean isDone;
    
    /**
     *
     * @param description
     */
    public Events(String description) {
        descriptionEvent = description;
        isDone = false;
    }
    
    /**
     *
     * @return
     */
    public String getDescriptionEvent() {
        return descriptionEvent;
    }
}
