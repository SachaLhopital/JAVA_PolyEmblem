package model;

/**
 * Represent an Effect (on an item)
 * @author lhopital
 */
public class Effect {
    
    private Characteristic characteristicEffect;
    private int value;
    private int permanent;   
    
    /**
     * Constructor 
     * @param characteristicEffect the characteristic to impact (ex : HEALTH)
     * @param value the value of the effect (ex : +10)
     * @param permanent a number that represent the duration of the effet (-1 est permanent (à chaque tours), 0 ataque unique, 1,2,3... noubre de tours d'effet)
     */
    public Effect(Characteristic characteristicEffect, int value, int permanent) {
        this.characteristicEffect = characteristicEffect;
        this.value = value;
    }

    /**
     * Get the characteristic of the effect
     * @return the characteristic of the effect
     */
    public Characteristic getCharacteristicEffect() {
        return characteristicEffect;
    }

    /**
     * Get the value of the effect
     * @return the value of the effect
     */
    public int getValue() {
        return value;
    }
    
    /**
     * Decrement the value of permanent
     */
    public void decrementPermanent(){
        this.permanent--;
    }

    /**
     * Get the permanent value
     * @return the permanent value
     */
    public int getPermanent() {
        return permanent;
    }
    
    public String toString() {
        String effectString = "";
        if(value > 0) {
            effectString = "+";
        } 
        return effectString + value + " " + characteristicEffect.toString();
    }
}
