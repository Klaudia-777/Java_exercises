package comparatorComparableEx;

import lombok.var;

import java.util.Arrays;
import java.util.Comparator;

public class TestPracownik {
    public static void main(String[] arg) {
        Pracownik pracownicy[] = new Pracownik[5];
        pracownicy[0] = new Pracownik("Adam", "Nowak", "28");
        pracownicy[1] = new Pracownik("Karol", "Okrasa", "38");
        pracownicy[2] = new Pracownik("Pawel", "Bednarz", "22");
        pracownicy[3] = new Pracownik(null, null, null);
        pracownicy[4] = new Pracownik("Ola", "Okrasa", "31");


        System.out.println("\nNIEPOSORTOWANA TABLICA\n");
        for (var pracownik : pracownicy) {
            System.out.println(pracownik);
        }
        System.out.println("\nPOSORTOWANA TABLICA\n");
        Arrays.sort(pracownicy);
        for (var pracownik : pracownicy) {
            System.out.println(pracownik);
        }

//
//        System.out.println("IMIE->NAZWISKO->WIEK");
//        Arrays.sort(pracownicy, new Comparator<Pracownik>() {
//            @Override
//            public int compare(Pracownik o1, Pracownik o2) {
//                int porownaniePoImieniu = o1.getImie().compareTo(o2.getImie());
//                if (porownaniePoImieniu != 0) {
//                    return porownaniePoImieniu;
//                }
//                int porownaniePoNazwisku = o1.getNazwizko().compareTo(o2.getNazwizko());
//                if (porownaniePoNazwisku != 0) {
//                    return porownaniePoNazwisku;
//                }
//                return o1.getWiek().compareTo(o2.getWiek());
//
//            }
//
//        });

        System.out.println("\nsortowanie po nazwisku\n");
        Arrays.sort(pracownicy, Comparator.comparing(Pracownik::getNazwizko));
        for (Pracownik pracownik : pracownicy) {
            System.out.println(pracownik);
        }

        System.out.println("\nsortowanie po imieniu\n");
        Arrays.sort(pracownicy,new ImieCompare());
        for (Pracownik pracownik : pracownicy) {
            System.out.println(pracownik);
        }
        new Pracownik(null,"Ogr","34").wypisz();
    }
}
