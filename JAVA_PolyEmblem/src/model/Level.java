package model;

/**
 * Create a level for a character. 
 * @author lhopital
 */
public class Level {

    /**
     * Level max for a character
     */
    public static int MAXLEVEL=60;
    
    private int level;
    private int exp;
    private int step;
    
    /**
     * Constructor for a new character : level 1.
     */
    public Level(){
        level = 1;
        exp = 0;
        step = this.getStep();
    }
    
    /**
     * Constructor for an experimented character
     * @param lv the level of the character
     */
    public Level(int lv) {
        level = lv;
        exp = 0;
        step = this.getStep();
    }
    
    /**
     * Get the next value of xp to level up
     * @return the step before the next level
     */
    public int getStep(){
        return level * 50 +50;
    }
    
    /**
     * Add xp to the current level. If the step of the next level is reached : level up !
     * @param xp the xp gained
     * @return true if the character level up - false otherwise.
     */
    public boolean addXP(int xp){
        exp += xp;
        if(exp >= step){
            levelUp();
            return true;
        }
        return false;
    }
    
    private void levelUp(){
        level++;
        exp = 0;
        step = this.getStep();
    }
    
    /**
     * Get the level
     * @return the level
     */
    public int getLevelValue(){
        return level;
    }
    
    /**
     * Get the current xp
     * @return the value of the xp
     */
    public int getExp(){
        return exp;
    }
}
