package points;

import java.util.*;

public class Test {
    private static List<Point3D> punkty=new LinkedList<>();

    public static void main(String[] args) {
        int choice = 0;
        Scanner S = new Scanner(System.in);

        while(choice!=4){
            System.out.println(" 1. Wczytaj punkt 3D");
            System.out.println(" 2. Wyświetl wszystkie punkty");
            System.out.println(" 3. Oblicz odległość");
            System.out.println(" 4. Zakończ");



            choice = S.nextInt();

            switch (choice) {
                case 1:
                    double coordinateX = S.nextDouble();
                    double coordinateY = S.nextDouble();
                    double coordinateZ = S.nextDouble();
                    Point3D point = new Point3D(coordinateX, coordinateY, coordinateZ);
                    punkty.add(point);
                    break;
                case 2:
                    System.out.println(punkty);
                    break;
                case 3:
                    int first = S.nextInt();
                    int second = S.nextInt();

                    if (punkty.size() >= 2 && first < punkty.size() && second < punkty.size()) {
                        System.out.println(punkty.get(first).distance(punkty.get(second)));
                    }
                    break;
                case 4:
                    break;
            }

        }

}}
