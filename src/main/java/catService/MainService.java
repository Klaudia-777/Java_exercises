package catService;

import java.util.Scanner;

public class MainService {

    private static CatService catService = new CatService();

    // FINAL USER INPUT SCANNER

    public static final Scanner sc = new Scanner(System.in);
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    // METHODS

    public static void addCatToList() {
        Cat cat = new Cat();
        catService.enterNameAndOwner(cat);
        catService.readAndReturnDate(cat);
        catService.readAndReturnWeight(cat);
        KotDAO.addCatToList(cat);
    }

    public static void chooseACat() {
        KotDAO.printList();
        System.out.println("\nChoose cat's #:");
        int enteredHash = sc.nextInt();
        if (KotDAO.getCats().size() <= enteredHash) {
            System.out.println(ANSI_RED + "There's no such cat. Try again." + ANSI_RESET);
            chooseACat();
        } else {
            catService.printObject(KotDAO.getCats().get(enteredHash));
        }
    }
}
