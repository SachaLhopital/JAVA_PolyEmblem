package view.Fight;

import utils.KeyboardInput;
import model.Personnage;
import utils.Validator;
import view.HUD;

/**
 * View that manage all actions possibles by the character in a fight.
 * Give to the controller the action choosen.
 */
public class CombatActionChoiceView implements HUD{
    
    private final Personnage personnage;
    private String enteredText;

    /**
     *
     * @param perso
     */
    public CombatActionChoiceView(model.Personnage perso){
        this.personnage = perso;
    }
    
    /**
     *
     */
    @Override 
    public void loadHUD() {
        System.out.println("\nVeuillez choisir une action à faire pendant ce tour pour " + personnage.getName() + " :");
        int i = 1;
        for(model.Skill s:personnage.getSkills()){
            System.out.println( i + ":" + s.getName());
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
    public model.Skill getResponse() {
        try{
            return personnage.getSkills().get(Integer.parseInt(enteredText) -1);
        }catch(Exception e){
            
        }
        return null;
    }
    
    private boolean isValid(){
        
        if(!Validator.checkEmpty(enteredText)){
            return false;
        }
        int i = 0;
        if(!Validator.checkIsInteger(enteredText)){
            return false;
        }
        try{
            i = Integer.parseInt(enteredText);
        }catch(Exception e){
            
        }
        if(!Validator.checkRange(i, 1, personnage.getSkills().size())){
            return false;
        }
        return true;
    }
}
