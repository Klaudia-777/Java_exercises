package laboratorium1;

public abstract class Shape {
    public String name;

    /**
     * Metoda rysujaca w konsoli dany kształt
     */
    public abstract void draw();

    public static void main(String[] arg) {
        Square square = new Square();
        square.draw();
        System.out.println();
        Tiangle triangle = new Tiangle();
        triangle.draw();
        System.out.println();
        Shape shape = new Tiangle();
        shape.draw();
        System.out.println();
        shape = new Square();
        shape.draw();
        shape = triangle;
        System.out.println();
        shape.draw();
        square = (Square) shape;
        square.draw();
    }
}