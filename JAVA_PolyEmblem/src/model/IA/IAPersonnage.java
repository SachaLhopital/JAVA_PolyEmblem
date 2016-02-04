
package model.IA;

import java.util.List;
import model.Skill;

/**
 * Create an AI for a PNJ. There is two "level" of AI : 
 *  an easy one who only attack a random character
 *  a hard one who attack and heal a selected character
 * @author Lafaye, Lhopital, Paccaud
 */
public class IAPersonnage{

    private final int LEVEL_IA_MAX = 2;
    private final int LEVEL_IA_MIN = 1;
    private final model.Personnage personnage;
    private int levelIA;
    
    private String lastAction;
    
    /**
     * Constructor
     * @param personnage the PNJ
     * @param levelIA the level of the AI
     */
    public IAPersonnage(model.Personnage personnage, int levelIA) {
        this.personnage = personnage;
        if(levelIA<LEVEL_IA_MIN){
            levelIA = LEVEL_IA_MIN;
        }else if(levelIA>LEVEL_IA_MAX){
            levelIA = LEVEL_IA_MAX;
        }else{
            this.levelIA = levelIA;
        }        
    }
    
    /**
     * Get the skill of the AI
     * @return a skill
     */
    public model.Skill getSkill(){
        model.Skills.AttackSkill attack = null;
        model.Skills.HealSkill heal = null;
        
        List<Skill> skills  = this.personnage.getSkills();
        for(Skill s:skills){
            if(s instanceof model.Skills.AttackSkill){
                attack = (model.Skills.AttackSkill)s;
            }
            
            if(s instanceof model.Skills.HealSkill){
                heal = (model.Skills.HealSkill)s;
            }
        }
        
        if(levelIA == 1){
            return attack;
        }
        
        if(levelIA == 2){
            if (personnage.getActualLife()> personnage.getMaxHealth()/2){
                lastAction = "heal";
                return heal;
            }
            else{
                return attack;
            }
        }
        return null;
    }
    
    /**
     * Get the target of the AI. A target is one of the player character who is steal alive
     * @param potentialTarget the list of all characters of the player
     * @param IAs the list of all others PNJ who fight with the current AI.
     * @return a target
     */
    public model.Personnage getTarget(List<model.Personnage> potentialTarget, List <IAPersonnage> IAs){
        //si on heal
        if(this.lastAction == "heal"){
            lastAction = "";
            model.Personnage target = IAs.get(0).personnage;
            for(IAPersonnage ia : IAs){
                if(target.getActualLife()> ia.personnage.getActualLife()){
                    target = ia.personnage;
                }
            }
            return target;
        }
    
        //choisis de maniere random
        if(levelIA == 1){
            double random = (Math.random()*potentialTarget.size());
            return potentialTarget.get((int)random);            
        }
        
        //choisi de maniere inteligente
        if(levelIA == 2){
            model.Personnage target = potentialTarget.get(0);
            for(model.Personnage p : potentialTarget){
                if(target.getActualLife()> p.getActualLife()){
                    target = p;
                }
            }
            return target;
        }
        return null;
    }
    
    /**
     * Get the character associate with the current AI
     * @return the character
     */
    public model.Personnage getPersonnage(){
        return personnage;
    }
}

