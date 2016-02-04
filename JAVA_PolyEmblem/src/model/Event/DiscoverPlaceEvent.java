package model.Event;

import model.Events;
import model.Item;

/**
 * Event when the player discover a new place. This new place contain a treasure !
 * @author Lafaye, Lhopital, Paccaud
 */
public class DiscoverPlaceEvent extends Events {
    
    private Item zeTreasure;
    
    /**
     * Constructor
     * @param description the scenario to get there
     * @param treasure the item to be discovered
     */
    public DiscoverPlaceEvent(String description, Item treasure) {
        super(description);
        zeTreasure = treasure;
    }
    
    /**
     * Get the treasure of the event
     * @return the item to be discovered
     */
    public Item getTreasure() {
        return zeTreasure;
    }
    
}
