package generics;

public class BoxForFigures<T extends Figure> {
    private T element;

    public BoxForFigures(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public String getElementName() {
        return element.getName();
    }



    public static void main(String[] arg){
        BoxForFigures<Circle> circle=new BoxForFigures<>(new Circle());
        System.out.println(circle.getElementName());
        BoxForFigures<Apple> apple=new BoxForFigures<>(new Apple());
        System.out.println(apple.getElementName());
    }




}
