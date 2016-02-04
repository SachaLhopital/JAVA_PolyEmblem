package view.Personnage;

import utils.KeyboardInput;
import view.HUD;

/**
 * View that manage the name of the character when created.
 * Give to the controller the name choosen.
 */
public class PersonnageNomView implements HUD{

    private String nom;

    /**
     *
     */
    @Override
    public void loadHUD() {
        System.out.println("\nVeullez entrez votre nom de personnage.");
        do{
            nom = KeyboardInput.getInput();         
            if(nom.isEmpty()){
                System.out.println("Le nom est vide, veuillez le reentrer.");
            }
        }while(nom.isEmpty());
        
    }

    /**
     *
     * @return
     */
    @Override
    public String getResponse() {
        return nom;
    }
}
