package hackerRank;

import pkg2.C;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Math.toIntExact;

public class HackerRank {
    static int sockMerchant(int n, int[] ar) {
        Map<Integer, Integer> mapa = new HashMap<>();
        int count = 0;
        int numberOfPairs = 0;
        int ss = 0;
        for (int anAr : ar) {
            if (!mapa.containsKey(anAr)) mapa.put(anAr, 1);
            else {
                count = mapa.get(anAr);
                mapa.put(anAr, count + 1);
            }
        }
        for (int i = 0; i < mapa.values().size(); i++) {
            ss = (int) mapa.values().toArray()[i];
            if ((int) mapa.values().toArray()[i] % 2 == 1) {
                mapa.put((int) mapa.keySet().toArray()[i], ss - 1);
            }
            numberOfPairs += (int) mapa.values().toArray()[i] / 2;
        }
        return numberOfPairs;
    }

    static int countingValleys(int n, String s) {
        boolean firstDown = false;
        int countMoves = 0;
        int countValleys = 0;
        for (int i = 0; i < n; i++) {
            if (countMoves == 0 && s.charAt(i) == 'U') firstDown = false;
            if (countMoves == 0 && s.charAt(i) == 'D') firstDown = true;

            if (s.charAt(i) == 'D') countMoves--;
            else if (s.charAt(i) == 'U') countMoves++;
            if (firstDown && countMoves == 0) countValleys++;
        }
        return countValleys;
    }

    static int jumpingOnClouds(int[] c) {
        int start = 0;
        if (c[0] == 1) start = 1;
        List<Integer> step = new ArrayList<>();
        step.add(start);
        for (int i = start; i < c.length; ) {
            if (i == c.length - 1) break;
            if (i + 2 < c.length && c[i + 2] == 0) {
                step.add(i + 2);
                i += 2;
            } else if (c[i + 1] == 0) {
                step.add(i + 1);
                i += 1;
            }
        }
        System.out.println(step);
        return step.size() - 1;
    }

    static int tryLinkedList() {
        LinkedList<Integer> lista;
        lista = new LinkedList<>();
        lista.add(5);
        lista.add(6);
        lista.add(7);
        lista.addFirst(4);
        System.out.println(lista);
        lista.remove(0);
        System.out.println(lista);
        int obj = lista.get(2);
        System.out.println(obj);

        return obj;

    }

    static long repeatedString(String s, long n) {
        long counter = Arrays.stream(s.split("")).filter(u -> u.equals("a")).count();
        Long rest = n % s.length();
        long count = Arrays.stream(s.substring(0, rest.intValue()).split("")).filter(u -> u.equals("a")).count();
        return count + n / s.length() * counter;
    }

    static int hourglassSum(int[][] arr) {
        List<Integer> sums = new LinkedList<>();
        int sum = 0;
        for (int k = 0; k < 4; k++) {
            for (int i = 0; i < 4; i++) {
                sum = (arr[i][k] + arr[i][k + 1] + arr[i][k + 2] + arr[i + 1][k + 1] + arr[i + 2][k] + arr[i + 2][k + 1] + arr[i + 2][k + 2]);
                System.out.println(sum);
                sums.add(sum);
                sum = 0;
            }
        }
        return sums.stream().max(Comparator.comparing(Integer::intValue)).get();
    }

    public static void display(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
    }


    static void minimumBribes(int[] q) {
        int count = 0;
        boolean isTooMany = false;
        for (int i = 0; i < q.length; i++) {
            if (q[i] - (i + 1) > 0) {
                count += q[i] - (i + 1);
                if (q[i] - (i + 1) > 2) {
                    isTooMany = true;
                }
            }
        }
        if (isTooMany) System.out.println("Too chaotic");
        else
            System.out.println(count);

    }

    static int maximumToys(int[] prices, int k) {
        Arrays.sort(prices);
        int count = 0;
        for (int i = 0; i < prices.length; i++) {
            if (k >= prices[i]) {
                count++;
                k -= prices[i];
            }
        }
        return count;
    }

    static int minimumSwaps(int[] arr) {
        Map<Integer, Integer> toSwap = new HashMap<>();
        ArrayList<Integer> toS = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) toSwap.put(arr[i], i);
        }
        int min = 0;
        for (int i = min; i < toS.size(); i++) {
            toSwap.get(toSwap.keySet().stream().min(Comparator.comparing(Integer::intValue)));
        }
        System.out.println(toS);
        return 0;
    }




    static int makeAnagram(String a, String b) {
        Map<String,Integer> map1 = Arrays.stream(a.split("")).collect(Collectors.toMap(s -> s, s -> Collections.frequency(Arrays.asList(a.split("")), s), (c, d) -> d));
        Map<String,Integer> map2 = Arrays.stream(b.split("")).collect(Collectors.toMap(s -> s, s -> Collections.frequency(Arrays.asList(b.split("")), s), (c, d) -> d));

        int count = Arrays.stream(a.split("")).parallel().filter(b::contains).distinct().mapToInt(n->{
            Integer m=map1.get(n);
            Integer p=map2.get(n);
            if(m>p) return p;
            else return m;
        }).sum();
        return a.length()-count+b.length()-count;
    }

    /**
     * Main *
     * `             *
     **/

    public static void main(String[] args) {
        System.out.println(makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke"));
    }
}
