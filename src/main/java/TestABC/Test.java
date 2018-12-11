package TestABC;

import pkg1.A;
import pkg1.B;
import pkg2.C;

public class Test {

    public static void main (String [] argv){
      String name="Ola";
      int number=9;

        A a=new A(number,name);
        B b=new B(number,name);
        C c=new C(number,name);

        System.out.println(a.getName());
        System.out.println(a.getNumber());

        a.callChangeName();
        b.callDecrement();
        c.callChangeName();

        System.out.println(a.getName());
        System.out.println(a.getNumber());

        System.out.println(b.getName());
        System.out.println(b.getNumber());
        System.out.println(c.getName());

    }
}
