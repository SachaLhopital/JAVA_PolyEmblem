package model.Classes;

import java.util.HashMap;
import model.Characteristic;
import model.Effect;
import model.Items.ArmorItem;
import model.Items.WeaponItem;
import model.Level;
import model.Personnage;

/**
 * Character class : INFO 
 * @author Lafaye, Lhopital, Paccaud
 */
public class Info extends Personnage {

    public static int BASIC_STRENGHT = 13;
    public static int BASIC_HEALTH = 100;
    public static int BASIC_DEXTIRITY = 9;
    public static int BASIC_DEFENCE = 4;
    public static int BASIC_INTELIGENCE = 4;
    
    
    /**
     * Constructor for player
     * @param name the name of the character
     */
    public Info(String name){
        super(name);
    }
    
    /**
     * Constructor for PNJ
     * @param name the name of the character
     * @param level the level of the character
     */
    public Info(String name, Level level){
        super(name, level);
    }

    /** 
     * Initialize characteristics of the INFO
     */
    @Override
    protected void initCharacteristics() {
        this.characteritics=new HashMap<>();
        this.characteritics.put(Characteristic.HEALTH, BASIC_HEALTH);
        this.characteritics.put(Characteristic.STRENGHT, BASIC_STRENGHT);
        this.characteritics.put(Characteristic.DEXTIRITY, BASIC_DEXTIRITY);
        this.characteritics.put(Characteristic.DEFENCE, BASIC_DEFENCE);
        this.characteritics.put(Characteristic.INTELIGENCE, BASIC_INTELIGENCE);
        WeaponItem w = new WeaponItem("Clavier sans touches, sauf quelques unes", 5, 3, 1, new Effect(Characteristic.INTELIGENCE, 1, -1));
        this.equipWeapon(w,this.sharedBag);
        ArmorItem a = new ArmorItem("Tee-shirt de soirée",1,1);
        this.equipArmor(a,this.sharedBag);
    }

    /**
     * Get the class name 
     * @return "INFO"
     */
    @Override
    public String getClassName() {
        return "INFO";
    }
}
