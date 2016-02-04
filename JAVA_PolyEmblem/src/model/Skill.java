package model;

/**
 * Interface to implement skills
 * @author Lafaye, Lhopital, Paccaud
 */
public interface Skill {
    
    public static final int SUCCES = 1;
    public static final int CRITICAL_SUCCES = 2;
    public static final int PROBABILITY_FAIL = -1;
    public static final int CANNOT_ATTACK_FAIL = -2;
    public static final int DODGE_FAIL = -3;
    
    /**
     * Execute the skill
     * @param srcCharacter the character who use the skill
     * @param targetCharacter the target of the skill
     * @return a constante to know if the ability was correctly use or not
     */
    int useAbility(Personnage srcCharacter, Personnage targetCharacter);
    
    /**
     * Counting the success probability of the skill
     * @param srcCharacter the character who use the skill
     * @return the probability of success
     */
    double successProbability(Personnage srcCharacter);
    
    /**
     * Get the name of the skill
     * @return the name of the skill
     */
    public String getName();
}
