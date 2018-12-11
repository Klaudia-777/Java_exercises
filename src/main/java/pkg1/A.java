package pkg1;

public class A {
    String name;
    protected int number;

    public A(int number,String name){
        this.name=name;
        this.number=number;
    }
    public void callDecrement(){
        decrement();
    }
    public void callChangeName(){
        changeName();
    }
    public void callIncrement(){
        increment();
    }
    private void increment(){
        number+=1;
   //    System.out.println(number);
    }
    protected void decrement(){
        number-=1;
    //    System.out.println(number);
    }
    void changeName(){
        name= "Klaudia";
   //     System.out.println(name);
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }
}
