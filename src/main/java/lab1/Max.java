package lab1;

import java.util.Scanner;

public class Max {


    public static void main(String[] argv){
    int a,b,c;
    a=2;
    b=2;
    c=3;

    if (a>b){
        if(a>c) System.out.println("a is max");
        else if(a<c) System.out.println("c is max");
    }
    else{
        if(b>c) System.out.println("b is max");
        else if(b<c) System.out.println("c is max");
    }

    Scanner number1=new Scanner(System.in);

    double first=number1.nextDouble();
    double second=number1.nextDouble();

    System.out.println(first+"+"+second+"="+(first+second));

    }


}
