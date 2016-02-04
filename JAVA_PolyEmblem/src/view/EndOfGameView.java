package view;

/**
 * View that manage the end of the game. 
 * The game is finish when all the team is dead OR there is no more event
 * @author Lafaye, Lhopital, Paccaud
 */
public class EndOfGameView {
    
    /***
     * Load the end of the game when all the players are dead
     */
    public static void loadLooserEnding() {
        System.out.println("----------------------------------------");
        System.out.println("\n Oooooooooops !");
        System.out.println("\n Tous les membres de votre équipe sont mort !");
        System.out.println("\n Merci d'avoir joué !");        
    }
    
    /***
    * Load the end of the game when the player won
    */
    public static void loadWinnerEnding() {
       System.out.println("----------------------------------------");
       System.out.println("\n Félicitation !");
       System.out.println("\n Vous avez terminé le jeu ! Soyez fier de vous !");
       System.out.println("\n (Après tout, vous , n'êtes que la 999 999ème personne a avoir fini le jeu !)");
       System.out.println("\n Merci d'avoir joué !");        
    }
    
}
