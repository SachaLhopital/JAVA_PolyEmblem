package model;

import java.util.LinkedList;
import java.util.List;

/***
 * Represent the bag of the adventure. All items of the player team are inside the bag.
 * @author Lafaye, Lhopital, Paccaud
 */
public class Bag {
    
    /**
     * List of all items in the bag
     */
    public List<Item> allItems;

    /**
     * The max weight of the bag
     */
    public int maxWeight;
    
    /**
     * Constructor of the bag. One bag for one team
     * @param allPlayers the team of the player.
     */
    public Bag(List<Personnage> allPlayers) {
        allItems = new LinkedList<Item>();
        maxWeight = 0;
        for(Personnage player : allPlayers) {
            maxWeight += Personnage.MAX_WEIGHT;
        }
    }
    
    /**
     * Remove a selected item from the bag
     * @param item the item to remove
     */
    public void removeItem(Item item){
        if(allItems.contains(item)) {
            allItems.remove(item);
        }   
    }
    
    /**
     * Add an item in the bag
     * @param item the item to add in the bag
     */
    public void addItem(Item item) {
        allItems.add(item);
    }
    
    /**
     * Sum all players weight to get the actual in use weight of the bag
     * @return the actual in use weight
     */
    public int getActualInUseWeight() {
        int actualInUseWeight = 0;
        for(Item item : allItems) {
            actualInUseWeight += item.getWeight();
        }
        return actualInUseWeight;
    }
    
}
