package comparatorComparableEx;

import java.util.Comparator;

public class NazwiskoCompare implements Comparator<Pracownik> {
    @Override
    public int compare(Pracownik pracownik1,Pracownik pracownik2){
        return pracownik1.getNazwizko().compareTo(pracownik2.getNazwizko());
    }
}
