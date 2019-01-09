package exceptions;

import static java.lang.Math.sqrt;

public class MathOperation {
    public static double sqrt1(double number) throws NegativeNumberException {
        if(number<0) throw new NegativeNumberException();
        return sqrt(number);
    }
    public static void main(String [] args) {
        try {
            sqrt1(-1);
        } catch (NegativeNumberException e) {
            e.printStackTrace();
        }

        getFirstLetter("");


    }
    public static char getFirstLetter(String word){
        if(word.length()<=0) throw new WordDoesntExistException();
        return word.charAt(0);
    }
}
