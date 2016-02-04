package view.Item;

import model.Bag;
import utils.KeyboardInput;
import view.HUD;

/***
 * View that manage the error when we try to add an item in the bag and it's not possible. 
 * Give to the controller the item to delete instead of the new one. 
 */
public class ErrorItemView implements HUD {
    
    private final Bag bag;
    private String itemToDelete;
    
    /**
     *
     * @param bag
     */
    public ErrorItemView(Bag bag){
        this.bag = bag;
    }

    /**
     *
     */
    @Override
    public void loadHUD() {
        System.out.println("\nL'objet ne peux pas être ajouté au sac à dos car il est déjà plein !");
        System.out.println("\nQuel objet souhaitez-vous laisser sur place ?");
        System.out.println("(Saisir -1 si vous ne souhaitez pas supprimer d'objet et laisser le trésor ici)");
        
        int i = 1;
        for(model.Item o: bag.allItems){
            System.out.print( i + ":" + o.getName());
            
            if(o.equiped){
                System.out.println(" qui est équipé.");
            }else
            {
                System.out.println();
            }
            i++;
        }
        do{
            itemToDelete = KeyboardInput.getInput();
        }while(!isValid());
    }

    /**
     *
     * @return
     */
    @Override
    public Object getResponse() {
        if(itemToDelete.equals("-1")) {
            return "-1";
        }
        try{
            return bag.allItems.get(Integer.parseInt(itemToDelete) -1);
        }catch(Exception e){
            
        }
        return null;
    }
    
    private boolean isValid(){
        if(!utils.Validator.checkEmpty(itemToDelete)){
            return false;
        }
        int i = 0;
        if(!utils.Validator.checkIsInteger(itemToDelete)){
            return false;
        }
        try{
            i = Integer.parseInt(itemToDelete);         
        }catch(Exception e){
        }        
        if(i == -1) {
            return true;
        }
        
        if(!utils.Validator.checkRange(i, 0, bag.allItems.size())){
            return false;
        }        
        
        return true;
    }

}
