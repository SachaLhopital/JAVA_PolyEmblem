package model.Skills;

import model.Skill;
import model.Personnage;
import model.Effect;

/**
 * Heal skill
 * @author Lafaye, Lhopital, Paccaud
 */
public class HealSkill implements Skill {

    /**
     * Heal 
     * @param srcCharacter the character who heal
     * @param targetCharacter the target of the heal
     * @return a constante to know if the ability was correctly use or not 
     */
    @Override
    public int useAbility(Personnage srcCharacter, Personnage targetCharacter) {
        model.Items.WeaponItem weapon = srcCharacter.getWeapon();
  
        //test si l'action est success
        if(Math.random() > this.successProbability(srcCharacter)){
            return PROBABILITY_FAIL;
        }
        int heal = 0;
        if(weapon!= null){
            //on calcul le soin de l'arme 
            heal += weapon.getHeal();                
        }
        
        targetCharacter.applicateEffect(new Effect(model.Characteristic.LIFE, heal,1));
        return SUCCES;
    }

    /**
     * Counting the success probability for heal
     * @param srcCharacter the character who heal
     * @return the success probability
     */
    @Override
    public double successProbability(Personnage srcCharacter) {
        return  0.9;
    }

    /**
     * Get the skill name
     * @return "Soin"
     */
    @Override
    public String getName() {
        return "Soin";
    }
    
}
