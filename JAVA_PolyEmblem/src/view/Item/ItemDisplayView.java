package view.Item;

import utils.KeyboardInput;
import model.Item;
import utils.Validator;
import view.HUD;

/**
 * View that display details of an item. 
 * Give to the controller the action to do next 
 * (i.e : go back to the main menu OR Equip the item and go back to the main menu)
 */
public class ItemDisplayView implements HUD {
    
    private final Item item;
    private String enteredText;
    
    /**
     *
     * @param itemToDisplay
     */
    public ItemDisplayView(Item itemToDisplay){
        this.item = itemToDisplay;
    }

    /**
     *
     */
    @Override
    public void loadHUD() {
        System.out.println("\n----------------------------------------");
        System.out.println("--------- Details de l'objet -----------");
        System.out.println("----------------------------------------");
        System.out.println(item.getDescription());
        
        enteredText = "0";
    }

    /**
     *
     * @return
     */
    @Override
    public Object getResponse() {
        do{
            System.out.println("(Appuyez sur 0 si vous souhaitez revenir au menu principal) ");
            /* If the item is equipable */
            if(item.getClass().toString().equals("class model.Items.ArmorItem")
                    || item.getClass().toString().equals("class model.Items.WeaponItem")) {

                /* If the item is not equiped */
                if(item.equiped == false) {

                    System.out.println("(Appuyez sur 1 si vous souhaitez équiper cet objet)");
                }
            } else { /* Edible item */
                
                System.out.println("(Appuyez sur 1 si vous souhaitez consommer cet objet)");
            }
            
            enteredText = KeyboardInput.getInput();
            
        } while(!isValid());
        
        int val = Integer.parseInt(enteredText);
        return val;
    }
    
    boolean isValid(){
        boolean valid = true;
        
        valid = valid & Validator.checkEmpty(enteredText);
        if(!valid){
            return valid;
        }
        valid = valid & Validator.checkIsInteger(enteredText);
        if(!valid){
            return valid;
        }
        
        return valid & Validator.checkRange(Integer.parseInt(enteredText), 0, 1);
    }
    
}
