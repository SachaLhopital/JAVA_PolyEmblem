package view.Personnage;

import java.util.List;
import java.util.Map;
import model.Personnage;
import utils.KeyboardInput;
import utils.Validator;
import view.HUD;

/**
 * View that display in detail all characters of the player.
 */
public class PersonnageDisplayView implements HUD{

    private final List<Personnage> allPlayers;
    private String entry;
    
    /**
     *
     * @param allPlayers
     */
    public PersonnageDisplayView (List<Personnage> allPlayers){
        this.allPlayers = allPlayers;
    }

    /**
     *
     */
    @Override
    public void loadHUD() {

        System.out.println("------------------------------------------------------");
        System.out.println("-------- Fiche des Personnages de l'équipe -----------");
        System.out.println("------------------------------------------------------");
        
        int i = 0;
        for(Personnage aPlayer : this.allPlayers) {
            i++;
            System.out.println(i +") Nom: "+ aPlayer.getName());
            System.out.print("Classe: ");
            if(aPlayer instanceof model.Classes.Gbm){
                System.out.println("GBM");
            }else if(aPlayer instanceof model.Classes.Info){
                System.out.println("INFO");
            }else if(aPlayer instanceof model.Classes.Mam){
                System.out.println("MAM");
            }else if(aPlayer instanceof model.Classes.Mat){
                System.out.println("MAT");
            }else if(aPlayer instanceof model.Classes.Meca){
                System.out.println("MECA");
            }
            System.out.println("Points de Vie: "+ aPlayer.getActualLife() + "/" + aPlayer.getMaxHealth());

            //Level
            XpView playerXpView = new XpView(aPlayer);
            playerXpView.loadHUD();

            //Caracteristics
            System.out.println("--------- Caracteristiques -------------");
            Map <model.Characteristic,Integer> caract = aPlayer.getCharacteritics();       
            System.out.println("Force: "+ caract.getOrDefault(model.Characteristic.STRENGHT, 0));
            System.out.println("Defence: "+ caract.getOrDefault(model.Characteristic.DEFENCE, 0));
            System.out.println("Dextiritée: "+ caract.getOrDefault(model.Characteristic.DEXTIRITY, 0));
            System.out.println("Inteligence: "+ caract.getOrDefault(model.Characteristic.INTELIGENCE, 0));
            System.out.println("Vie: "+ caract.getOrDefault(model.Characteristic.HEALTH, 0));
            System.out.println("------------ Equipement ----------------");
            if(aPlayer.getWeapon()!=null){
                System.out.println("Arme: "+ aPlayer.getWeapon().getName());
            }else{
                System.out.println("Arme: Aucune arme équipée");
            }
            if(aPlayer.getArmor()!=null){
                System.out.println("Armure: "+ aPlayer.getArmor().getName());
            }else{
                System.out.println("Armure: Aucune armure équipée");
            }
            System.out.println("----------------------------------------");
        
        }
    }

    /**
     *
     * @return
     */
    @Override
    public Personnage getResponse() {
        
        do{
            System.out.println("Quel est le personnage selectionné (0 pour ne selectionner personne):");
            entry = KeyboardInput.getInput();
        }while(!isValid());
        
        int selectedIndex = Integer.parseInt(entry)-1;
        if(selectedIndex <0){
            return null;
        }
        return  allPlayers.get(selectedIndex);
    }
    
    private boolean isValid(){
        boolean valid = true;
        valid = valid & Validator.checkEmpty(entry);
        if(!valid){
            return valid;
        }
        
        valid = valid & Validator.checkIsInteger(entry);
        if(!valid){
            return valid;
        }
        
        valid = valid & Validator.checkRange(Integer.parseInt(entry), 0, allPlayers.size());
        return valid;
    }

    /***
     * Display to the player the list of all players (to make a choice)
     */
    public void chooseAPlayer() {
        System.out.println("Choisissez un joueur : ");
        this.loadHUD();
    }

    
}
