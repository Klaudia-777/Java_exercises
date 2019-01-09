package comparatorComparableEx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


 public class Pancake implements MyPancake{
    public static void main(String [] arg){
        List<String> x=new ArrayList<>();
        x.add("3");
        x.add("7");
        x.add("5");
        List <String> y = new Pancake().doStuff(x);
        y.add("1");
        System.out.println(x);
        Pancake  o = new Pancake();


        int [] a ={1,2,3};
        int [] b = a;
        System.out.println(Arrays.toString(b));

    }
     public List<String> doStuff(List<String> k){
         k.add("9");
         return k;
     }

}
 interface MyPancake {
    List<String> doStuff(List<String> a);
    static void display(){
        System.out.println("OOOOOOOOOOOOO");
    }
}