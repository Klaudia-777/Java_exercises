package catService;

import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static boolean isAppOn = true;

    private static void displayMenu() {
        System.out.println("CHOOSE AN OPTION:");
        System.out.println("1. Add a cat to list.");
        System.out.println("2. Display all the cats.");
        System.out.println("x. Exit");
    }

    private static void chooseAnOption() {
        String enteredCharacter = sc.next();
        switch (enteredCharacter) {
            case "1":
                isAppOn = true;
                MainService.addCatToList();
                break;
            case "2":
                isAppOn = true;
                MainService.chooseACat();
                break;
            case "x":
                isAppOn = false;
                break;
            default:
                System.out.println("You have to try again.");
                chooseAnOption();
                break;
        }
    }

    public static void main(String[] arg) {
        while (isAppOn) {
            displayMenu();
            chooseAnOption();
        }
    }
}
