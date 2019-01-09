package comparatorComparableEx;

import java.util.Comparator;


public class ImieCompare implements Comparator<Pracownik> {
    @Override
    public int compare(Pracownik pracownik1,Pracownik pracownik2){
        return pracownik1.getImie().compareTo(pracownik2.getImie());
    }
}
