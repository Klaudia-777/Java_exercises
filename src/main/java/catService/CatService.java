package catService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

import static catService.MainService.*;

class CatService {

    private Pattern patternName = Pattern.compile("[A-Z][a-z]{1,20}");
    private Pattern patternOwner = Pattern.compile("[A-Z][a-z]{1,20}\\s[A-Z][a-z]{1,20}");

    // METHODS

    private String getInfoFromUser() {
        return sc.nextLine();
    }

    void printObject(Cat catObject) {
        System.out.println(ANSI_YELLOW + "\nPET'S DATA:\nName: " + catObject.getName() + "\n"
                + "Owner:" + catObject.getPetKeeper() + ANSI_RESET);
        try {
            System.out.println(ANSI_YELLOW + "Date of adoption: " + catObject.getDate().toString() + "\n"
                    + "Weight: " + catObject.getWeight() + "\n" + ANSI_RESET);
        } catch (NullPointerException npe) {
            System.out.println(ANSI_RED + "No date entered!\n" + ANSI_RESET);
        }
    }

    void enterNameAndOwner(Cat catObject) {
        String name = "";
        String owner = "";
        System.out.println("Enter cat's name and owner:");

        // SETTING CAT'S NAME:

        System.out.println("Name:");
        do {
            try {
                name = getInfoFromUser();
                if (!name.matches(patternName.toString())) throw new MyException();
                else catObject.setName(name);
            } catch (MyException me) {
                System.out.println(ANSI_RED + "Błędny format.\nWpisz: Imię" + ANSI_RESET);
            }
        } while (catObject.getName() == null);


        // SETTING OWNER:

        System.out.println("Owner:");
        do {
            try {
                owner = getInfoFromUser();
                if (!owner.matches(patternOwner.toString())) throw new MyException();
                else catObject.setPetKeeper(owner);

            } catch (MyException me) {
                System.out.println(ANSI_RED + "Błędny format.\nWpisz: Imię Nazwisko" + ANSI_RESET);
            }
        } while (catObject.getPetKeeper() == null);
    }

    void readAndReturnDate(Cat catObject) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = null;
        do {
            try {
                System.out.println("Enter date of adoption:");
                date = LocalDate.parse(sc.nextLine());
                catObject.setDate(date);
            } catch (DateTimeParseException dtpe) {
                System.out.println(ANSI_RED + "Wrong date format" + ANSI_RESET);
            }
        } while (catObject.getDate() == null);
    }

    void readAndReturnWeight(Cat catObject) {
        double weight = 0.0;
        do {
            try {
                System.out.println("Enter weight:");
                weight = Double.parseDouble(sc.nextLine());
                catObject.setWeight(weight);
            } catch (NumberFormatException nfe) {
                System.out.println(ANSI_RED + "Wrong weight format." + ANSI_RESET);
            }
        } while (catObject.getWeight() == 0.0);
        printObject(catObject);
    }
}
