package laboratorium1;

import java.util.*;

public class FinalExercises {

    void changeVar(final double var){
     // var+=8;                         //can't change value of variable type final
    }
    void changeList ( final List<Double> lista)    {
        lista.add(3.14);
        lista.add(4.8);
        lista.remove(0);
    }

}
