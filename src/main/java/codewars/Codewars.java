package codewars;

/**
 * SOLVED KATA'S
 * RANKS 8 to 5
 **/

import lombok.var;

import java.util.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;


public class Codewars {

    public static String getMiddle(String word) {
        if (word.length() % 2 == 1) return Character.toString(word.charAt(word.length() / 2));
        return Character.toString(word.charAt(word.length() / 2 - 1)) + Character.toString(word.charAt(word.length() / 2));
    }

    public static int digital_root(int n) {
        String str = Integer.toString(n);
        int digital_root = 0;
        while (str.length() > 1) {
            for (int i = 0; i < str.length(); i++) {
                digital_root += str.charAt(i) - '0';
            }
            str = Integer.toString(digital_root);
            digital_root = 0;
        }
        return digital_root;
    }


    public static long[] countKprimes(int k, long start, long end) {
        long[] tab = new long[0];
        ArrayList<Long> divisors = new ArrayList<Long>();
        for (long i = start; i < end; i++) {
            for (long j = 1; j <= i / 2; j++) {
                if (i % j == 0) divisors.add(j);
            }
            long number = i;
            int count = 0;
            while (number > 1) {
                for (int j = 0; j < divisors.size(); j++) {
                    if (number % divisors.get(j) == 0) {
                        number /= divisors.get(j);
                        count++;
                    }
                }
            }
            if (count == k) addElement(tab, i);
        }
        System.out.println(tab);
        return tab;
    }

    static long[] addElement(long[] org, long added) {
        long[] result = Arrays.copyOf(org, org.length + 1);
        result[org.length] = added;
        return result;
    }


    public boolean getXO(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.toLowerCase().charAt(i) == 'x') count++;
            else if (str.toLowerCase().charAt(i) == 'o') count--;
        }
        return count == 0;
    }

    public static int[] deleteNth(int[] elements, int maxOccurrences) {


        ////////////////----  SPOSOB NR1  ----//////////////////

//        List<Integer> list_elements = new ArrayList<Integer>();
//        List<Integer> to_save = new ArrayList<Integer>();
//        List<Integer> to_remove = new ArrayList<Integer>();
//        for (int it : elements) {
//            list_elements.add(it);
//        }
//        int count=0;
//
//
//        for (int i=0;i<elements.length;i++) {
//            //int count = 0;
//
//            for (int j=0;j<elements.length;j++) {
//                if (elements[i]==elements[j]) {
//                    count++;
//                    if (count > maxOccurrences) to_save.add(j);
//                   // System.out.println(elements[j]);
//                }
//            }
//         count=0;
//        }
//
//        List<Integer> nowa= new ArrayList<Integer>();
//        for (int l = 0; l < to_save.size(); l++) {
//            if(nowa.contains(to_save.get(l))) l++;
//            else nowa.add(to_save.get(l));
//
//        }
//
//        int licz=0;
//        Collections.sort(nowa);
//        for(int t=0;t<nowa.size();t++){
//            licz=nowa.get(t);
//            if(t!=0) licz=licz-t;
//            list_elements.remove(licz);
//
//        }
//        int [] result =new int[list_elements.size()];
//        for (int i = 0; i < list_elements.size(); i++) {
//            result[i]=list_elements.get(i);
//        }
//        System.out.println(list_elements);
//
//        return result;}


        ////////////////----  SPOSOB NR2  ----//////////////////


//        int count = 0;
//        List<Integer> to_save = new ArrayList<Integer>();
//
//        for (int element : elements) {
//            for (int j = 0; j < elements.length; j++) {
//                if (element == elements[j]) {
//                    count++;
//                    if (count <= maxOccurrences) to_save.add(j);
//                }
//            }
//            count = 0;
//        }
//
//        List<Integer> nowa= new ArrayList<Integer>();
//        for (Integer aTo_save : to_save) {
//            if (!nowa.contains(aTo_save)) nowa.add(aTo_save);
//        }
//
//        Collections.sort(nowa);
//        int [] result =new int[nowa.size()];
//        for (int i = 0; i < nowa.size(); i++) {
//            result[i]=elements[nowa.get(i)];
//        }
//        return result;}


        ////////////////----  SPOSOB NR3  ----//////////////////


//        List<Pair<Integer,Integer>> Numbers = new ArrayList<Pair<Integer,Integer>>();
//        List<Integer> store = new ArrayList<Integer>();
//        int repeat=0;
//        for (int element : elements) {
//            repeat=1;
//            for (Integer aStore : store) {
//                if (aStore == element) repeat++;
//            }
//            if (!store.contains(element)){
//                Numbers.add(new Pair<Integer,Integer>(element,1));
//            }
//
//            else if(store.contains(element)){
//                Numbers.add(new Pair<Integer, Integer>(element, repeat));
//            }
//            store.add(element);
//            }
//
//        List<Integer> nowa = new ArrayList<Integer>();
//        for (Pair<Integer, Integer> it : Numbers){
//           if(it.second <= maxOccurrences )nowa.add(it.first);
//        }
//
//
//        int [] result =new int[nowa.size()];
//        for (int i = 0; i < nowa.size(); i++) {
//            result[i]=nowa.get(i);
//        }
//        System.out.println(nowa);
//        return result;
//    }

        ////////////////----  SPOSOB NR4  ----//////////////////

        Map<Integer, Integer> Numbers = new HashMap<>();
        List<Integer> nowa = new ArrayList<Integer>();
        List<Integer> store = new ArrayList<Integer>();
        int count = 0;
        for (int element : elements) {
            count = 1;

            for (Integer aStore : store) {
                if (aStore == element) count++;
            }

            if (!Numbers.containsKey(element)) Numbers.put(element, 1);
            else {
                Numbers.put(element, count);
            }
            store.add(element);
            if (count <= maxOccurrences) nowa.add(element);
        }


        System.out.println(nowa);
        int[] result = new int[nowa.size()];
        for (int i = 0; i < nowa.size(); i++) {
            result[i] = nowa.get(i);
        }
        return result;
    }


///////////////// v1


//    public static String longestConsec(String[] strarr, int k) {
//    List<String> arr=new ArrayList<>();
//    List<String> tacoma=new ArrayList<>();
//    String result="";
//    List<Integer> pos=new ArrayList<>();
//
//        Collections.addAll(arr, strarr);
//        Collections.addAll(tacoma,strarr);
//
//        List<String> withoutDupes = arr.stream().distinct().collect(Collectors.toList());
//
//        for (int i=0;i<k;i++){
//        String maxLength = withoutDupes.stream().max(Comparator.comparing(String::length)).get();
//        pos.add(tacoma.indexOf(maxLength));
//        withoutDupes.remove(maxLength);
//        }
//        Collections.sort(pos);
//        System.out.println(tacoma);
//        var stringBuilder = new StringBuilder();
//        for (Integer po : pos) {
//            stringBuilder.append(tacoma.get(po));
//        }
//        result=stringBuilder.toString();
//        System.out.println(result);
//    return result;
//    }


    //////////////// v2


    public static String longestConsec(String[] strarr, int k) {
        if (k > strarr.length || k <= 0) return "";
        int length = 0;
        int max = 0;
        int index = 0;
        String result = "";
        var stringBuilder = new StringBuilder();
        for (int i = 0; i < strarr.length - k + 1; i++) {
            for (int j = 0; j < k; j++) {
                length += strarr[i + j].length();
            }
            if (length > max) {
                max = length;
                index = i;
            }
            length = 0;
        }
        for (int i = 0; i < k; i++) {
            stringBuilder.append(strarr[index + i]);
        }
        result = stringBuilder.toString();
        System.out.println(result);
        return result;
    }


//
//    public static String createPhoneNumber(int[] numbers) {
//        String result="(";
//        for(int i=0;i<numbers.length;i++){
//            if(i==3) result+=") ";
//            else if( i==6) result+="-";
//            result+=numbers[i];
//        }
//        System.out.println(result);
//        return result;
//    }


    public static String createPhoneNumber(int[] numbers) {
        String phoneNumber = new String("(xxx) xxx-xxxx");

        for (var i : numbers) {
            phoneNumber = phoneNumber.replaceFirst("x", Integer.toString(i));
        }

        return phoneNumber;
    }


    public static boolean isValid(char[] walk) {
        if (walk.length != 10) return false;
        int count = 0;
        for (char it : walk) {
            if (it == 's' || it == 'w') count++;
            else count--;
        }
        return count == 0;
    }


    public static String[] inArray(String[] array1, String[] array2) {
        List<String> result = new ArrayList<>();
        for (String anArray2 : array2)
            for (String anArray1 : array1)
                if (anArray2.contains(anArray1) && !result.contains(anArray1)) result.add(anArray1);

        Collections.sort(result);
        return result.toArray(new String[0]);
    }


    public static List<Integer> sqInRect(int lng, int wdth) {
        List<Integer> mySquares = new ArrayList<Integer>();
        int area = lng * wdth;
        while (area > 0) {
            if (lng > wdth) {
                mySquares.add(wdth);
                lng -= wdth;
            } else if (lng < wdth) {
                mySquares.add(lng);
                wdth -= lng;
            }
            area = lng * wdth;
        }
        return mySquares;
    }

    public static int countDeafRats(final String town) {
        town.replace(" ", "");
        int count = 0;
        for (int i = 0; i < town.length(); i += 2) {
            if (town.charAt(i) == 'O') count++;
        }
        return count;
    }


    public static String HighAndLow(String numbers) {
        String result = "";
        List<String> arr = new ArrayList<String>();
        result += Arrays.stream(numbers.split(" ")).mapToInt(Integer::valueOf).max().getAsInt();
        result += Arrays.stream(numbers.split(" ")).mapToInt(Integer::valueOf).min().getAsInt();


        return result;
    }

    public static String NOWA(String numbers) {
        String result = "";
        List<String> arr = Arrays.stream(numbers.split(" ")).filter(n -> n.length() % 2 == 0).collect(Collectors.toList());
        int maxLength = 0, maxIndex = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).length() > maxLength) {
                maxLength = arr.get(i).length();
                maxIndex = i;
            }
        }
        result = arr.get(maxIndex);

        return result;
    }

    static String removeExclamationMarks(String s) {
        return s.replace("!", "");
    }


    public static String autoMorphic(int number) {
        String strNumber = String.valueOf(number);
        String powNumber = String.valueOf(number * number);
        if (powNumber.endsWith(strNumber)) return "Automorphic";
        return "Not!!";
    }


    public static String meeting(String s) {
        List<String> sep = Arrays.stream(s.toUpperCase().split(";")).collect(Collectors.toList());
        StringBuilder result = new StringBuilder();

        String[] tmpArr = {"", ""};

        for (int i = 0; i < sep.size(); i++) {
            tmpArr = sep.get(i).split(":");
            sep.set(i, tmpArr[1] + ", " + tmpArr[0]);
        }

        Collections.sort(sep);
        for (String it : sep) {
            result.append("(").append(it).append(")");
        }

        System.out.println(result.toString());
        return result.toString();
    }


    public static boolean isPrime(int n) {
        if (n == 2) return true;
        for (int i = 2; i < sqrt(n) + 1; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static List<Integer> notPrimes(int a, int b) {
        return IntStream.rangeClosed(a, b - 1).filter(n -> (!isPrime(n) && !Integer.toString(n).matches(("(.*)[146890](.*)")))).boxed().collect(Collectors.toList());
    }

    public static String fromNb2Str(int n, int[] sys) {
        int val = 1;
        for (var it : sys)
            val *= it;
        if (val > n) {
            List<Integer> factors = new ArrayList<>();
            for (var it : sys) {
                for (int i = 2; i < it; i++) {
                    if (it % i == 0) factors.add(i);
                }
            }
            List<Integer> fac = factors.stream().filter(u -> Collections.frequency(factors, u) > 1).collect(Collectors.toList());
            if (fac.size() != 0) return "Not applicable";
            else {
                StringBuilder result = new StringBuilder("-");
                for (var it : sys) {
                    result.append(Integer.toString(n % it)).append("--");
                }
                return result.toString().substring(0, result.length() - 1);
            }
        }
        return "Not applicable";
    }

    public static long[] seven(long m) {
        long count = 0;
        long number = 0;
        while (Long.toString(m).length() > 2) {
            number = Long.parseLong(Character.toString(Long.toString(m).charAt(Long.toString(m).length() - 1)));
            m = Long.parseLong(Long.toString(m).substring(0, Long.toString(m).length() - 1));
            m -= 2 * number;
            count++;
        }
        return new long[]{m, count};
    }

//
//    public static String orderWeight(String strng) {
//        if (!strng.contains(" ")) return strng;
//        List<String> outputList = new ArrayList<>();
//        List<String> inputList = Arrays.asList(strng.split(" "));
//        System.out.println(inputList);
//        Map<Integer, List<String>> groupped = inputList.stream().collect(Collectors.groupingBy(n -> sumOfDigits(Long.valueOf(n))));
//        System.out.println(groupped);
//        return groupped.keySet().stream()
//                .sorted()
//                .map(index -> groupped.get(index).stream().sorted().reduce((s, s2) -> s += " " + s2).get())
//                .collect(Collectors.joining(" "));
//    }


    public static String factors(int number) {
        int n = 0;
        int k = 2;
        int tmp = 0;
        StringBuilder result = new StringBuilder();
        result.append("(");
        while (number > 1) {
            if (isPrime(k) && number % k == 0) {
                number /= k;
                //System.out.println(number);
                n++;
                tmp = k;
            } else if (isPrime(k) && number % k != 0) {
                if (n != 1 && tmp != 0 && n != 0) result.append(tmp).append("**").append(n).append(")").append("(");
                else if (n == 1) result.append(tmp).append(")").append("(");
                k++;
                n = 0;
            } else k++;
        }
        if (n != 1 && tmp != 0 && n != 0) result.append(tmp).append("**").append(n).append(")").append("(");
        else if (n == 1) result.append(tmp).append(")");
        System.out.println(result);
        //System.out.println(tmp);

        return result.toString();
    }


    public static int points(String[] games) {
        int points = 0;
        for (var it : games) {
            if (it.charAt(0) > it.charAt(2)) points += 3;
            else if (it.charAt(0) == it.charAt(2)) points += 1;
        }
        return points;
    }

    public static long sumOfDigits(long n) {
        long sum = 0;
        while (n > 0) {
            sum += n % 10;
            n = (n - n % 10) / 10;
        }
        return sum;
    }

    public static String reverseOrder(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
    }

    public static String rotateToTheLeftByOne(String str) {
        if (str.length() == 1 || str.length() == 0) return str;
        return str.substring(1) + str.charAt(0);
    }

    public static String revRot(String strng, int sz) {
        if (sz == 0 || strng == "" || strng.length() < sz) return "";
        else if (sz == 1) return strng;
        String[] arrstr = new String[strng.length() / sz];
        int counter = 0;
        StringBuilder result = new StringBuilder();

        while (strng.length() > 0) {
            if (strng.length() >= sz) {
                arrstr[counter] = strng.substring(0, sz);
                strng = strng.substring(sz);
                counter++;
            } else {
                strng = "";
            }
        }
        System.out.println(Arrays.asList(arrstr));
        for (String it : arrstr) {
            if ((sumOfDigits(Long.parseLong(it.substring(0, it.length() / 2))) + sumOfDigits(Long.parseLong(it.substring(it.length() / 2)))) % 2 == 0) {
                result.append(reverseOrder(it));
            } else {
                result.append(rotateToTheLeftByOne(it));
            }
        }
        System.out.println(result);
        return result.toString();
    }

    public static double[] tribonacci(double[] s, int n) {
        double[] tab = new double[n];
        for (int i = 0; i < n; i++) {
            if (i < s.length)
                tab[i] = s[i];
            else {
                tab[i] = tab[i - 1] + tab[i - 2] + tab[i - 3];
            }
        }
        return tab;
    }

    /**
     * ----~MAIN~----
     **/


    public static void main(String[] args) {


    }
}

