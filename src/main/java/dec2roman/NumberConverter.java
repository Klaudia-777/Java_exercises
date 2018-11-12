package dec2roman;

import java.util.*;

public class NumberConverter {

    private List<Pair<Integer, String>> myMap = new ArrayList<>();


    public NumberConverter() {
        myMap.add(new Pair<>(1000, "M"));
        myMap.add(new Pair<>(900, "CM"));
        myMap.add(new Pair<>(500, "D"));
        myMap.add(new Pair<>(400, "CD"));
        myMap.add(new Pair<>(100, "C"));
        myMap.add(new Pair<>(90, "XC"));
        myMap.add(new Pair<>(50, "L"));
        myMap.add(new Pair<>(40, "XL"));
        myMap.add(new Pair<>(10, "X"));
        myMap.add(new Pair<>(9, "IX"));
        myMap.add(new Pair<>(5, "V"));
        myMap.add(new Pair<>(4, "IV"));
        myMap.add(new Pair<>(1, "I"));
    }

    public String decToRoman(Integer decimal) {
        String result = "";

        for (Pair<Integer, String> it : myMap) {
            int tmp = decimal / it.first;
            if (tmp > 0 & tmp < 4) {
                for (int i = 0; i < tmp; i++) {
                    result += it.second;
                }
                decimal %= it.first;
            }
        }
        return result;
    }

    public int romanToDec(String roman) {
        int result = 0;


        for (Pair<Integer, String> it : myMap) {
            if (it.second.length() == 2 && roman.contains(it.second)) {
                result += it.first;
                roman = roman.replace(it.second, "");
            } else {
                while (roman.startsWith(it.second)) {
                    result += it.first;
                    roman = roman.substring(1);

                }
            }

        }
        return result;
    }
}
