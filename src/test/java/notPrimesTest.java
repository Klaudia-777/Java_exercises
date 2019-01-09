import codewars.Codewars;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class notPrimesTest {
    @Test

    public void test(){
        Codewars codewars=new Codewars();
        Assertions.assertEquals(Arrays.asList(22, 25, 27, 32, 33, 35, 52, 55, 57, 72, 75, 77),Codewars.notPrimes(2,222));
        Assertions.assertEquals(Arrays.asList(2722, 2723, 2725, 2727, 2732, 2733, 2735, 2737, 2752, 2755, 2757, 2772, 2773, 2775),Codewars.notPrimes(2700,3000));
    }


}
