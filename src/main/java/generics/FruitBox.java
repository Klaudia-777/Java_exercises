package generics;

public class FruitBox {
    private Object fruit;

    public FruitBox(Object fruit) {
        this.fruit = fruit;
    }

    public Object getFruit() {
        System.out.println(fruit);
        return fruit;
    }

    public static void main(String[] args) {
        FruitBox fruitBox = new FruitBox(new Orange());
        //Orange fruit1 = (Orange) fruitBox.getFruit();  //rzutowanie

        BoxOnSteroids<Orange> orangeBox = new BoxOnSteroids<>(new Orange());   //generics-y

        Orange fruit = orangeBox.getFruit();

        Pair<BoxOnSteroids<Orange>, BoxOnSteroids<Apple>> pairOfBoxes =
                new Pair<>(
                        new BoxOnSteroids<>(new Orange()),
                        new BoxOnSteroids<>(new Apple())
                );
        System.out.println(pairOfBoxes.getFirst());
        System.out.println(pairOfBoxes.getSecond());

    }
}