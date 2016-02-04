package model.Classes;

import java.util.HashMap;
import model.Characteristic;
import model.Effect;
import model.Items.ArmorItem;
import model.Items.WeaponItem;
import model.Level;

/**
 * Character class : MAM 
 * @author Lafaye, Lhopital, Paccaud
 */
public class Mam extends model.Personnage{

    public static int BASIC_STRENGHT = 1;
    public static int BASIC_HEALTH = 100;
    public static int BASIC_DEXTIRITY = 5;
    public static int BASIC_DEFENCE = 1;
    public static int BASIC_INTELIGENCE = 22;
    
    /**
     * Constructor for player
     * @param name the name of the character
     */
    public Mam(String name){
        super(name);
    }
    
    /**
     * Constructor for the PNJ
     * @param name the name of the character
     * @param level the level of the character
     */
    public Mam(String name, Level level){
        super(name, level);
    }

    /**
     * Initialize characteristics of the MAM
     */
    @Override
    protected void initCharacteristics() {
        this.characteritics=new HashMap<>();
        this.characteritics.put(Characteristic.HEALTH, BASIC_HEALTH);
        this.characteritics.put(Characteristic.STRENGHT, BASIC_STRENGHT);
        this.characteritics.put(Characteristic.DEXTIRITY, BASIC_DEXTIRITY);
        this.characteritics.put(Characteristic.DEFENCE, BASIC_DEFENCE);
        this.characteritics.put(Characteristic.INTELIGENCE, BASIC_INTELIGENCE);
        WeaponItem w = new WeaponItem("Théorème de Pythagore", 1, 1, 3, new Effect(Characteristic.INTELIGENCE, 2, -1));
        this.equipWeapon(w,this.sharedBag);
        ArmorItem a = new ArmorItem("Tee-shirt de soirée",1,1);
        this.equipArmor(a,this.sharedBag);
    }

    /**
     * Get class Name
     * @return "MAM"
     */
    @Override
    public String getClassName() {
        return "MAM";
    }
    
}
