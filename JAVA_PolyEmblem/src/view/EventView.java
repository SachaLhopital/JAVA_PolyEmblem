package view;

import controller.FightController;
import controller.ItemController;
import java.util.List;
import model.Bag;
import utils.KeyboardInput;
import model.Event.DiscoverPlaceEvent;
import model.Event.FightEvent;
import model.Events;
import model.IA.IAPersonnage;
import model.Personnage;

/**
 * View that manage the main menu of the game. 
 * Give to the controller the next action of the player.
 */
public class EventView implements HUD {
    
    private static final int NB_OPTIONS = 6;
    
    private final Bag bag;
    private final List<Personnage> allPlayers;
    private String nextAction;
    
    /**
     * Constructor 
     * @param bag the bag of the player's team
     * @param allPlayers the list of all player's characters 
     */
    public EventView(Bag bag, List<Personnage> allPlayers){
        this.bag = bag;
        this.allPlayers = allPlayers;
    }
    
    /**
     *
     */
    @Override 
    public void loadHUD() {
        System.out.println("\nQuelle est votre prochaine action ?");
        System.out.println("\n1 : Poursuivre ma route "
                            + "\n2 : Voir le contenu du sac"
                            + "\n3 : Voir les détails de mon personnage"
                            + "\n4 : Charger une partie déjà existante"
                            + "\n5 : Sauvegarder"
                            + "\n6 : Quitter" );

        do{
            nextAction = KeyboardInput.getInput();
        }while(!isValid());
    }
    
    private boolean isValid(){
        if(!utils.Validator.checkEmpty(nextAction)){
            return false;
        }
        int i = 0;
        try{
            i = Integer.parseInt(nextAction);         
        }catch(Exception e){
        }
        if(!utils.Validator.checkRange(i, 1, NB_OPTIONS)){
            return false;
        }
        return true;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String getResponse() {
        return nextAction;
    }

    /***
     * Display to the player an event and redirects to the proper controller.
     * @param currentEvent the event to display
     */
    public void showPlayer(Events currentEvent) {
        System.out.println("\n----------------------------------------");
        System.out.println("------ Un Evènement se produit ! -------");
        System.out.println("----------------------------------------");
        System.out.println("\n" + currentEvent.getDescriptionEvent() + "\n");
        
        if(currentEvent.getClass() == DiscoverPlaceEvent.class) {
            
            DiscoverPlaceEvent event = (DiscoverPlaceEvent) currentEvent;
            ItemController itemController = new ItemController();
            
            System.out.println("Vous trouvez : " + event.getTreasure().getName() 
                    + ". \n" + event.getTreasure().getDescription());     
            
            itemController.itemFound(event.getTreasure(), bag, allPlayers); 
            
        } else if(currentEvent.getClass() == FightEvent.class){
            
            FightEvent event = (FightEvent) currentEvent;
            FightController fightController = new FightController();
            
            for(IAPersonnage badGuy : event.getAllBadGuys()) {
                System.out.println(badGuy.getPersonnage().getName() + " "); 
            }
            
            if(event.getAllBadGuys().size() == 1) {
                System.out.println("veux se battre !"); 
            } else {
                System.out.println("veulent se battre !"); 
            }
            
            fightController.runTheFight(allPlayers, event.getAllBadGuys());
        }
        //System.out.println("----------------------------------------");
    }
}
