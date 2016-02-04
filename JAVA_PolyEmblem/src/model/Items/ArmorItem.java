package model.Items;

import model.Characteristic;
import model.Effect;
import model.Item;

/**
 * Create an armor
 * @author Lafaye, Lhopital, Paccaud
 */
public class ArmorItem extends Item {
    
    private final int protection;

    /**
     * Constructor
     * @param name the name of the armor
     * @param weight the weight of the armor (g)
     * @param protection the value of the protection
     */
    public ArmorItem(String name, int weight, int protection) {
        super(name, weight, new Effect(Characteristic.DEFENCE, protection, -1));
        this.protection = protection;
    }
    
    /**
     * Get the protection given by the armor
     * @return the value of the protection 
     */
    public int getProtection(){
        return this.protection;
    }
    
}
