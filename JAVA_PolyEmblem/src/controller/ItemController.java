package controller;

import java.util.List;
import model.Bag;
import model.Effect;
import model.Item;
import model.Items.ArmorItem;
import model.Items.WeaponItem;
import model.Personnage;
import view.Item.ErrorItemView;
import view.Item.ItemDisplayView;
import view.Item.SelectItemView;
import view.Personnage.PersonnageDisplayView;

/***
 * Controller for items : 
 * Manage the item found on a DiscoverPlaceEvent (and so manage the bag of the player)
 * @author Lafaye, Lhopital, Paccaud
 */
public class ItemController {

    /***
     * Arranges a treasure found in the bag
     * @param treasure the item to arrange
     * @param bag the team's bag
     */
    public void itemFound(Item treasure, Bag bag, List<Personnage> players) {
        
        SelectItemView itemView = new SelectItemView(bag);
        ItemDisplayView itemDisplayView = new ItemDisplayView(treasure);
        ErrorItemView errorItemView = new ErrorItemView(bag);
        
        boolean abandonTreasure = false;
        String treasureClass = treasure.getClass().toString();
        
        /* Try to put the item in the bag */
        while(bag.getActualInUseWeight() + treasure.getWeight() > bag.maxWeight) {
            errorItemView.loadHUD();
            
            try{
                int i = Integer.parseInt((String) errorItemView.getResponse());
                abandonTreasure = true;
                break;
            }catch(ClassCastException e){
                bag.removeItem((Item) errorItemView.getResponse());
            }
        }
        
        if(abandonTreasure) {
            //Do nothing, we leave the treasure
        } else {
            //equiper
            
            
            if(treasureClass.equals("class model.Items.ArmorItem")) {
                PersonnageDisplayView pdv = new PersonnageDisplayView(players);
                itemDisplayView.loadHUD();
                pdv.loadHUD();
                Personnage persoSelectionne = pdv.getResponse();
                if(persoSelectionne==null) {
                    //Do nothing : go back to the main menu
                } else {
                    persoSelectionne.equipArmor((ArmorItem) treasure, bag);
                    itemView.haveEquiped();
                    return;
                }
            }
        
            if(treasureClass.equals("class model.Items.WeaponItem")) {
                PersonnageDisplayView pdv = new PersonnageDisplayView(players);
                itemDisplayView.loadHUD();
                pdv.loadHUD();
                Personnage persoSelectionne = pdv.getResponse();
                if(persoSelectionne==null) {
                    //Do nothing : go back to the main menu
                } else {
                    persoSelectionne.equipWeapon((WeaponItem) treasure, bag);
                    itemView.haveEquiped();
                    return;
                }
            }
            
            //ajouter si il n'as pas été équipé
            bag.addItem(treasure);
            itemView.canAddItem();
            manageItemBag(bag, itemView, players);
        }   
    }

    /***
     * Manage the bag of the team. 
     * Displays items from the bag OR go back to the main menu 
     * @param bag the bag to display
     * @param itemView the SelectItem view
     * @param allPlayers all Players
     */
    private void manageItemBag(Bag bag, SelectItemView itemView, List<Personnage> allPlayers) {
        
        switch(itemView.getResponse().getClass().toString()) {
            
            case  "class java.lang.Integer" : /* Go back to the main menu */
                
                break;
            
            default : /* Display the item details */
                manageItem((Item) itemView.getResponse(), bag, allPlayers);
        }
    }

    /***
     * Display detail of an item and manage it (equip, unequip, use or do nothing) 
     * @param Item the item to manage
     * @param Bag the bag
     * @param allPlayers all players who can use this item
     */
    public void manageItem(Item item, Bag bag, List<Personnage> allPlayers) {
        ItemDisplayView itemDisplayView = new ItemDisplayView(item);
        itemDisplayView.loadHUD(); 
        
        int userChoice = (int)itemDisplayView.getResponse();
        
        if(userChoice == 0) {
            //do nothing, go back to the main menu
        } else {
            
            PersonnageDisplayView playersView = new PersonnageDisplayView(allPlayers);
            playersView.chooseAPlayer();
            Personnage persoSelectionne = playersView.getResponse();
            
            if(persoSelectionne==null) {
                   //do nothing
            } else {

                if(item instanceof ArmorItem) {
                    persoSelectionne.equipArmor((ArmorItem) item, bag);
                } else if(item instanceof WeaponItem) { 
                    persoSelectionne.equipWeapon((WeaponItem) item, bag);
                } else { //Edible item
                    for(Effect anEffect : item.getAllEffects()) {
                        persoSelectionne.applicateEffect(anEffect);
                    }
                    bag.removeItem(item);
                }
            }
        }
    }
    
}
