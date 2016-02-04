package view.Fight;

import utils.KeyboardInput;
import java.util.List;
import model.IA.IAPersonnage;
import model.Personnage;
import view.HUD;

/**
 * View that manage the target of a fight.
 * Give to the controller the target choosen.
 */
public class CombatOpponentChoiceView implements HUD{
    
    private final List<IAPersonnage> opponents;
    private String enteredText;
    private final Personnage actualPersonnage;

    /**
     *
     * @param actualPersonnage
     * @param opponents
     */
    public CombatOpponentChoiceView(Personnage actualPersonnage, List <IAPersonnage> opponents){
        this.opponents = opponents;
        this.actualPersonnage = actualPersonnage;
    }
    
    /**
     *
     */
    @Override 
    public void loadHUD() {
        System.out.println("\nAu tour de " + actualPersonnage.getName());
        System.out.println("Veuillez choisir le personage à attaquer:");
        int i = 1;
        for(IAPersonnage p:opponents){
            System.out.println(i + ":" + p.getPersonnage().getBasicDescription());
            i++;
        }
        do{
            enteredText = KeyboardInput.getInput();            
        }while(!isValid());
    }

    /**
     *
     * @return
     */
    @Override
    public Personnage getResponse() {
        try{
            return opponents.get(Integer.parseInt(enteredText) -1).getPersonnage();
        }catch(Exception e){
            
        }
        return null;
    }
    
    private boolean isValid(){
        if(!utils.Validator.checkEmpty(enteredText)){
            return false;
        }
        int i = 0;
        if(!utils.Validator.checkIsInteger(enteredText)){
            return false;
        }
        try{
            i = Integer.parseInt(enteredText);         
        }catch(Exception e){
        }
        
        if(!utils.Validator.checkRange(i, 1, opponents.size())){
            return false;
        }   
        
        return true;
    }
    
}
