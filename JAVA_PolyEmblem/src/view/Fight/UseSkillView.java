
package view.Fight;

/**
 * View that display skill messages
 */
public class UseSkillView {

    /***
     * Display failure message when critical fail
     */
    public void displayCriticalFail() {
        System.out.println("\n----------------------------------------");
        System.out.println(" ECHEC CRITIQUE !");
        System.out.println("----------------------------------------");
    }

    /***
     * Display failure message when cannot attack
     */
    public void displayCannotAttackFail() {
        System.out.println("\n----------------------------------------");
        System.out.println("Le personnage est fatigué, il ne peut pas attaquer !");
        System.out.println("----------------------------------------");
    }
    
     /***
     * Display Critical success message
     */
    public void displayCriticalSuccess() {
        System.out.println("\n----------------------------------------");
        System.out.println(" REUSSITE CRITIQUE !");
        System.out.println("----------------------------------------");
    }

    /***
     * Display failure message when the enemis dodge
     */
    public void displayDodgeFail() {
        System.out.println("\n----------------------------------------");
        System.out.println(" L'enemis a esquivé !");
        System.out.println("----------------------------------------");
    }
    
}
