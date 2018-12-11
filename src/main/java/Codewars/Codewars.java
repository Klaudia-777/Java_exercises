package Codewars;


import java.util.*;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
       int count=0;
        for (int element:elements) {
            count=1;

            for (Integer aStore : store) {
                if (aStore == element) count++;
            }

            if(!Numbers.containsKey(element)) Numbers.put(element,1);
            else {
                Numbers.put(element, count);
            }
            store.add(element);
            if(count<=maxOccurrences) nowa.add(element);
        }


        System.out.println(nowa);
        int [] result =new int[nowa.size()];
        for (int i = 0; i < nowa.size(); i++) {
            result[i]=nowa.get(i);
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
        if(k>strarr.length || k<=0) return "";
        int length=0;
        int max=0;
        int index=0;
        String result="";
        var stringBuilder = new StringBuilder();
        for (int i=0;i<strarr.length-k+1;i++) {
            for(int j=0;j<k;j++){
                length+=strarr[i+j].length();
            }
            if(length>max) {
                max=length;
                index=i;
            }
            length=0;
        }
        for (int i = 0; i < k; i++) {
            stringBuilder.append(strarr[index+i]);
        }
        result=stringBuilder.toString();
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


/////////////////////////////////////////////////CLEVER!!!!!!!!!!


    public static String createPhoneNumber(int[] numbers) {
        String phoneNumber = new String("(xxx) xxx-xxxx");

        for (var i : numbers) {
            phoneNumber = phoneNumber.replaceFirst("x", Integer.toString(i));
        }

        return phoneNumber;
    }


        public static boolean isValid(char[] walk) {
            if(walk.length!=10) return false;
            int count=0;
            for (char it:walk) {
            if(it=='s'||it=='w') count++;
            else count--;
            }
            return count==0;
        }


    public static String[] inArray(String[] array1, String[] array2) {
        List <String> result = new ArrayList<>();
        for (String anArray2 : array2)
            for (String anArray1 : array1)
                if (anArray2.contains(anArray1) && !result.contains(anArray1)) result.add(anArray1);

       Collections.sort(result);
        return result.toArray(new String[0]);
    }



    /*
                    ----~MAIN~----
                                                   */


    public static void main(String[] arg) {
        //countKprimes(5, 500, 600);
        //deleteNth(new int[]{1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1 }, 3);

        String [] kk = new String [] {"itvayloxrp","wkppqsztdkmvcuwvereiupccauycnjutlv","vweqilsfytihvrzlaodfixoyx"};
        Object [] ms = Arrays.stream(kk).filter(n -> (n.length()>10)).toArray();

        for (Object it:ms) {
            System.out.println(it);

        }
        longestConsec(new String [] {"itvayloxrp","wkppqsztdkmvcuwvereiupccauycnjutlv","vweqilsfytihvrzlaodfixoyx"}, 2);
        createPhoneNumber(new int[] {1,2,3,4,5,6,7,8,9});
       System.out.println( isValid(new char[] {'n','n','n','s','n','s','n','s','n','s'}));



        String a[] = new String[]{ "arp", "live", "strong" };
        String b[] = new String[] { "klaudia","harp", "sharp", "armstrong" };
        String r[] = new String[] { "arp", "live", "strong" };
        System.out.println(inArray(a, b)[0]);
    }
}

