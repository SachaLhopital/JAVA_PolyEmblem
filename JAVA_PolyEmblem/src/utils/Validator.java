package utils;

import java.util.List;

/**
 * Check if the input entered by the user is valid
 * @author Lafaye, Lhopital, Paccaud
 */
public class Validator {
    
    /**
     * Static method that check is the input is an integer
     * @param input the value to check
     * @return true if the input is an interget - false otherwise
     */
    public static boolean checkIsInteger(String input){
        try{
            Integer.parseInt(input);
        }catch(Exception e){
            System.out.println("La valeur entrée doit être un entier.");
            return false;
        }
        return true;
    }
    
    /** 
     * Check if the input is not an unexpected value
     * @param val the input to check
     * @param min the min value expected
     * @param max the max value expected
     * @return true if the input is correct - false otherwise
     */
    public static boolean checkRange(int val, int min, int max){
        boolean valid = true;
        if(val< min){
            System.out.println("La valeur entrée doit être supérieure ou égale à "+ min+ ".");
            valid = false;
        }
        if(val > max){
            System.out.println("La valeur entrée doit être inférieure ou égale à "+ max+ ".");
            valid = false;
        }
        return valid;
    }
    
    /**
     * Check if the input is in a list of expected values
     * @param val the input to check
     * @param vals a list of expected values
     * @return return true if it's correct - false otherwise
     */
    public static boolean checkInList(Object val, List<Object> vals){
        boolean valid = true;
        if(!vals.contains(val)){
            valid = false;
            System.out.println("La valeur entrée doit être incluse dans:");
            vals.stream().forEach((o) -> {
                System.out.println("\t- "+ o.toString());
            });
        }
        return valid;
    }
    
    /**
     * Check if the input is an empty string
     * @param txt the input to check
     * @return true if the input value is empty - false otherwise
     */
    public static boolean checkEmpty(String txt){
        boolean valid = true;
        if(txt.isEmpty()){
            valid = false;
            System.out.println("La chaine de caractère entrée est vide.");
        }
        return valid;
    }
}
