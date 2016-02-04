package view.Personnage;

import model.Personnage;
import view.HUD;

/**
 * View that manage xp curve and level stuff for the player 
 * @author Lafaye, Lhopital, Paccaud
 */
public class XpView implements HUD {
    
    private final Personnage personnage;
    
    /**
     * 
     * @param perso
     */
    public XpView(Personnage perso) {
        this.personnage = perso;
    }

    @Override
    public void loadHUD() {
        System.out.println(personnage.getName()+ " est niveau " + personnage.getLevel().getLevelValue());
        System.out.println("XP : " + personnage.getLevel().getExp() 
                + " / " + personnage.getLevel().getStep()); 
    }
    
    /**
     * Display the xp status at the end of the fight 
     * @param xp the xp value earned
     */
    public void showXpStatus(int xp) {
       System.out.println(personnage.getName() + " a gagné : " + xp + "xp");
    }
    
     /**
     *  Display the level up to the player
     */
    public void showLevelUp() {
        System.out.println("\n " + personnage.getName() + " a LEVEL UP !");
    }
    

    @Override
    public Object getResponse() {
        return null;
    }    
}
