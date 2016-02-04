package view.Item;

import model.Bag;
import model.Item;
import utils.KeyboardInput;
import view.HUD;

/**
 * View that manage the bag of the player.
 * Give to the controller the action to do next 
 * (i.e : an item to display OR go back to the main menu).
 */
public class SelectItemView implements HUD{

    private final Bag bag;
    private String enteredText;
    
    /**
     *
     * @param bag
     */
    public SelectItemView(Bag bag){
        this.bag = bag;
    }
    
    /**
     *
     */
    @Override
    public void loadHUD() {

        System.out.println("----------------------------------------");
        System.out.println("-------- Contenu de vos sacs ----------");
        System.out.println("----------------------------------------");
        System.out.println("Choisissez un objet pour voir son détail : ");
        System.out.println("(Appuyez sur 0 pour revenir au menu principal)");
        
        int i = 1;
        for(Item o: bag.allItems){
            System.out.print( i + ":" + o.getName());
            
            if(o.equiped){
                
                System.out.println(" est équipé.");
            } else {
                System.out.println();
            }
            i++;
        }
        do{
            enteredText = KeyboardInput.getInput();
        }while(!isValid());
    }

    /***
     * Show the confirmation message when adding to the bag. Then go back to the 
     * SelectItem global menu.
     */
    public void canAddItem() {
        System.out.println("\nL'objet a correctement été ajouté au sac à dos !");
        loadHUD();
    }

    /**
     * Show the confirmation message when the item have been equiped.
     */
    public void haveEquiped(){
        System.out.println("\nL'objet a été équipé !");
    }
    
    
    /**
     *
     * @return
     */
    @Override
    public Object getResponse() {
        int i = 0;
        try{
            i = Integer.parseInt(enteredText);
        }catch(Exception e){    
        }
        if(i==0){
            return 0;
        }
        else{
            return bag.allItems.get(i -1);
        }
    }
    
    private boolean isValid(){
        if(!utils.Validator.checkEmpty(enteredText)){
            return false;
        }
        int i =0;
        if(!utils.Validator.checkIsInteger(enteredText)){
            return false;
        }
        try{
            i = Integer.parseInt(enteredText);         
        }catch(Exception e){
        }
        
        if(!utils.Validator.checkRange(i, 0, bag.allItems.size())){
            return false;
        } 
        return true;
    }
    
}
