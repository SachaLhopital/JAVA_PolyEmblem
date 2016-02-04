package model.Items;

import model.Effect;
import model.Item;

/**
 * Create an edible item
 * @author Lafaye, Lhopital, Paccaud
 */
public class EdibleItem extends Item {

    /**
     * Constructor
     * @param name the name of the edible item
     * @param weight the weight of the edible item
     * @param effects the list of all effects of the edible item
     */
    public EdibleItem(String name, int weight, Effect... effects) {
        super(name, weight, effects);
    }    
}
