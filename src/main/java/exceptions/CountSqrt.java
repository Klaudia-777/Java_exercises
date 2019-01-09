package exceptions;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Math.sqrt;

public class CountSqrt {

    public static void main(String [] args) {

       while(true){
        try{
            System.out.println(countSqrt());
        }catch(InputMismatchException i){
            System.out.println("Podaj integera!");
        }
       }
    }

    public static double countSqrt() {
        System.out.println("Pierwiastek z ... ?");
        Scanner odczyt = new Scanner(System.in);
        int liczba=odczyt.nextInt();
        if(liczba<0) throw new IllegalArgumentException("Błąd: PIERWIASTEK Z LICZBY UJEMNEJ!");
        return sqrt(liczba);
    }

}
