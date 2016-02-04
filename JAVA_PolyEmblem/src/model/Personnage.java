
package model;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import model.Items.ArmorItem;
import model.Items.WeaponItem;

/**
 * Abstract class to create a character
 * @author Lafaye, Lhopital, Paccaud
 */
public abstract class Personnage {  
    
    /**
     * Maximum weight the character can carry in his bag
     */
    public static final int MAX_WEIGHT = 100;  

    /**
     * All Classes possibles in the game
     */
    public enum Classes{

        GBM,
        INFO,
        MAM,
        MAT,
        MECA,
        }
    
    private String name;
    private Level level;
    private int maxHealth;
    
    private int actualLife;
    
    private WeaponItem weapon;
    private ArmorItem armor;
    protected Bag sharedBag;
    
    /**
     * All characteristic of the character with their values.  
     */
    protected Map<Characteristic, Integer> characteritics;

    /**
     * List of all skills of the character.
     */
    protected List<Skill> skills;
    private List<Effect> effects;

    /**
     * Constructor for PNJ
     * @param name the name of the character
     * @param level the level of the character
     */
    public Personnage(String name, Level level) {
        this.name = name;
        this.level = level;
       
        this.initCharacteristics();
        this.initSkills();
     
        this.maxHealth = calcMaxHealth();
        this.weapon = null;
        this.armor = null;
        this.actualLife = this.calcMaxHealth();
    }

    /**
     * Constructor for the player
     * @param name the name of the character
     */
    public Personnage(String name) {
        this.name = name;
        this.level = new Level();
        
        this.initCharacteristics();
        this.initSkills();
        
        this.maxHealth = calcMaxHealth();
        this.level = new Level();
        this.actualLife = this.calcMaxHealth();
        this.maxHealth = calcMaxHealth();
    }
    
    /**
     * Abstract method that initialize all Characteristics of the character, based on his classe.
     */
    protected abstract void initCharacteristics();    
    
    /**
     * Add an Effect to the character
     * @param effect the effect to add
     */
    public void addEffect(Effect effect){
        this.effects.add(effect);
    }
    
    /**
     * Execute all effects of the character
     */
    public void runEffects(){
        for(Effect e: this.effects)
        {
            this.applicateEffect(e);
        }
    }
    
    /**
     * Apply all Effects of the character
     * @param effectToApply
     */
    public void applicateEffect(Effect effectToApply){
        if(effectToApply.getCharacteristicEffect().equals(model.Characteristic.LIFE)){
            this.actualLife += effectToApply.getValue();
        }else{
           this.characteritics.replace(effectToApply.getCharacteristicEffect(), effectToApply.getValue() 
                           + this.characteritics.getOrDefault(effectToApply.getCharacteristicEffect(),0));
        }
    }
    
    /**
     * Ceases to apply an effect to the character
     * @param e effect to cease
     */
    public void removeEffect(Effect e){
        if(e.getCharacteristicEffect().equals(model.Characteristic.LIFE)){
            this.actualLife -= e.getValue();
        }else{
           this.characteritics.replace(e.getCharacteristicEffect(), 
                   this.characteritics.getOrDefault(e.getCharacteristicEffect(),0) - e.getValue());
        }
    }
    
    /**
     * Equip the character with a weapon. When equip it, apply all effects of the weapon to him.
     * @param weaponItem the weapon to equip
     */
    public void equipWeapon(model.Items.WeaponItem weaponItem, Bag bag){
        if(this.weapon != null){
            unequipWeapon(bag);
        }
        //equip
        this.weapon = weaponItem;
        this.weapon.equiped = true;
        //apply effects
        for(Effect anEffect : weapon.getAllEffects()){
            applicateEffect(anEffect);
        }
    }
  
    /**
     * Unequip weapon. When unequip, remove all effects related.
     * @param bag
     */
    public void unequipWeapon(Bag bag){
        if(this.weapon == null){
            //System.out.println("\nAucune arme équipée !");
        }
        //remove effects
        for(Effect anEffect : weapon.getAllEffects()){
            removeEffect(anEffect);
        //unequip
        this.weapon.equiped = false;
        bag.addItem(this.weapon);
        this.weapon=null;
        }
    }
    
    /**
     * Equip the character with an armor. When equip it, apply all effects of the armor to him.
     * @param armorItem the armor to equip
     */
    public void equipArmor(model.Items.ArmorItem armorItem, Bag bag){
        if(this.armor != null){
            unequipArmor(bag);
        }
        //equip
        this.armor = armorItem; 
        this.armor.equiped = true;
        //apply effects
        for(Effect anEffect : armor.getAllEffects()){
            applicateEffect(anEffect);
        }
    }
    
    /**
     * Unequip armor. When unequip, remove all effects related.
     * @param bag
     */
    public void unequipArmor(Bag bag){
        if(this.armor == null){
            //System.out.println("\nAucune armure équipée !");
        }
        //remove effects
        for(Effect anEffect : armor.getAllEffects()){
            removeEffect(anEffect);
        //unequip armor
        this.armor.equiped = false;
        bag.addItem(this.armor);
        this.armor=null;   
        }
    }
    
    private int calcMaxHealth(){
        if(this.characteritics.containsKey(Characteristic.HEALTH)){
            return this.characteritics.get(Characteristic.HEALTH);
        }
        return 50;
    }
    
    /**
     * Initialize all skills of the character. 
     * For the moment, each character has an attack, a heal and a parade skill.
     */
    public void initSkills(){
        this.skills = new LinkedList<>();
        this.skills.add(new model.Skills.AttackSkill());
        this.skills.add(new model.Skills.HealSkill());
        this.skills.add(new model.Skills.ParadeSkill());
    }
    
    /**
     * Get all skills of the character
     * @return a list of skill
     */
    public List<Skill> getSkills(){
        return this.skills;
    }
    
    /**
     * Get the name of the character
     * @return the name of the character
     */
    public String getName() {
        return name;
    }

    /**
     * Get the level of the character
     * @return the level of the character
     */
    public Level getLevel() {
        return level;
    }

    /***
     * Return the current life of the character. 0 if he is dead.
     * @return the current life of the character
     */
    public int getActualLife() {
        return actualLife;
    }
    
    /**
     * Get the max health of the character. 
     * @return the max health of the character
     */
    public int getMaxHealth(){
        return this.maxHealth;
    }

    /**
     * Get the current equiped weapon
     * @return the weapon of the character
     */
    public WeaponItem getWeapon() {
        return weapon;
    }

    /**
     * Get the current equiped armor
     * @return the armor of the character
     */
    public ArmorItem getArmor() {
        return armor;
    }

    /**
     * Get all characteristics of the character
     * @return a map of characteristic with thei values
     */
    public Map<Characteristic, Integer> getCharacteritics() {
        return characteritics;
    }
    
    /**
     * Increase a characteristic of the character
     * @param charac the characteristic to increase
     */
    public void increaseCharacteristic(model.Characteristic charac){
        int val  = this.characteritics.getOrDefault(charac, 0);
        this.characteritics.replace(charac, val+1);
    }

    /**
     * Get all effects apply on the character
     * @return a list of effect
     */
    public List<Effect> getEffects() {
        return effects;
    }
    
    /**
     * Abstract method to get the class of the character
     * @return the class name of the character
     */
    public abstract String getClassName();
    
    /**
     * Kind of ToString method
     * @return a basic description of the character
     */
    public String getBasicDescription(){
        String description = "";
        
        description += "Nom: " + this.name + "\n";
        description += "Classe: " + this.getClassName() + "\n";
        description += "Vie: " + this.actualLife + "/" + this.maxHealth + "\n"; 
        description += "Niveau: " + level.getLevelValue();
        
        return description;
    }
    
    /**
     * Add half of missing life to the character
     */
    public void regainLife(){
        int lifeLeft = this.getMaxHealth()-this.getActualLife();
        int lifeToAdd = lifeLeft /2;
        
        this.applicateEffect(new Effect(model.Characteristic.LIFE, lifeToAdd, 0));
        
    }
}
