package model.Classes;

import java.util.HashMap;
import model.Characteristic;
import model.Effect;
import model.Items.ArmorItem;
import model.Items.WeaponItem;
import model.Level;

/**
 * Character class : GBM 
 * @author Lafaye, Lhopital, Paccaud
 */
public class Gbm extends model.Personnage{

    public static int BASIC_STRENGHT = 1;
    public static int BASIC_HEALTH = 100;
    public static int BASIC_DEXTIRITY = 8;
    public static int BASIC_DEFENCE = 1;
    public static int BASIC_INTELIGENCE = 13;
    
    /**
     * Constructor for player
     * @param name the name of the character
     */
    public Gbm(String name){
        super(name);
    }
    
    /**
     * Constructor for PNJ
     * @param name the name of the character
     * @param level the level of the character
     */
    public Gbm(String name, Level level){
        super(name, level);
    }

    /**
     * Initialise characteristics of the GBM
     */
    @Override
    protected void initCharacteristics() {
        this.characteritics=new HashMap<>();
        this.characteritics.put(Characteristic.HEALTH, BASIC_HEALTH);
        this.characteritics.put(Characteristic.STRENGHT, BASIC_STRENGHT);
        this.characteritics.put(Characteristic.DEXTIRITY, BASIC_DEXTIRITY);
        this.characteritics.put(Characteristic.DEFENCE, BASIC_DEFENCE);
        this.characteritics.put(Characteristic.INTELIGENCE, BASIC_INTELIGENCE);
        WeaponItem w = new WeaponItem("Café bien chaud", 5, 1, 4, new Effect(Characteristic.INTELIGENCE, 1, -1));
        this.equipWeapon(w,this.sharedBag);
        ArmorItem a = new ArmorItem("Tee-shirt de soirée",1,1);
        this.equipArmor(a,this.sharedBag);
    }

    /**
     * Get class name
     * @return "GBM"
     */
    @Override
    public String getClassName() {
        return "GBM";
    }
}