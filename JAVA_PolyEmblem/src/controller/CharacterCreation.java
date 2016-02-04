package controller;

import java.util.ArrayList;
import java.util.List;
import model.Personnage;
import view.Personnage.PersonnageNomView;
import view.Personnage.PersonnageClasseView;
import view.Personnage.PersonnageDisplayView;

/***
 * Helper for create the player team. 
 * @author Lafaye, Lhopital, Paccaud
 */
public class CharacterCreation {
    
    /* Max number of characters in the team */
    private static final int NUMBER_OF_CHARACTERS = 3;
    
    /***
     * Start the helper for create the team. 
     * Asks the player (using PersonnageClasseView) to generate characters.
     * @return all created characters (as list)
     */
    public static List<Personnage> start(){
        ArrayList<Personnage> players = new ArrayList<>();
        for(int i = 0 ; i< NUMBER_OF_CHARACTERS; i++){
            PersonnageNomView nom = new PersonnageNomView();
            nom.loadHUD();
            PersonnageClasseView classe = new PersonnageClasseView();
            classe.loadHUD();            
            switch(classe.getResponse()){
                case "GBM":
                    players.add(new model.Classes.Gbm(nom.getResponse()));
                    break;
                case "INFO":
                    players.add(new model.Classes.Info(nom.getResponse()));
                    break;
                case "MAM":
                    players.add(new model.Classes.Mam(nom.getResponse()));
                    break;
                case "MAT":
                    players.add(new model.Classes.Mat(nom.getResponse()));
                    break;
                case "MECA":
                    players.add(new model.Classes.Meca(nom.getResponse()));
                    break;
                default:
                    //DO Nothing
                    //The player loose a character
            }
            new PersonnageDisplayView(players).loadHUD();            
        }
        return players;
    }
}
