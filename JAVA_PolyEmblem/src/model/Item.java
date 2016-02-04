package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent an item. 
 * @author Lafaye, Lhopital, Paccaud
 */
public class Item {
    
    private String name;
    private int weight; 
    private List<Effect> allEffects;

    /**
     * false if the item is not equiped
     * true it the item is equiped by a character
     */
    public boolean equiped;
    
    /**
     * Constructor
     * @param name the name of the item
     * @param weight the weight of the item (g)
     * @param effects a list of effects
     */
    public Item(String name, int weight, Effect... effects) {
        this.name = name; 
        this.weight = weight;
        this.allEffects = new ArrayList();
        for(int i = 0; i < effects.length; i++) {
            this.allEffects.add(effects[i]);
        }
        equiped = false;
    }

    /**
     * Get the name of the item
     * @return the name of the item
     */
    public String getName() {
        return name;
    }

    /**
     * Get the description of the item
     * @return the description of the item
     */
    public String getDescription() {
        String effectString = "";
        for (Effect anEffect : allEffects) {
            effectString = effectString + "\n >> " + anEffect.toString();
        }
        
        return  name.toUpperCase() + " : " 
                + "\n POIDS : " + weight + " g"
                + "\n EFFETS : " + effectString;
    }

    /**
     * Get the weight of the item
     * @return the weight of the item
     */
    public int getWeight() {
        return weight;
    }
    
    /**
     * Get all Effects of the item
     * @return a list of effect
     */
    public List<Effect> getAllEffects() {
        return allEffects;
    }
    
}
