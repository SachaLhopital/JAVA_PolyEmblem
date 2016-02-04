package model.Items;

import model.Effect;
import model.Item;

/**
 * Create a weapon
 * @author Lafaye, Lhopital, Paccaud
 */
public class WeaponItem extends Item {
    
    private final int damage;
    private final int heal;

    /**
     * Constructor
     * @param name the name of the weapon
     * @param weight the weight of the weapon (g)
     * @param damage the value of the damage bonus given by the weapon
     * @param heal the value of the heal bonus given by the weapon
     * @param effects a list of effects given by the weapon
     */
    public WeaponItem(String name, int weight, int damage, int heal, Effect... effects) {
        super(name, weight, effects);
        this.damage = damage;
        this.heal = heal;
    }
    
    /**
     * Get the damage bonus of the weapon
     * @return the damage value
     */
    public int getDamage(){
        return this.damage;
    }
    
    /**
     * Get the heal bonus of the weapon
     * @return the heal value
     */
    public int getHeal(){
        return this.heal;
    }
    
}
