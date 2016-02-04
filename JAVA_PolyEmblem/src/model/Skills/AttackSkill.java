package model.Skills;

import model.Skill;
import model.Personnage;
import model.Effect;

/**
 * Attack skill
 * @author Lafaye, Lhopital, Paccaud
 */
public class AttackSkill implements Skill {

    /**
     * Attack !
     * @param srcCharacter the character who attack
     * @param targetCharacter the target
     * @return a constante to know if the ability was correctly use or not
     */
    @Override
    public int useAbility(Personnage srcCharacter, Personnage targetCharacter) {
        model.Items.WeaponItem weapon = srcCharacter.getWeapon();
        
        int damages = 0;
            
        //Test si c'est un Mat fatigué
        if(srcCharacter instanceof model.Classes.Mat){
            model.Classes.Mat m = (model.Classes.Mat)srcCharacter;
            if(m.isTired()){
                m.setTired(false);
                return CANNOT_ATTACK_FAIL;
            }
            m.setTired(true);
        }
        
        //test si l'action est success
        if(Math.random() > this.successProbability(srcCharacter)){
            return PROBABILITY_FAIL;
        }   
            
        //Dégats en fonction de l'inteligence pour les mages
        if(srcCharacter instanceof model.Classes.Gbm || srcCharacter instanceof model.Classes.Mam){
            damages += srcCharacter.getCharacteritics().getOrDefault(model.Characteristic.INTELIGENCE,0);
                
            //On reduit les degat de la defence
            damages -= targetCharacter.getCharacteritics().getOrDefault(model.Characteristic.DEFENCE,0);
            
            //On évite les dégats négatifs...
            if(damages<1)
                damages = 1;
             
            //on applique l'effet
            targetCharacter.applicateEffect(new Effect(model.Characteristic.LIFE, -damages,1));
            
            //On n'esquive pas une attaque magique !
            return SUCCES;
        }
            
        if(weapon!= null){
            //on calcul les degats de l'arme 
            damages += weapon.getDamage();                
        }
        //On ajoute les degats de force
        damages += srcCharacter.getCharacteritics().getOrDefault(model.Characteristic.STRENGHT,0);
            
        //On reduit les degat de la defence
        damages -= targetCharacter.getCharacteritics().getOrDefault(model.Characteristic.DEFENCE,0);
           
            
        //on retire les effets d'armure
        model.Items.ArmorItem armor = targetCharacter.getArmor();
        if(armor!= null){
            //on reduit les dégats par la protection
            damages -= armor.getProtection();
        }
            
        //On évite les dégats négatifs...
        if(damages<1)
            damages = 1;
         
        //test de succes critique
        if(Math.random() < 0.05){
            //on inflige plus de degat            
            damages += damages;
            targetCharacter.applicateEffect(new Effect(model.Characteristic.LIFE, -damages,1));
            
            return CRITICAL_SUCCES;
        }
         
        //test d'esquive
        double dext = targetCharacter.getCharacteritics().get(model.Characteristic.DEXTIRITY)*0.02;
        if(Math.random() < dext){
            return DODGE_FAIL;
        }
        //on applique l'effet
        targetCharacter.applicateEffect(new Effect(model.Characteristic.LIFE, -damages,1));
            
        return SUCCES;
    }

    /**
     * Counting the success probability of the attack
     * @param srcCharacter the character who attack
     * @return the success probability
     */
    @Override
    public double successProbability(Personnage srcCharacter) {
        return 0.9;
    }

    /**
     * Get the skill name
     * @return "Attaque"
     */
    @Override
    public String getName() {
        return "Attaque";
    }
    
}
