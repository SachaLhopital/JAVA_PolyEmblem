package controller;

import java.util.LinkedList;
import java.util.List;
import model.Bag;
import model.Characteristic;
import model.Classes.Info;
import model.Classes.Mam;
import model.Classes.Meca;
import model.Effect;
import model.Event.DiscoverPlaceEvent;
import model.Event.FightEvent;
import model.Events;
import model.IA.IAPersonnage;
import model.Item;
import model.Items.ArmorItem;
import model.Items.EdibleItem;
import model.Items.WeaponItem;
import model.Level;
import model.Personnage;
import view.EndOfGameView;
import view.EventView;
import view.Item.ItemDisplayView;
import view.Personnage.PersonnageDisplayView;
import view.Item.SelectItemView;

/***
 * Main Controller : Run the game !
 * @author Lafaye, Lhopital, Paccaud
 */
public class StoryController {

    /* Map with all events of the story and booleans. For each event, the boolean is setup at false.
    * It becomes true when the event is playing by the player. */
    private static List<Events> event;
    
    /***
     * Generate all events for the game.
     */
    public static void generateEvents() {
        
        event = new LinkedList<>();
        
        //TODO : add story events here
        
        event.add(new DiscoverPlaceEvent("En route vers Polytech, votre très chère école,"
                + " vous vous retrouvez au milieu de tous les autres étudiants du campus"
                + "\nde l'université Lyon 1 dans le Tram menant à Condorcet. "
                + "\nIls sentent la transpiration et l'alcool, ce qui ne vous gêne pas beaucoup... "
                + "\nSerré contre la porte, vous distinguez un paquet de tic tac au sol."
                + "\nVous vous appretez à le saisir lorsque la voix suave du tram annonce votre arrêt :"
                + "\nVous vous jetez dessus et passez la porte pile à temps. "
                + "\nUne chance qu'il reste des tics tacs dans la boite...",
                new EdibleItem("Boite de tic tac entamée", 1, 
                        new Effect(Characteristic.STRENGHT, -1, 0),
                        new Effect(Characteristic.HEALTH, 2, 0))));
        
        event.add(new FightEvent("Heureux de cette nouvelle découverte,"
                + "vous ne sentez pas tout de suite cette main moite qui se pose "
                + "fermement sur votre épaule.\nC'est Charlie (aka le Kaid), un voyou "
                + "en Mécanique, qui sème la terreur et le chaos dans tout le réseau."
                +"\nVous sentez dans son regard la haine qu'il éprouve pour vous : "
                +"\n- Ce sont mes tic tac, vermine."
                + "\nIl est facilement reconnaissable à son poly'acoutrement : un t-shirt bordeaux, un jean délavé et une casquette qui arborent fièrement le P lyonnais."
                + "\nMais il est en colère et il va falloir vous battre pour conserver votre précieux butin...",
                new IAPersonnage(new Meca("Charlie le Kaid",new Level(3)),1)));
        
        event.add(new DiscoverPlaceEvent("C'est une première victoire qui vous fait chaud au coeur."
                + "\nVous éprouvez une sincère satisfaction en voyant Charlie fuir vers le batîment Istil."
                + "\nMais vous êtes encore plus joyeux quand vous remarquez que dans sa fuite, il a oublié sa casquette..."
                + "\nVous la saisissez, et lorsque vous la mettez, vous entendez un battement d'ailes au-dessus des arbres."
                + "\nVous levez les yeux et vous distinguez la silhouette d'un membre du BDE qui accroche une affiche sur un prochain évènement alcoolisé."
                + "\n 'AFTERWORK à l'OxxO' qu'il est écrit, d'une écriture rose paillette."
                + "\nEnfin une bonne nouvelle !",
                new ArmorItem("Poly'casquette", 10, 2)));
        
        event.add(new DiscoverPlaceEvent("Vous êtes à peine rentré dans le hall du batîment ISTIL lorsque vous entendez des cris et des bruits semblables au fracas du tonnerre."
                + "\nEn vous approchant, près de la machine à café située sous l'escalier, "
                + "vous apercevez bientôt un groupe d'étudiants que vous connaissez bien."
                + "\nVos cinq amis (car oui, ce sont vos amis) sont en train de discuter autour d'un boisson chaude."
                + "\nIl y a Mélanie qui semble très pressée, accompagnée d'Ophélie. Elles discutent sur un sujet inaudible pour le moment."
                + "\nJuste à côté, Yoan, Benoit et Laura touillent tous leur café dans le même sens."
                +"\n(Notez que vous êtes suffisamment intelligent pour ne remarquer que ca, la rotation des touillettes dans le même sens...)" 
                + "\nLorsque vous vous approchez, Yoan vous tend un cahier de mathématique : "
                + "\n- Coucou ! Cha va ? Tu pourras rendre son cahier de maths à Pierre-Yves quand tu le verras ?", 
                new WeaponItem("Cahier de mathématiques très Rigide", 15, 4, 1, new Effect(Characteristic.INTELIGENCE, 1, -1))));
        
        event.add(new FightEvent("\n-Yup. La machine à café fonctionne ?"
                + "\n-Oui oui."
                + "\nVous sortez votre carte iZly de votre poche de jean arrière droite (c'est précis) et la posez sur le lecteur de carte de la machine"
                + "\nEt là, c'est le drame :"
                + "\n ERROR CARTE INCONNUE."
                + "\nMais malgré votre obstination et les essais répétés, elle ne veux rien savoir !"
                + "\nEncore un essais et vous êtes à bout de nerf...",
                new IAPersonnage(new Info("La Machine à café machiavélique",new Level(4)),2)));
        
        event.add(new FightEvent("\nVotre rage est encore là, même si vous lui avez bien réglé son compte."
                + "\n-EH VOUS Là !"
                + "\nVous vous retournez dans un sursaut. Qui ose venir vous importuner alors que vous n'avez pas eu votre café !??!"
                + "\nLa secrétaire chargée des approvisionnements en caféine de l'école s'approche de vous, furax."
                + "\n-Qui vous a permis de toucher à cette machine ? Petit malotru !"
                + "\nC'est plus qu'il ne vous en faut pour imploser !",
                new IAPersonnage(new Info("La Machine à café machiavélique",new Level(4)),2),
                new IAPersonnage(new Mam("La Secrétaire furax",new Level(8)),2)));
        
    }
    
    /***
     * Run the game. For each event (and as long as the event has not occurred),
     * display to the player the global menu. Call the correct view for each action
     * possible. At the end of the game, display the winning view.
     * @param allPlayers a list of all characters of the player
     */
    public static void runTheGame(List<Personnage> allPlayers) {
        
        Bag bag = new Bag(allPlayers);
        
        for(Events currentEvent : event) {
            
            while(currentEvent.isDone == false) {
                
                EventView eventView = new EventView(bag, allPlayers);
                eventView.loadHUD();

                switch(Integer.parseInt(eventView.getResponse())){
                    
                    case 1 : /* Execute the next event of the story */
                        eventView.showPlayer(currentEvent);
                        currentEvent.isDone = true;
                        break;
                        
                    case 2 : /* Manage the bag */
                        SelectItemView bagView = new SelectItemView(bag);
                        bagView.loadHUD();
                        if(bagView.getResponse().getClass().toString().equals("class java.lang.Integer")) {
                            //Do nothing, go back in the main menu
                        } else {
                            ItemController itemController = new ItemController();
                            itemController.manageItem((Item) bagView.getResponse(), bag, allPlayers);
                        }
                        break;
                        
                    case 3 : /* Display characters details */
                        PersonnageDisplayView playerView = new PersonnageDisplayView(allPlayers);
                        playerView.loadHUD();
                        break;
                        
                    case 4 : /* Load a game */
                        //TODO
                        break;
                        
                    case 5 : /* Save the game */ 
                        //TODO
                        break;
                        
                    case 6 : /* Exit */
                        System.exit(0);
                        break;
                        
                    default: /* Show the main menu */
                        eventView.loadHUD();
                }
            }
        }
        
        EndOfGameView.loadWinnerEnding();
    }    
}
