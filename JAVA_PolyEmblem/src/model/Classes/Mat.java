package model.Classes;

import java.util.HashMap;
import model.Characteristic;
import model.Effect;
import model.Items.ArmorItem;
import model.Items.WeaponItem;
import model.Level;

/**
 * Character class : MAT. 
 * @author Lafaye, Lhopital, Paccaud
 */
public class Mat extends model.Personnage{

    public static int BASIC_STRENGHT = 30;
    public static int BASIC_HEALTH = 100;
    public static int BASIC_DEXTIRITY = 1;
    public static int BASIC_DEFENCE = 5;
    public static int BASIC_INTELIGENCE = 1;
    
    private boolean tired;
    
    /**
     * Constructor for player
     * @param name the character name
     */
    public Mat(String name){
        super(name);
        tired = false;
    }
    
    /**
     * Constructor for PNJ
     * @param name the name of the character
     * @param level the level of the character
     */
    public Mat(String name, Level level){
        super(name, level);
    }

    /**
     * Initialize characteristics of the MAT
     */
    @Override
    protected void initCharacteristics() {
        this.characteritics=new HashMap<>();
        this.characteritics.put(Characteristic.HEALTH, BASIC_HEALTH);
        this.characteritics.put(Characteristic.STRENGHT, BASIC_STRENGHT);
        this.characteritics.put(Characteristic.DEXTIRITY, BASIC_DEXTIRITY);
        this.characteritics.put(Characteristic.DEFENCE, BASIC_DEFENCE);
        this.characteritics.put(Characteristic.INTELIGENCE, BASIC_INTELIGENCE);
        WeaponItem w = new WeaponItem("Règle en plastique", 5, 3, 0, new Effect(Characteristic.DEFENCE, 0, -1));
        this.equipWeapon(w,this.sharedBag);
        ArmorItem a = new ArmorItem("Tee-shirt de soirée",1,1);
        this.equipArmor(a,this.sharedBag);
    }

    /**
     * Get class Name
     * @return "MAT"
     */
    @Override
    public String getClassName() {
        return "MAT";
    }
    
    
    /**
     * To balance the game, MAT can only attack a ride on two. 
     * @return true if the character can't attack - false otherwise
     */
    public boolean isTired(){
        return tired;
    }
    
    /**
     * Set tired for the next turn
     * @param tired 
     */
    public void setTired(boolean tired){
        this.tired = tired;
    }
    
}
