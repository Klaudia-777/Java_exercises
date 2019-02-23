package caesarCipher;

import java.util.ArrayList;
import java.util.List;

public class CaesarCipher {
    public static int roundDouble(double doubleNumber) {
        if (doubleNumber - ((int) doubleNumber) > 0) return (int) doubleNumber + 1;
        return (int) doubleNumber;
    }

    private static char shift(char character, int shift) {
        if (Character.isAlphabetic(character) && Character.isLowerCase(character)) {
            int realShift = shift % 26;
            int moved = (int) character + realShift;
            if (moved > (int) 'z') {
                int diff = moved - 'z' - 1;
                character = (char) ('a' + diff);
            } else character = (char) ((int) character + realShift);
        } else if (Character.isAlphabetic(character) && Character.isUpperCase(character)) {
            int realShift = shift % 26;
            int moved = (int) character + realShift;
            if (moved > (int) 'Z') {
                int diff = moved - 'Z' - 1;
                character = (char) ('A' + diff);
            } else character = (char) ((int) character + realShift);
        }
        return character;
    }


    private static char deShift(char character, int shift) {
        if (Character.isAlphabetic(character) && Character.isLowerCase(character)) {
            int realShift = shift % 26;
            int moved = (int) character - realShift;
            if (moved < (int) 'a') {
                int diff = 'a' - moved - 1;
                character = (char) ('z' - diff);
            } else character = (char) ((int) character - realShift);
        } else if (Character.isAlphabetic(character) && Character.isUpperCase(character)) {
            int realShift = shift % 26;
            int moved = (int) character - realShift;
            if (moved < (int) 'A') {
                int diff = 'A' - moved - 1;
                character = (char) ('Z' - diff);
            } else character = (char) ((int) character - realShift);
        }
        return character;
    }


    public static List<String> movingShift(String s, int shift) {
        List<String> listToReturn = new ArrayList<>();
        int firstFourParts = roundDouble((double) s.length() / (double) 5);
        int count = 0;
        char[] string = s.toCharArray();

        StringBuilder listElement = new StringBuilder();

        for (int i = 0; i < string.length; i++) {
            if (count == firstFourParts) {
                listToReturn.add(listElement.toString());
                listElement.delete(0, listElement.length());
                count = 0;
            }
            if (Character.isAlphabetic(string[i])) {
                string[i] = shift(string[i], shift);
            }
            listElement.append(string[i]);
            count++;

            shift++;
        }

        listToReturn.add(listElement.toString());
        if (listToReturn.size()==4) listToReturn.add("");
        System.out.println(listToReturn);
        return listToReturn;
    }

    public static String demovingShift(List<String> s, int shift) {
        StringBuilder stringToEncode = new StringBuilder();
        for (String it : s) {
            for (int i = 0; i < it.length(); i++) {
                if (Character.isAlphabetic(it.charAt(i))) {
                    stringToEncode.append(deShift(it.charAt(i), shift));
                } else stringToEncode.append(it.charAt(i));
                shift++;
            }
        }
        return stringToEncode.toString();
    }

    public static void main(String[] arg) {

        System.out.println(demovingShift(movingShift("I should have known that you would have a perfect answer for me!!!", 1),1));
    }
}