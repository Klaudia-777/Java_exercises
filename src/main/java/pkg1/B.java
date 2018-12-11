package pkg1;

import pkg1.A;

public class B extends A {

    public B(int number,String name){
        super(number,name);
    }

    @Override
    protected void decrement() {
        number-=2;
       // System.out.println(number);
    }

    @Override
    void changeName() {
        name="Weronika";
    }

    private void increment(){
        number+=2;
      //  System.out.println(number);
    }

}
