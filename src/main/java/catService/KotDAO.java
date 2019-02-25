package catService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class KotDAO {
    private static List<Cat> cats = new ArrayList<>();

    public static List<Cat> getCats() {
        return cats;
    }

    static void addCatToList(Cat cat) {
        cats.add(cat);
    }

    static void printList() {
        System.out.println("\nCurrent list of adopted cats:");
        AtomicInteger count = new AtomicInteger();
        cats.forEach(n -> {
            System.out.println(count + " " + n.getName());
            count.getAndIncrement();
        });
    }
}
