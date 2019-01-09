package exceptions;

import java.util.IllegalFormatException;

public class example {

    public static int convertIntoSeconds(int hours){
        if(hours<0) throw new IllegalArgumentException("Number of hours cannot be nagative!");
        return hours*3600;
    }

    public static void main(String[] args){
        int hours=-3;
        int seconds=0;
        try {
            System.out.println(convertIntoSeconds(hours));
        } catch(IllegalArgumentException e){
            System.out.println("Podano ujemna liczbe. Bierzemy moduł.");
            System.out.println(convertIntoSeconds(-1*hours));
        }
    }
}
