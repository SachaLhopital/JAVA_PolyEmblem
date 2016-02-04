package model.Event;

import java.util.ArrayList;
import java.util.List;
import model.Events;
import model.IA.IAPersonnage;

/**
 * Event when the player discover a (group of) enemy. This event run a fight !
 * @author Lafaye, Lhopital, Paccaud
 */
public class FightEvent extends Events {
    
    private List<IAPersonnage> allBadGuys;
    
    /**
     * Constructor 
     * @param description the scenario of the event
     * @param badGuys a list of all enemy
     */
    public FightEvent(String description, IAPersonnage... badGuys) {
        super (description);
        
        allBadGuys = new ArrayList<IAPersonnage>();
        for(int i = 0; i < badGuys.length; i ++) {
            allBadGuys.add(badGuys[i]);
        }
    }
    
    /**
     * Get all enemies
     * @return a list of IAPersonnage
     */
    public List<IAPersonnage> getAllBadGuys() {
        return allBadGuys;
    }
}
