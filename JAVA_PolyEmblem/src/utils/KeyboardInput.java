package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Utils to manage the keyboard Input
 * @author Lafaye, Lhopital, Paccaud
 */
public class KeyboardInput {
    
    private static final Scanner sc;
    private static final List<String> keywords;
    
    //init
    static{
        sc = new Scanner(System.in);
        keywords = new ArrayList<String>();
        
        //ajout des mots clefs
        keywords.add("moi");
        keywords.add("help");
    }
    
    /**
     * Get the current input and check if it's a keyword
     * @return the input
     */
    public static String getInput(){
        String input = sc.nextLine();
        
        //Verification des keywords
        if(keywords.contains(input)){
            // do specific stuff linked to the keywords;
        }        
        
        return input;
    }
}
