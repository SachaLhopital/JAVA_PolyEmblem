package view.Fight;

import java.util.List;
import view.HUD;
import model.IA.IAPersonnage;
import model.Personnage;

/**
 * View that display the details of a fight.
 */
public class RoundView implements HUD{

    private final List<model.Personnage> players;
    private final List<model.IA.IAPersonnage> badGuys;
    
    /**
     *
     * @param players
     * @param badGuys
     */
    public RoundView(List<model.Personnage> players,List<model.IA.IAPersonnage> badGuys){
        this.players = players;
        this.badGuys = badGuys;
    }
    
    /**
     *
     */
    @Override
    public void loadHUD() {
        System.out.println("\n-------------------------------------------");
        System.out.println("-------- Un combat est en cours -----------");
        System.out.println("-------------------------------------------");
        
        System.out.println("Il oppose votre équipe aux méchants");
        
        System.out.println("Votre équipe se compose de:");
        for(model.Personnage p:players){
            System.out.println(p.getBasicDescription());
        }
        
        System.out.println("L'équipe adverse se compose de:");
        for(model.IA.IAPersonnage p:badGuys){
            System.out.println(p.getPersonnage().getBasicDescription());
        }
    }
    
    /**
     *
     * @param source
     * @param target
     */
    public static void IAAttackDisplay(IAPersonnage source, Personnage target){
        System.out.println("-------------------------------------------");
        System.out.println(source.getPersonnage().getName()+ " attaque "+ target.getName());
        System.out.println("-------------------------------------------");
    }
    
    /**
     *  Display the end of the fight. It only appends when the player wins the fight. 
     */
    public static void showWinnerEnding() {
       System.out.println("----------------------------------------");
       System.out.println("\n Félicitation !");
       System.out.println("\n Vous avez tout déchiré !");
    }

    /**
     *
     * @return
     */
    @Override
    public Object getResponse() {
        return null;
    }
    
}
